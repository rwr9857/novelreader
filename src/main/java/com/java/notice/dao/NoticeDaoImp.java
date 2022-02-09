package com.java.notice.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.aop.LogAspect;
import com.java.notice.dto.NoticeDto;
import com.java.notice.dto.QuestionDto;
import com.java.notice.dto.QuestionReplyDto;

@Component
public class NoticeDaoImp implements NoticeDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int noticeInsert(NoticeDto noticeDto) {
		return sqlSessionTemplate.insert("noticeInsert", noticeDto);
	}
	
	@Override
	public List<NoticeDto> selectNotice(int startRow, int endRow) {
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		hmap.put("startRow", startRow);
		hmap.put("endRow", endRow);

		return sqlSessionTemplate.selectList("selectNotice", hmap);
	}
	
	@Override
	public int selectNoticeCount() {
		return sqlSessionTemplate.selectOne("selectNoticeCount");
	}
	
	
	public NoticeDto noticeRead(int not_num) {
		int check = sqlSessionTemplate.update("noticeReadCount", not_num);
		LogAspect.logger.info(LogAspect.LogMsg + check);

		return sqlSessionTemplate.selectOne("noticeRead", not_num);
	}
	
	public int noticeDelete(int not_num) {
    return sqlSessionTemplate.delete("noticeDelete",not_num);
	}

	@Override
	public int questionInsert(QuestionDto questionDto) {
		return sqlSessionTemplate.insert("questionInsert", questionDto);
	}

	@Override
	public List<QuestionDto> selectQuestion(int startRow, int endRow) {
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		hmap.put("startRow", startRow);
		hmap.put("endRow", endRow);

		return sqlSessionTemplate.selectList("selectQuestion", hmap);
	}

	@Override
	public int selectQuestionCount() {
		return sqlSessionTemplate.selectOne("selectQuestionCount");
	}

	@Override
	public QuestionDto questionRead(int q_num) {
		int check = sqlSessionTemplate.update("questionReadCount", q_num);
		LogAspect.logger.info(LogAspect.LogMsg + check);

		return sqlSessionTemplate.selectOne("questionRead", q_num);
	}
	
	@Override
	public int questioReplyInsert(QuestionReplyDto questionReplyDto) {
		return sqlSessionTemplate.insert("questionReplyInsert", questionReplyDto);
	}
	
	@Override
	public QuestionReplyDto questionReplySelect(int q_num) {
		return sqlSessionTemplate.selectOne("selectQuestionReply",q_num);
	}
}
