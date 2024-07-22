package dto;

public class Criteria {
	//현재 페이지 번호
	private int page;
	//한페이지당 보여줄 게시글의 개수
	private int perPageNum;

	public Criteria() {
	    this.page = 1;
	    this.perPageNum = 10;
	}

	public int getPage() {
	    return page;
	}

	public void setPage(int page) {
	    if (page <= 1) {
	        this.page = 1;
	    } else {
	        this.page = page;
	    }
	}

	public int getPerPageNum() {
	    return perPageNum;
	}

	public void setPerPageNum(int pageCount) {
	    int cnt = this.perPageNum;
	    if (pageCount != cnt) {
	        this.perPageNum = cnt;
	    } else {
	        this.perPageNum = pageCount;
	    }
	}
	//특정 페이지의 게시글 시작 번호, 게시글 시작 행 번호 -> 현재 페이지 번호가 5이라면 맨위 게시글 번호는 40이다(한 페이지에 10개씩 보여줘야하기 때문)
	public int getPageStart() {
	    return (this.page - 1) * perPageNum;
	}


}
