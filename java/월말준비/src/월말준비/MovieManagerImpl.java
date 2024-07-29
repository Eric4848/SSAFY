package 월말준비;

import java.util.ArrayList;
import java.util.List;

public class MovieManagerImpl {
	List<Movie> movieList = new ArrayList<Movie>();
	
	private static MovieManagerImpl mm = new MovieManagerImpl();
	
	private MovieManagerImpl() {}
	
	public static MovieManagerImpl getInstance() {
		return mm;
	}
	
	public void add(Movie m) {
		movieList.add(m);
	}
	
	public Movie[] getList() {
		Movie[] res = new Movie[movieList.size()];
		return movieList.toArray(res);
	}
	
	public Movie[] getMovies() {
		List<Movie> result = new ArrayList<Movie>();
		for(int i = 0; i < movieList.size(); i++) {
			if(!(movieList.get(i) instanceof SeriesMovie)) {
				result.add(movieList.get(i));
			}
		}
		Movie[] res = new Movie[result.size()];
		return result.toArray(res);
	}
	
	public SeriesMovie[] getSeriesMovies() {
		List<SeriesMovie> result = new ArrayList<SeriesMovie>();
		for(int i = 0; i < movieList.size(); i++) {
			if(movieList.get(i) instanceof SeriesMovie) {
				result.add((SeriesMovie) movieList.get(i));
			}
		}
		SeriesMovie[] res = new SeriesMovie[result.size()];
		return result.toArray(res);
	}
	
	public Movie[] searchByTitle(String title) throws TitleNotFoundException {
		List<Movie> result = new ArrayList<Movie>();
		for(int i = 0; i < movieList.size(); i++) {
			if(movieList.get(i).getTitle().contains(title)){
				result.add(movieList.get(i));
			}
		}
		if(!result.isEmpty()) {
			Movie[] res = new Movie[result.size()];
			return result.toArray(res);
		}
		throw new TitleNotFoundException(title);
	}
	
	public double getRunningTimeAvg() {
		double total = 0;
		for(int i = 0; i < movieList.size(); i++) {
			total += movieList.get(i).getRunningTime();
		}
		return total / movieList.size();
	}
}
