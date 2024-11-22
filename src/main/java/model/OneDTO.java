package model;

public class OneDTO {
	//DTO의 멤버변수는 무조건 private으로 정의
	private String subject;
	//게시물 수정을 위한 컬럼 추가
	private String prev_subj;
	
	//외부 접근을 위한 getter/setter 정의
	public String getSubject() {
		//클래스 외부로 값을 반환
		return subject;
	}
	public void setSubject(String subject) {
		//외부에서 전달된 값으로 멤버변수에 값 할당
		this.subject = subject;
	}
	public String getPrev_subj() {
		return prev_subj;
	}
	public void setPrev_subj(String prev_subj) {
		this.prev_subj = prev_subj;
	}

	
	
	
}
