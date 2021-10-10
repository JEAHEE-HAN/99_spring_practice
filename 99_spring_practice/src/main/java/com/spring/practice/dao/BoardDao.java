package com.spring.practice.dao;

import java.util.List;

import com.spring.practice.dto.BoardDto;

public interface BoardDao {
	
	public void insert(BoardDto bdto) throws Exception;
	public List<BoardDto> selectAll() throws Exception;
	public BoardDto selectOne(int num) throws Exception;
	public BoardDto validateUserCheck(BoardDto bdto) throws Exception;
	public void update(BoardDto bdto) throws Exception;
	public void delete(BoardDto bdto) throws Exception;

}
