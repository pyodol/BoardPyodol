package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

		public static void main(String args[]) {
				AbstractApplicationContext container = 
						  new GenericXmlApplicationContext ("applicationContext.xml");
				GenericXmlApplicationContext container2 = 
						  new GenericXmlApplicationContext ("applicationContext.xml");
				BoardService boardService  = (BoardService)container.getBean("boardService");
				
				
				
				
				BoardVo vo = new BoardVo();
				vo.setTitle("ÀÌ¿ø±¤2");
				vo.setWriter("jigsaw2");
				vo.setContent("perfectElven Jigkyoromas22");
				
				boardService.insertBoad(vo);
				
				List<BoardVo> boardList = boardService.getBoardList(vo);
				
				for (BoardVo board:boardList) {
					System.out.println("--->" +board.toString());
				}
				
				
				
				
				
		}
	
}
