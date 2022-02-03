package com.java.notice.dao;

import java.util.List;

import com.java.notice.dto.QuestionDto;

public interface NoticeDao {
	public int questionInsert(QuestionDto questionDto);

	public List<QuestionDto> selectQuestion(int m_num, int startRow, int endRow);

	public int selectQuestionCount(int m_num);
}
