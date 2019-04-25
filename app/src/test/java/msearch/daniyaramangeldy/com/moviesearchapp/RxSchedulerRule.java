package msearch.daniyaramangeldy.com.moviesearchapp;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

public class RxSchedulerRule implements TestRule {

    private static final Scheduler SCHEDULER_INSTANCE = Schedulers.trampoline();

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {

            @Override
            public void evaluate() throws Throwable {
                RxAndroidPlugins.reset();
                RxAndroidPlugins.setInitMainThreadSchedulerHandler((handler) -> SCHEDULER_INSTANCE);
                RxJavaPlugins.reset();
                RxJavaPlugins.setIoSchedulerHandler((handler) -> SCHEDULER_INSTANCE);
                base.evaluate();
            }
        };
    }
}