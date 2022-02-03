package com.java.notice.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.notice.dto.QuestionDto;

@Component
public class NoticeDaoImp implements NoticeDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int questionInsert(QuestionDto questionDto) {
		return sqlSessionTemplate.insert("questionInsert",questionDto);
	}
	
	@Override
	public List<QuestionDto> selectQuestion(int m_num, int startRow, int endRow) {
		HashMap<String, Object> hmap=new HashMap<String, Object>();
		hmap.put("m_num", m_num);
		hmap.put("startRow", startRow);
		hmap.put("endRow", endRow);
		
		return sqlSessionTemplate.selectList("selectQuestion",hmap);
	}
	
	@Override
	public int selectQuestionCount(int m_num) {
		return sqlSessionTemplate.selectOne("selectQuestionCount",m_num);
	}
}
