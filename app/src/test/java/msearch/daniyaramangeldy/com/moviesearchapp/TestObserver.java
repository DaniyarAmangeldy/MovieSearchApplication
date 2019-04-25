package msearch.daniyaramangeldy.com.moviesearchapp;

import androidx.lifecycle.Observer;

public class TestObserver<T> implements Observer<T> {

    T observedValue;

    @Override
    public void onChanged(T t) {
        observedValue = t;
    }

    public T getObservedValues() {
        return observedValue;
    }
}