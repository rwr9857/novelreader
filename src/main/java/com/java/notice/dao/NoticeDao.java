package com.java.notice.dao;

import java.util.List;

import com.java.notice.dto.NoticeDto;
import com.java.notice.dto.QuestionDto;

public interface NoticeDao {
	public int noticeInsert(NoticeDto noticeDto);
	
	public int questionInsert(QuestionDto questionDto);

	public List<QuestionDto> selectQuestion(int startRow, int endRow);

	public int selectQuestionCount();
	
	public QuestionDto questionRead(int q_num);
}
