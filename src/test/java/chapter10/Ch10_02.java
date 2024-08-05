package chapter10;

import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Assert;
import org.junit.Test;

public class Ch10_02 {

  @Test
  public void testSubscribe() {
    AtomicInteger hitCount = new AtomicInteger();
    Observable<Long> source =
        Observable.interval(1, TimeUnit.SECONDS).take(5);

    source.subscribe(i -> hitCount.incrementAndGet());
    Assert.assertTrue("actual count = " + hitCount.get(), hitCount.get() == 5);

  }

}
