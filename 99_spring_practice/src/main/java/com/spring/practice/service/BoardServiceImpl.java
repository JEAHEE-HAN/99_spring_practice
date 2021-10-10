package com.spring.practice.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.practice.dao.BoardDao;
import com.spring.practice.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public void insertBoard(BoardDto bdto) throws Exception {
		boardDao.insert(bdto);
		
	}

	@Override
	public List<BoardDto> getBoardList() throws Exception {
		return boardDao.selectAll();
	}

	@Override
	public BoardDto getOneBoard(int num) throws Exception {
		return boardDao.selectOne(num);
	}

	@Override
	public boolean updateBoard(BoardDto bdto) throws Exception {
		boolean isSucceed = false;
		
		if(boardDao.validateUserCheck(bdto) != null) {
			boardDao.update(bdto);
			isSucceed = true;
			
		}
		
		return isSucceed;
	}

	@Override
	public boolean deleteBoard(BoardDto bdto) throws Exception {
		boolean isSucceed = false;
		
		if(boardDao.validateUserCheck(bdto) != null) {
			boardDao.delete(bdto);
			isSucceed = true;
		}
		return isSucceed;
	}
	


}

