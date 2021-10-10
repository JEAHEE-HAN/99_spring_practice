package com.spring.practice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.practice.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insert(BoardDto bdto) throws Exception {
		sqlSession.insert("com.spring.mapper.PracBoardMapper.insertBoard" , bdto);
		
	}

	@Override
	public List<BoardDto> selectAll() throws Exception {
		
		return sqlSession.selectList("com.spring.mapper.PracBoardMapper.getAllBoard");
	}

	@Override
	public BoardDto selectOne(int num) throws Exception {
		return sqlSession.selectOne("com.spring.mapper.PracBoardMapper.getOneBoard" , num);
	}

	@Override
	public BoardDto validateUserCheck(BoardDto bdto) throws Exception {
		return sqlSession.selectOne("com.spring.mapper.PracBoardMapper.validateUserCheck" , bdto);
	}

	@Override
	public void update(BoardDto bdto) throws Exception {
		sqlSession.update("com.spring.mapper.PracBoardMapper.updateBoard" , bdto);
		
	}

	@Override
	public void delete(BoardDto bdto) throws Exception {
		sqlSession.delete("com.spring.mapper.PracBoardMapper.deleteBoard" , bdto);
		
	}

}
