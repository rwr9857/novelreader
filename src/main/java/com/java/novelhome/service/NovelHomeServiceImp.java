package com.java.novelhome.service;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.java.aop.LogAspect;
import com.java.novelhome.dao.NovelHomeDao;
import com.java.novelhome.dto.NovelHomeDto;

@Component
public class NovelHomeServiceImp implements NovelHomeService {

	@Autowired
	private NovelHomeDao novelHomeDao;

	@Override
	public void novelhomeUploadOk(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		NovelHomeDto novelHomeDto = (NovelHomeDto) map.get("novelHomeDto");
		MultipartHttpServletRequest request = (MultipartHttpServletRequest) map.get("request");

		MultipartFile upFile = request.getFile("file");
//		LogAspect.logger.info(LogAspect.LogMsg + upFile);

		if (upFile.getSize() != 0) {
			File path = new File(
					"C:\\Users\\skcak\\Desktop\\student\\Spring\\workspace\\novelreader\\src\\main\\webapp\\images\\novelLabel\\");
			path.mkdir();
			LogAspect.logger.info(LogAspect.LogMsg + path);
			String fileName = Long.toString(System.currentTimeMillis()) + "_" + upFile.getOriginalFilename();
			long fileSize = upFile.getSize();
//			LogAspect.logger.info(LogAspect.LogMsg + fileName + fileSize);

			if (path.exists() && path.isDirectory()) {
				File file = new File(path + "\\" + fileName);
				LogAspect.logger.info(LogAspect.LogMsg + "3" + file);
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
		LogAspect.logger.info(LogAspect.LogMsg + novelHomeDto.toString());

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
		LogAspect.logger.info(LogAspect.LogMsg + n_num);

		NovelHomeDto novelHomeDto = novelHomeDao.novelHomeList(n_num);

		mav.addObject("novelHomeDto", novelHomeDto);
		mav.setViewName("novelhome/list");
	}

}
