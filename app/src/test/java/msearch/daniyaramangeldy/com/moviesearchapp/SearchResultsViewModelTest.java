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
import msearch.daniyaramangeldy.com.moviesearchapp.data.model.Movie;
import msearch.daniyaramangeldy.com.moviesearchapp.data.model.SearchResultsNetworkModel;
import msearch.daniyaramangeldy.com.moviesearchapp.data.repository.MoviesRemoteRepository;
import msearch.daniyaramangeldy.com.moviesearchapp.domain.interactor.MoviesInteractor;
import msearch.daniyaramangeldy.com.moviesearchapp.domain.repository.SearchQueryRepository;
import msearch.daniyaramangeldy.com.moviesearchapp.ui.SearchResultsViewModel;

public class SearchResultsViewModelTest {

    public static final String RESPONSE_TRUE = "True";

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Rule
    public InstantTaskExecutorRule executorRule = new InstantTaskExecutorRule();

    @Rule
    public RxSchedulerRule schedulerRule = new RxSchedulerRule();



    public SearchResultsViewModel viewModel;

    private Movie testMovie = new Movie("123", "title", "year", "posterUrl", "type");

    private SearchResultsNetworkModel testModel =
            new SearchResultsNetworkModel(Collections.singletonList(testMovie),RESPONSE_TRUE);

    @Before
    public void setUp() {
        MoviesRemoteRepository remoteRepository = Mockito.mock(MoviesRemoteRepository.class);
        SearchQueryRepository searchQueryRepository = Mockito.mock(SearchQueryRepository.class);
        MoviesInteractor interactor = new MoviesInteractor(remoteRepository, searchQueryRepository);
        Mockito.when(
                remoteRepository
                        .searchMovie(Mockito.anyString(), Mockito.anyString(), Mockito.anyString()))
                .thenReturn(
                        Single.just(testModel)
                );
        Mockito.when(
                searchQueryRepository
                        .insertSearchQuery(Mockito.anyString()))
                .thenReturn(
                        Completable.complete()
                );
        Mockito.when(
                searchQueryRepository
                        .getSearchQueries())
                .thenReturn(
                        Flowable.just(new ArrayList<>())
                );
        viewModel = new SearchResultsViewModel(interactor);
    }

    @Test
    public void exampleTest() {
        TestObserver observer = new TestObserver();
        LiveData testLiveData = viewModel.getMoviesLiveData();
        testLiveData.observeForever(observer);
        viewModel.setQuery("");
        Truth.assert_()
                .that(observer.getObservedValues())
                .isEqualTo(testModel.Search);
    }
}