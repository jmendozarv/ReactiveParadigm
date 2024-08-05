package chapter10;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observers.TestObserver;
import io.reactivex.rxjava3.schedulers.TestScheduler;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class Ch10_13 {

  @Test
  public void usingTestScheduler() {
    TestScheduler testScheduler = new TestScheduler();
    TestObserver<Long> testObserver = new TestObserver<>();
    Observable<Long> minuteTicker = Observable.interval(1, TimeUnit.MINUTES, testScheduler);
    minuteTicker.subscribe(testObserver);
  }
}
