package 월말준비;

public class MovieTest {
	public static void main(String[] args) {
		MovieManagerImpl mm = MovieManagerImpl.getInstance();
		mm.add(new Movie(1, "기생충", "봉준호", "스릴러", 100));
		mm.add(new Movie(2, "괴물", "봉준호", "스릴러", 120));
		mm.add(new Movie(1, "마더", "봉준호", "스릴러", 150));
		mm.add(new SeriesMovie(3, "데드풀", "감독", "액션", 90, 1, "데드풀"));
		mm.add(new SeriesMovie(4, "데드풀", "감독", "액션", 110, 2, "데드풀2"));
		mm.add(new SeriesMovie(5, "데드풀", "감독", "액션", 140, 3, "데드풀3"));
		mm.add(new SeriesMovie(6, "데드풀", "감독", "액션", 160, 4, "데드풀과 울버린"));
		System.out.println("*****************영화 목록*****************");
		Movie[] movies = mm.getList();
		for(Movie movie : movies)
			System.out.println(movie.toString());
		System.out.println("*****************시리즈 영화 목록*****************");
		SeriesMovie[] smovies = mm.getSeriesMovies();
		for(SeriesMovie smovie : smovies)
			System.out.println(smovie.toString());
		System.out.println("*****************평균 영화 시간*****************");
		System.out.println(mm.getRunningTimeAvg());
		System.out.println("*****************배트맨(으)로 검색*****************");
		try {
			Movie[] bmovies = mm.searchByTitle("배트맨");
			for(Movie bmovie : bmovies)
				System.out.println(bmovie.toString());
		} catch (TitleNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}