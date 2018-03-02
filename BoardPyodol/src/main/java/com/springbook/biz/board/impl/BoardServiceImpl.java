package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVo;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	/*
	 *  autowire�� �ߴµ� ��...? ������ �ɱ�� Autowire�� ����� ������ �Ȼ���
	 * 
	 * */
	@Autowired
	private BoardDAO boardDAO;
	
	public void insertBoad(BoardVo vo) {
		// TODO Auto-generated method stub
		boardDAO.insertBoard(vo);
	}

	public void updateBoard(BoardVo vo) {
		// TODO Auto-generated method stub
		boardDAO.updateBoard(vo);
	}

	public void deleteBoard(BoardVo vo) {
		// TODO Auto-generated method stub
		boardDAO.deleteBoard(vo);
	}

	public BoardVo getBoard(BoardVo vo) {
		// TODO Auto-generated method stub
		return boardDAO.getBoard(vo);
	}

	public List<BoardVo> getBoardList(BoardVo vo) {
		// TODO Auto-generated method stub
		return boardDAO.getBoardList(vo);
	}
	
}
