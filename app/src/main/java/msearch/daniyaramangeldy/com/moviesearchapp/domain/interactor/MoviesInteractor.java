package msearch.daniyaramangeldy.com.moviesearchapp.domain.interactor;

import msearch.daniyaramangeldy.com.moviesearchapp.data.repository.MoviesRemoteRepository;
import msearch.daniyaramangeldy.com.moviesearchapp.data.repository.SearchDao;

public class MoviesInteractor {

    private MoviesRemoteRepository mRepository;
    private SearchDao mSearchDao;

    public MoviesInteractor(MoviesRemoteRepository repository, SearchDao searchDao) {
        mRepository = repository;
        mSearchDao = searchDao;
    }
}
