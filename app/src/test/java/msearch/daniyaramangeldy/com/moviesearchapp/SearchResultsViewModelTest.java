package msearch.daniyaramangeldy.com.moviesearchapp;

import com.google.common.truth.Truth;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.Collections;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import msearch.daniyaramangeldy.com.moviesearchapp.domain.model.Movie;
import msearch.daniyaramangeldy.com.moviesearchapp.domain.model.SearchResultsModel;
import msearch.daniyaramangeldy.com.moviesearchapp.data.repository.MoviesRemoteRepository;
import msearch.daniyaramangeldy.com.moviesearchapp.domain.interactor.MoviesInteractor;
import msearch.daniyaramangeldy.com.moviesearchapp.domain.repository.SearchQueryRepository;
import msearch.daniyaramangeldy.com.moviesearchapp.ui.SearchResultsViewModel;

public class SearchResultsViewModelTest {

    public static final String RESPONSE_TRUE = "True";
    public static final String RESPONSE_FALSE = "False";

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Rule
    public InstantTaskExecutorRule executorRule = new InstantTaskExecutorRule();

    @Rule
    public RxSchedulerRule schedulerRule = new RxSchedulerRule();

    public MoviesRemoteRepository remoteRepository = Mockito.mock(MoviesRemoteRepository.class);
    public SearchQueryRepository searchQueryRepository = Mockito.mock(SearchQueryRepository.class);

    public SearchResultsViewModel viewModel;

    private Movie testMovie = new Movie("123", "title", "year", "posterUrl", "type");

    private SearchResultsModel testModel =
            new SearchResultsModel(Collections.singletonList(testMovie), RESPONSE_TRUE);

    @Before
    public void setUp() {
        remoteRepository = Mockito.mock(MoviesRemoteRepository.class);
        searchQueryRepository = Mockito.mock(SearchQueryRepository.class);
        MoviesInteractor interactor = new MoviesInteractor(remoteRepository, searchQueryRepository);
        Mockito
                .when(remoteRepository.searchMovie(Mockito.anyString(), Mockito.anyString(), Mockito.anyString()))
                .thenReturn(Single.just(testModel));
        Mockito
                .when(searchQueryRepository.insertSearchQuery(Mockito.anyString()))
                .thenReturn(Completable.complete());
        Mockito
                .when(searchQueryRepository.getSearchQueries())
                .thenReturn(Flowable.just(new ArrayList<>()));

        viewModel = new SearchResultsViewModel(interactor);
    }

    @Test
    public void testMovieListSuccessPositiveCase() {
        TestObserver observer = new TestObserver();
        Movie expectedMovie = new Movie("123", "title", "year", "posterUrl", "type");
        LiveData testLiveData = viewModel.getMoviesLiveData();
        testLiveData.observeForever(observer);

        viewModel.setQuery("");

        Truth.assert_()
                .that(observer.getObservedValues())
                .isEqualTo(Collections.singletonList(expectedMovie));
    }

    @Test
    public void testMovieListSuccessNegativeCase() {
        TestObserver observer = new TestObserver();
        Movie expectedMovie = new Movie("", "", "", "", "");
        LiveData testLiveData = viewModel.getMoviesLiveData();
        testLiveData.observeForever(observer);

        viewModel.setQuery("");

        Truth.assert_()
                .that(observer.getObservedValues())
                .isNotEqualTo(Collections.singletonList(expectedMovie));
    }

    @Test
    public void testMovieListExceptionShouldReturnEmptyList() {
        testModel.Response = RESPONSE_FALSE;
        Mockito
                .when(remoteRepository.searchMovie(Mockito.anyString(), Mockito.anyString(), Mockito.anyString()))
                .thenReturn(Single.just(testModel));
        TestObserver observer = new TestObserver();
        LiveData testLiveData = viewModel.getMoviesLiveData();
        testLiveData.observeForever(observer);

        viewModel.setQuery("");

        Truth.assert_()
                .that(observer.getObservedValues())
                .isEqualTo(new ArrayList<>());
    }
}