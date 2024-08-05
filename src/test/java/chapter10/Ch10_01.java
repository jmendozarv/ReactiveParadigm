package chapter10;

import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class Ch10_01 {

  @Test
  public void demoCode() throws InterruptedException {
    Observable.interval(1, TimeUnit.SECONDS)
        .take(5)
        .subscribe(System.out::println);

    Thread.sleep(6000);

  }
}
