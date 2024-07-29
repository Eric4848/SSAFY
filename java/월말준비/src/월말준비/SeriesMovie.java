package 월말준비;

public class SeriesMovie extends Movie {
	private int seriesNum;
	private String episode;
	
	SeriesMovie() {}

	public SeriesMovie(int id, String title, String director, String gnere, int runningTime, int seriesNum, String episode) {
		super(id, title, director, gnere, runningTime);
		this.seriesNum = seriesNum;
		this.episode = episode;
	}

	public int getSeriesNum() {
		return seriesNum;
	}

	public void setSeriesNum(int seriesNum) {
		this.seriesNum = seriesNum;
	}

	public String getEpisode() {
		return episode;
	}

	public void setEpisode(String episode) {
		this.episode = episode;
	}

	@Override
	public String toString() {
		return "SeriesMovie [seriesNum=" + seriesNum + ", episode=" + episode + "]";
	}
}
