package dto;
import java.sql.Date;
import java.sql.Timestamp;


public class BoardDTO {

	private String title;
	private String author;
	private String content;
	private Timestamp regdate;
	private int count;
	private int like;
	private int is_public;
	private int boardId;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getLikes() {
		return like;
	}
	public void setLikes(int like) {
		this.like = like;
	}
	public int getIs_public() {
		return is_public;
	}
	public void setIs_public(int is_public) {
		this.is_public = is_public;
	}
	   public int getBoardId() {
	        return boardId;
	    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }
	public void setRegdate(Timestamp timestamp) {
		// TODO Auto-generated method stub
		this.regdate=timestamp;
		
	}

	
	public Timestamp getRegdate() {
		return regdate;
	}
	
	
	
}





