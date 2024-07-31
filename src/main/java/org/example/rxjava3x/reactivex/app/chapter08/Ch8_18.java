package org.example.rxjava3x.reactivex.app.chapter08;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.atomic.AtomicInteger;

public class Ch8_18 {

  public static void main(String[] args) throws InterruptedException {
    rangeReverse(100, -100)
        .subscribeOn(Schedulers.computation())
        .doOnNext(i-> System.out.println("Emitiendo " + i))
        .observeOn(Schedulers.io())
        .subscribe(i-> {
          Thread.sleep(50);
          System.out.println("Recibido " + i);
        });
    Thread.sleep(50000);

  }

  static Flowable<Integer> rangeReverse(int upperBound, int lowerBound) {
    return Flowable.generate(() -> new AtomicInteger(upperBound + 1), (state, emitter) -> {
          int current = state.decrementAndGet();
          emitter.onNext(current);
          if (current == lowerBound) {
            emitter.onComplete();
          }
    });

  }

}
