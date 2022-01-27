package com.java.notice.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.java.notice.dto.QuestionDto;

public class NoticeDaoImp implements NoticeDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int questionInsert(QuestionDto questionDto) {
		return sqlSessionTemplate.insert("questionInsert",questionDto);
	}
}
