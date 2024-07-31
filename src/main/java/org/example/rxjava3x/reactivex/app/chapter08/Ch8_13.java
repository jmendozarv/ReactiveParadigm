package org.example.rxjava3x.reactivex.app.chapter08;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

public class Ch8_13 {

  public static void main(String[] args) throws InterruptedException {
    Flowable.interval(1, TimeUnit.MILLISECONDS)
        .onBackpressureBuffer()
        .observeOn(Schedulers.io())
        .subscribe(i -> {
          Thread.sleep(5);
          System.out.println(i);
        });

    Thread.sleep(5000);

  }

}
