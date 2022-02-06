package com.java.novelpost.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.java.aop.LogAspect;
import com.java.comment.dto.CommentDto;
import com.java.novelpost.dao.NovelPostDao;
import com.java.novelpost.dto.NovelPostDto;

@Component
public class NovelPostServiceImp implements NovelPostService {
	@Autowired
	private NovelPostDao novelPostDao;

	@Override
	public void novelPostRegisterOk(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		NovelPostDto novelPostDto = (NovelPostDto) map.get("novelPostDto");
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int n_num = Integer.parseInt(request.getParameter("n_num"));

		LogAspect.logger.info(LogAspect.LogMsg + novelPostDto.toString());
		int check = novelPostDao.novelPostInsert(novelPostDto);
		LogAspect.logger.info(LogAspect.LogMsg + check);
//		if (ch > 0) {
//			int check = novelPostDao.novelPostSelect(n_num);
//			LogAspect.logger.info(LogAspect.LogMsg + check);
//			
//			mav.addObject("check", check);
//		}

		mav.addObject("check", check);
		mav.addObject("n_num", n_num);
		mav.setViewName("novelpost/registerOk");
	}

	@Override
	public void novelPostRead(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int n_post_num = Integer.parseInt(request.getParameter("n_post_num"));
		LogAspect.logger.info(LogAspect.LogMsg + n_post_num);
		
		NovelPostDto novelPostDto = novelPostDao.read(n_post_num);

		int n_num = novelPostDao.nNumSelect(n_post_num);
		LogAspect.logger.info(LogAspect.LogMsg + n_num);
		
		int m_num = novelPostDao.mNumSelect(n_num);
		
		String pageNumber = request.getParameter("pageNumber");
		if (pageNumber == null)
			pageNumber = "1";

		int currentPage = Integer.parseInt(pageNumber);
		LogAspect.logger.info(LogAspect.LogMsg + "currentPage=" + currentPage);

		int boardSize = 4;
		int startRow = (currentPage - 1) * boardSize + 1;
		int endRow = currentPage * boardSize;

		int count = novelPostDao.getCount(n_num);
		LogAspect.logger.info(LogAspect.LogMsg + "count=" + count);
		
		List<CommentDto> commentList = null;
		if(count > 0) {
			commentList = novelPostDao.commentList(startRow, endRow, n_post_num);
			LogAspect.logger.info(LogAspect.LogMsg + "commentList.size=" + commentList.size());
		}
		
		mav.addObject("m_num", m_num);
		mav.addObject("novelPostDto", novelPostDto);
		mav.addObject("n_post_num", n_post_num);
		mav.addObject("currentPage", currentPage);
		mav.addObject("boardSize", boardSize);
		mav.addObject("count", count);
		mav.addObject("commentList", commentList);
		mav.setViewName("novelpost/read.tiles");
	}

	@Override
	public void novelPostDelete(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int n_num = Integer.parseInt(request.getParameter("n_num"));
		LogAspect.logger.info(LogAspect.LogMsg + "n_num=" + n_num);
		
		int n_post_num = Integer.parseInt(request.getParameter("n_post_num"));
		LogAspect.logger.info(LogAspect.LogMsg + n_post_num);
		
		int check = novelPostDao.delete(n_post_num);
		LogAspect.logger.info(LogAspect.LogMsg + check);

		mav.addObject("check", check);
		mav.addObject("n_num", n_num);
		mav.setViewName("novelpost/delete.tiles");
		
	}

	@Override
	public void novelPostUpdate(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int n_post_num = Integer.parseInt(request.getParameter("n_post_num"));
		NovelPostDto novelPostDto = novelPostDao.novelPostSelect(n_post_num);
		
		LogAspect.logger.info(LogAspect.LogMsg + novelPostDto.toString());

		mav.addObject("novelPostDto", novelPostDto);
		mav.addObject("n_post_num", n_post_num);
		mav.setViewName("novelpost/update.tiles");
	}

	@Override
	public void novelPostUpdateOk(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		NovelPostDto novelPostDto = (NovelPostDto) map.get("novelPostDto");
		
		int n_post_num = Integer.parseInt(request.getParameter("n_post_num"));
		LogAspect.logger.info(LogAspect.LogMsg + n_post_num);
		
		novelPostDto.setN_POST_NUM(n_post_num);
		
		
		int n_num = Integer.parseInt(request.getParameter("n_num"));
		LogAspect.logger.info(LogAspect.LogMsg + "n_num=" + n_num);
		
		int check = novelPostDao.novelPostUpdate(novelPostDto);
		LogAspect.logger.info(LogAspect.LogMsg + "check="+ check);
		LogAspect.logger.info(LogAspect.LogMsg + novelPostDto.toString());
		
		mav.addObject("check", check);
		mav.addObject("n_num", n_num);
		mav.setViewName("novelpost/updateOk.tiles");
	}

	@Override
	public void novelPostCommentOk(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		CommentDto commentDto = (CommentDto) map.get("commentDto");
		
		int n_post_num = Integer.parseInt(request.getParameter("n_post_num"));
		LogAspect.logger.info(LogAspect.LogMsg + n_post_num);
		
		int m_num = Integer.parseInt(request.getParameter("m_num"));
		LogAspect.logger.info(LogAspect.LogMsg + "m_num=" + m_num);
		
		
		commentDto.setM_num(m_num);
		commentDto.setN_post_num(n_post_num);
		
		LogAspect.logger.info(LogAspect.LogMsg + commentDto.toString());
		int check = novelPostDao.novelPostCommentInsert(commentDto);
		
		mav.addObject("check", check);
		mav.addObject("commentDto", commentDto);
		mav.addObject("n_post_num", n_post_num);
		mav.setViewName("novelpost/commentOk");
	}

	@Override
	public void novelPostCommentDelete(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int comment_num = Integer.parseInt(request.getParameter("comment_num"));
		LogAspect.logger.info(LogAspect.LogMsg + "comment_num=" + comment_num);
		
		int n_post_num = Integer.parseInt(request.getParameter("n_post_num"));
		LogAspect.logger.info(LogAspect.LogMsg + n_post_num);
		
		int check = novelPostDao.novelPostCommentDelete(comment_num);
		LogAspect.logger.info(LogAspect.LogMsg + check);

		
		mav.addObject("check", check);
		mav.addObject("n_post_num", n_post_num);
		mav.addObject("comment_num", comment_num);
		mav.setViewName("novelpost/commentdelete");
	}

}
