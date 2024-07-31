package org.example.rxjava3x.reactivex.app.chapter08;

import io.reactivex.rxjava3.core.BackpressureOverflowStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

public class Ch8_14 {

  public static void main(String[] args) throws InterruptedException {
    Flowable.interval(1, TimeUnit.MILLISECONDS)
        .onBackpressureBuffer(10,
            () -> System.out.println("overFlow!"),
            BackpressureOverflowStrategy.DROP_LATEST)
        .observeOn(Schedulers.io())
        .subscribe(i -> {
          Thread.sleep(5);
          System.out.println(i);
        });
    Thread.sleep(5000);
  }

}
