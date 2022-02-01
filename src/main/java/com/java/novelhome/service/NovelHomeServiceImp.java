package com.java.novelhome.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.java.aop.LogAspect;
import com.java.novelhome.dao.NovelHomeDao;
import com.java.novelhome.dto.NovelHomeDto;
import com.java.novelpost.dto.NovelPostDto;

@Component
public class NovelHomeServiceImp implements NovelHomeService {

	@Autowired
	private NovelHomeDao novelHomeDao;

	@Value("#{properties['novelhome.imagepath']}")
	private String imagepath;

	@Override
	public void novelhomeUploadOk(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		NovelHomeDto novelHomeDto = (NovelHomeDto) map.get("novelHomeDto");
		MultipartHttpServletRequest request = (MultipartHttpServletRequest) map.get("request");

		MultipartFile upFile = request.getFile("file");
//		LogAspect.logger.info(LogAspect.LogMsg + upFile);

		if (upFile.getSize() != 0) {
			String fileName = Long.toString(System.currentTimeMillis()) + "_" + upFile.getOriginalFilename();
			long fileSize = upFile.getSize();
//			LogAspect.logger.info(LogAspect.LogMsg + fileName + fileSize);

			File path = new File(imagepath);
			path.mkdir();

			LogAspect.logger.info(LogAspect.LogMsg + path);


			if (path.exists() && path.isDirectory()) {
				File file = new File(path,fileName);
				try {
					upFile.transferTo(file);

					novelHomeDto.setN_image_path(file.getAbsolutePath());
					novelHomeDto.setN_image_name(fileName);
					novelHomeDto.setN_image_size(fileSize);

				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {

			}

		}

		LogAspect.logger.info(LogAspect.LogMsg + novelHomeDto.toString());
		int check = novelHomeDao.novelHomeUpload(novelHomeDto);

		int m_num = Integer.parseInt(request.getParameter("m_num"));
		LogAspect.logger.info(LogAspect.LogMsg + m_num);

		int n_num = novelHomeDao.novelHomeSelectGetNum(m_num);
		LogAspect.logger.info(LogAspect.LogMsg + n_num);

		mav.addObject("n_num", n_num);
		mav.addObject("check", check);
		mav.addObject("novelHomeDto", novelHomeDto);

		mav.setViewName("novelhome/uploadOk");
	}

	@Override
	public void novelHomeList(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int n_num = Integer.parseInt(request.getParameter("n_num"));
		LogAspect.logger.info(LogAspect.LogMsg + "n_num="+n_num);

		NovelHomeDto novelHomeDto = novelHomeDao.novelHomeList(n_num);
		
		int nNumSess = novelHomeDto.getN_num();
		
		String pageNumber = request.getParameter("pageNumber");
		if (pageNumber == null)
			pageNumber = "1";

		int currentPage = Integer.parseInt(pageNumber);
		LogAspect.logger.info(LogAspect.LogMsg + "currentPage=" + currentPage);

		int boardSize = 4;
		int startRow = (currentPage - 1) * boardSize + 1;
		int endRow = currentPage * boardSize;

		int count = novelHomeDao.getCount(n_num);
		LogAspect.logger.info(LogAspect.LogMsg + "count=" + count);

		List<NovelPostDto> novelPostList = null;
		if (count > 0) {
			novelPostList = novelHomeDao.novelPostList(startRow, endRow);
			LogAspect.logger.info(LogAspect.LogMsg + "novelPostList.size=" + novelPostList.size());
		}

		mav.addObject("novelPostList", novelPostList);
		mav.addObject("currentPage", currentPage);
		mav.addObject("boardSize", boardSize);
		mav.addObject("count", count);
		mav.addObject("novelHomeDto", novelHomeDto);
		mav.addObject("nNumSess", nNumSess);

		mav.setViewName("novelhome/list.tiles");
	}

}
