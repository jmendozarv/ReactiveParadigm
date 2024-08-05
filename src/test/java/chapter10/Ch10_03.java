package chapter10;

import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Assert;
import org.junit.Test;

public class Ch10_03 {

  @Test
  public void testBlockingSubscribe() {
    AtomicInteger hitCount = new AtomicInteger();
    Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS).take(5);

    source.blockingSubscribe(i -> hitCount.incrementAndGet());
    Assert.assertTrue(hitCount.get() == 5);

  }
}
