package chapter10;

import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class Ch10_10 {

  @Test
  public void testBlockingLatest() {
    Observable<Long> source = Observable.interval(1, TimeUnit.MICROSECONDS).take(1000);
    Iterable<Long> iterable = source.blockingNext();
    for (Long i : iterable) {
      System.out.println(i);
    }
  }

}
