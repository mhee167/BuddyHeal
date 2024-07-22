package dto;

public class pageDTO {
	private Criteria cri;
	private int totalCount;//게시글의 총 개수
	private int startPage;//시작 페이지번호
	private int endPage;//끝 페이지번호
	private boolean prev;//이전
	private boolean next;//이후
	private int displayPageNum =5;//화면 하단에 보여지는 페이지 버튼의 수 (1 2 3 4 5)

	public Criteria getCri() {
	    return cri;
	}

	public void setCri(Criteria cri) {
	    this.cri = cri;
	}

	public int getTotalCount() {
	    //select count(*) from board
		return totalCount;
	    
	}

	public void setTotalCount(int totalCount) {
	    this.totalCount = totalCount;
	    System.out.println("calcData 실헹");
	    calcData();
	}
	// 총게시글 수를  계산
		private void calcData() {
			  int currentPage = cri.getPage();
		        if (currentPage < 1) {
		            currentPage = 1;
		        }

	    endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);
	    System.out.println("endPage"+endPage);

	    startPage = (endPage - displayPageNum) + 1;
	    if (startPage <= 0) startPage = 1;

	    int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));
	   //옵션 endPage가 tempEndPage보다 크면, endPage를 tempEndPage로 설정하여 마지막 페이지를 넘지 않도록함
	    if (endPage > tempEndPage) {
	        endPage = tempEndPage;
	    }

	    System.out.println("startapg"+startPage);
	    System.out.println("tenpapg"+tempEndPage);

	    prev = startPage == 1 ? false : true;
	    next = endPage * cri.getPerPageNum() < totalCount ? true : false;
	    
	    System.out.println(prev+" "+next);
	}

	public int getStartPage() {
	    return startPage;
	}

	public void setStartPage(int startPage) {
	    this.startPage = startPage;
	}

	public int getEndPage() {
	    return endPage;
	}

	public void setEndPage(int endPage) {
	    this.endPage = endPage;
	}

	public boolean getPrev() {
	    return prev;
	}

	public void setPrev(boolean prev) {
	    this.prev = prev;
	}

	public boolean getNext() {
	    return next;
	}

	public void setNext(boolean next) {
	    this.next = next;
	}

	public int getDisplayPageNum() {
	    return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
	    this.displayPageNum = displayPageNum;
	}


}
