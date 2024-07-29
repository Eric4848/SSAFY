package 월말준비;

public class Movie {
	private int id;
	private String title;
	private String director;
	private String gnere;
	private int runningTime;
	
	Movie() {}

	public Movie(int id, String title, String director, String gnere, int runningTime) {
		super();
		this.id = id;
		this.title = title;
		this.director = director;
		this.gnere = gnere;
		this.runningTime = runningTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGnere() {
		return gnere;
	}

	public void setGnere(String gnere) {
		this.gnere = gnere;
	}

	public int getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", director=" + director + ", gnere=" + gnere + ", runningTime="
				+ runningTime + "]";
	}
}
