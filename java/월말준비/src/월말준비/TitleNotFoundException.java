package 월말준비;

public class TitleNotFoundException extends Exception {
	private String title;
	
	public TitleNotFoundException(String title) {
//		System.out.println(title + "제목의 영확가 없습니다.");
		super(title + " 제목의 영화가 없습니다.");
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
}
