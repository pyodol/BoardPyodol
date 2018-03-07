package com.springbook.biz.board.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardRowMapper;
import com.springbook.biz.board.BoardVo;

@Repository
public class BoardDAO extends JdbcDaoSupport {

	@Autowired
	private DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}
	 
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
			System.out.println("InsertInto구문기능처리");
			getJdbcTemplate().update( BOARD_INSERT, vo.getTitle() , vo.getWriter(),vo.getContent());
		}
		
		public void updateBoard (BoardVo vo) {
			System.out.println("===>jdbc updateBoard() Start" );
			getJdbcTemplate().update(BOARD_UPDATE , vo.getTitle(), vo.getWriter(),vo.getSeq() );
		}
		
		public void deleteBoard (BoardVo vo) {
			System.out.println("===>jdbc deleteBoard() Start" );
			getJdbcTemplate().update(BOARD_DELETE , vo.getSeq());
		}
		
		public BoardVo getBoard (BoardVo vo) {
			System.out.println("===>jdbc getBoard() Start" );
			Object[]args = {vo.getSeq()};
			return getJdbcTemplate().queryForObject(BOARD_GET,  args, new BoardRowMapper());
			
		}
		
		public List<BoardVo> getBoardList (BoardVo vo) {
			System.out.println("===>jdbc getBoardList() Start" );
			return getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper());
		}

}
