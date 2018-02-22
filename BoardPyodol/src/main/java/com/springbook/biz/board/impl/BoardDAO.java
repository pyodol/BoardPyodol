package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVo;
import com.springbook.biz.common.JDBCUtil;

@Repository("boardDAO")
public class BoardDAO {
		private Connection conn= null;
		private PreparedStatement stmt = null;
		private ResultSet rs =null;
		
		private final String BOARD_INSERT = "insert into board (seq, title , writer,content)"
										+"values((select nvl(max(seq) , 0 ) +1 from board ) "
										+ "        , ? "
										+ "        , ? "
										+ "        , ?   )";
		
		
		private final String BOARD_UPDATE = "update board set title=? , content=? where seq=?";
		
		private final String BOARD_DELETE = "delete board where seq=?";
		
		private final String BOARD_GET   = "select * from board where seq = ?";
		
		private final String BOARD_LIST   = "select * from board order by seq desc";
		
		
		public void insertBoard (BoardVo vo) {
			System.out.println("===>jdbc insertBoard() Start" );
			try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(BOARD_INSERT);
				stmt.setString(1, vo.getTitle());
				stmt.setString(2, vo.getContent());
				stmt.setString(3, vo.getWriter());
				stmt.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(stmt, conn);
			}
			
		}
		
		public void updateBoard (BoardVo vo) {
			System.out.println("===>jdbc updateBoard() Start" );
			try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(BOARD_UPDATE);
				stmt.setString(1, vo.getTitle());
				stmt.setString(2, vo.getWriter());
				stmt.setInt	  (3, vo.getSeq());
				stmt.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(stmt, conn);
			}
		}
		
		public void deleteBoard (BoardVo vo) {
			System.out.println("===>jdbc deleteBoard() Start" );
			try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(BOARD_DELETE);
				stmt.setInt	  (1, vo.getSeq());
				stmt.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(stmt, conn);
			}
		}
		
		
		public BoardVo getBoard (BoardVo vo) {
			System.out.println("===>jdbc deleteBoard() Start" );
			BoardVo board =null;
			ResultSet rs = null;
			try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(BOARD_GET);
				stmt.setInt	  (1, vo.getSeq());
				rs= stmt.executeQuery();
				if(rs.next()) {
					board = new BoardVo();
					board.setSeq( rs.getInt("SEQ"));
					board.setTitle(rs.getString("TITLE"));
					board.setWriter(rs.getString("WRITER"));
					board.setContent(rs.getString("CONTENT"));
					board.setRegDate(rs.getDate("REGDATE"));
					board.setCnt(rs.getInt("CNT"));
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(stmt, conn);
			}
			return board;
		}
		
		
		@SuppressWarnings("null")
		public List<BoardVo> getBoardList (BoardVo vo) {
			System.out.println("===>jdbc deleteBoard() Start" );
			List <BoardVo> boardList =new ArrayList<BoardVo>();
			ResultSet rs = null;
			try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(BOARD_LIST);
				stmt.setInt	  (1, vo.getSeq());
				rs= stmt.executeQuery();
				while(rs.next()) {
					BoardVo board = new BoardVo();
					board.setSeq( rs.getInt("SEQ"));
					board.setTitle(rs.getString("TITLE"));
					board.setWriter(rs.getString("WRITER"));
					board.setContent(rs.getString("CONTENT"));
					board.setRegDate(rs.getDate("REGDATE"));
					board.setCnt(rs.getInt("CNT"));
					boardList.add(board);
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(rs , stmt, conn);
			}
			return boardList;
		}
		
}
