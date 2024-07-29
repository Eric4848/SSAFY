package 월말준비;

public interface IMovieManager {
	void add(Movie movie);
	
	Movie[] getList();
	
	Movie[] serachByTitle();
	
	Movie[] getMovies();
	
	SeriesMovie[] getSeriesMovie() throws TitleNotFoundException;
	
	double getRunningTimeAvg();
}
