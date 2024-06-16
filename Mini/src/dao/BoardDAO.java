package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.sql.DataSource;

import dto.BoardDTO;
import dto.Criteria;
import servlet.boardInsertServlet;

public class BoardDAO {

	public static final int BOARD_NONEXIST = 0;
	public static final int BOARD_EXIST = 1;
	public static final int BOARD_JOIN_FAIL = 0;
	public static final int BOARD_JOIN_SUCCESS = 1;
	public static final int BOARD_LOGIN_NOGOOD = 0;
	public static final int BOARD_LOGIN_SUCCESS = 1;
	public static final int BOARD_LOGIN_FAIL = -1;

	public static BoardDAO instance = new BoardDAO();

	private Connection conn;
	private PreparedStatement pstmt;
	private DataSource dataFactory;

	public BoardDAO(Connection conn) {
		this.conn = conn;
	}

	
	public BoardDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static BoardDAO getInstance() {
		return instance;
	}

	// 전체 게시물 수 가져오기
	public int getBoardCount() {
		int count = 0;
		ResultSet rs = null;
		try {
			conn = dataFactory.getConnection();
			String query = "SELECT COUNT(*) FROM board";
			PreparedStatement pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	// board에서 모든 게시글 가져오기
	public List<BoardDTO> selectBoard(String input) {
		List<BoardDTO> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			conn = dataFactory.getConnection();

			String query = "SELECT ";
			if (input.equals("*")) { // '*'이면 모든 컬럼 선택
				query += "* ";
			} else { // inputid가 실제 컬럼명이면 해당 컬럼만 선택
				query += input + " ";
			}
			query += "FROM board";

			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardDTO dto = new BoardDTO(); 

				dto.setBoardId(rs.getInt("board_id"));
				dto.setTitle(rs.getString("title"));
				dto.setAuthor(rs.getString("author"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getTimestamp("regdate"));
				dto.setCount(rs.getInt("count"));
				dto.setLikes(rs.getInt("likes"));
				dto.setIs_public(rs.getInt("is_public"));

				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	// board에 게시글 추가
	public void insertBoard(BoardDTO dto) {
		try {
			conn = dataFactory.getConnection();
			String title = (dto.getTitle() != null) ? dto.getTitle() : ""; 
			String author = dto.getAuthor();
			String content = dto.getContent();
			Timestamp regdate = dto.getRegdate();
			int count = 0;
			int likes = 0; 
			int is_public = dto.getIs_public(); 

			String query = "insert into board ";
			query += "(title, author, content, is_public, regdate, count, likes)"; 
			query += " values (?, ?, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, author);
			pstmt.setString(3, content);
			pstmt.setInt(4, is_public);
			pstmt.setTimestamp(5, regdate);
			pstmt.setInt(6, count);
			pstmt.setInt(7, likes);

			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// board에서 게시글 삭제
	public void delBoard(String board_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = dataFactory.getConnection();
			String query = "delete from board where board_id=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board_id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 게시글 내용 수정 후 업데이트
	public void updateBoard(BoardDTO board) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = dataFactory.getConnection();
			String query = "UPDATE BOARD SET TITLE=?, CONTENT=?, IS_PUBLIC=? WHERE BOARD_ID=?";
			pstmt = conn.prepareStatement(query);
			System.out.println(query);

			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getIs_public());
			pstmt.setInt(4, board.getBoardId()); 

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 페이징 적용된 게시글 select
	public List<BoardDTO> selectBoardList(Criteria cri) {
	    List<BoardDTO> list = new ArrayList<>();
	    ResultSet rs = null;
	    try {
	        conn = dataFactory.getConnection();

	        String query = "SELECT * FROM (SELECT board.*, ROWNUM AS rnum FROM " +
	                       "(SELECT * FROM board ORDER BY board_id DESC) board WHERE ROWNUM <= ?) WHERE rnum >= ?";

	        pstmt = conn.prepareStatement(query);
	        pstmt.setInt(1, cri.getPageStart() + cri.getPerPageNum()); // end rownum
	        pstmt.setInt(2, cri.getPageStart() + 1); // start rownum

	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            BoardDTO dto = new BoardDTO();
	            dto.setBoardId(rs.getInt("board_id"));
	            dto.setTitle(rs.getString("title"));
	            dto.setAuthor(rs.getString("author"));
	            dto.setContent(rs.getString("content"));
	            dto.setRegdate(rs.getTimestamp("regdate"));
	            dto.setCount(rs.getInt("count"));
	            dto.setLikes(rs.getInt("likes"));
	            dto.setIs_public(rs.getInt("is_public"));

	            list.add(dto);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return list;
	}

	// 제목누를때 실행되는 게시글 상세 보기
	public BoardDTO detailBoard(String input) {
		ResultSet rs = null;
		BoardDTO dto = null; // try 블록 내에서 초기화

		try {
			conn = dataFactory.getConnection();
			String query = "select * from board where board_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, input); 
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new BoardDTO(); 
				dto.setBoardId(rs.getInt("board_id"));
				dto.setTitle(rs.getString("title"));
				dto.setAuthor(rs.getString("author"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getTimestamp("regdate"));
				dto.setCount(rs.getInt("count"));
				dto.setLikes(rs.getInt("likes"));
				dto.setIs_public(rs.getInt("is_public"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return dto;
	}

	// 조회수 증가
	public void incrementCount(String boardIdStr) {
	    try (Connection conn = dataFactory.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement("UPDATE board SET count = count + 1 WHERE board_id = ?")) {
	        pstmt.setString(1, boardIdStr);
	        int rowsUpdated = pstmt.executeUpdate();
	        if (rowsUpdated > 0) {
	            System.out.println("조회수가 증가되었습니다.");
	        } else {
	            System.out.println("해당 board_id가 존재하지 않습니다.");
	        }
	    } catch (SQLException e) {
	        System.err.println("조회수 증가 중 오류 발생: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	// 좋아요 증가
	public void incrementLikes(String boardIdStr) {
	    try (Connection conn = dataFactory.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement("UPDATE board SET likes = likes + 1 WHERE board_id = ?")) {
	        pstmt.setString(1, boardIdStr);
	        int rowsUpdated = pstmt.executeUpdate();
	        if (rowsUpdated > 0) {
	            System.out.println("좋아요가 증가되었습니다.");
	        } else {
	            System.out.println("해당 board_id가 존재하지 않습니다.");
	        }
	    } catch (SQLException e) {
	        System.err.println("좋아요 증가 중 오류 발생: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	// boardid 참조 메서드
	public BoardDTO getBoardById(int boardId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDTO board = null;

		try {
			conn = dataFactory.getConnection();
			String query = "SELECT * FROM BOARD WHERE BOARD_ID=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				board = new BoardDTO();
				board.setBoardId(rs.getInt("BOARD_ID"));
				board.setTitle(rs.getString("TITLE"));
				board.setContent(rs.getString("CONTENT"));
				board.setAuthor(rs.getString("AUTHOR"));
				board.setRegdate(rs.getTimestamp("REGDATE"));

				board.setCount(rs.getInt("COUNT"));
				board.setLikes(rs.getInt("LIKES"));
				// 기타 필요한 정보 설정
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return board;
	}

}
