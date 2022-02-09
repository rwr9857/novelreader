package com.java.notice.dao;

import java.util.List;

import com.java.notice.dto.NoticeDto;
import com.java.notice.dto.QuestionDto;
import com.java.notice.dto.QuestionReplyDto;

public interface NoticeDao {
	public int noticeInsert(NoticeDto noticeDto);
	
	public List<NoticeDto> selectNotice(int startRow, int endRow);

	public int selectNoticeCount();
	
	public NoticeDto noticeRead(int not_num);
	
	public int questionInsert(QuestionDto questionDto);

	public List<QuestionDto> selectQuestion(int startRow, int endRow);

	public int selectQuestionCount();
	
	public QuestionDto questionRead(int q_num);
	
	public int questioReplyInsert(QuestionReplyDto questionReplyDto);
	
	public QuestionReplyDto questionReplySelect(int q_num);
}
