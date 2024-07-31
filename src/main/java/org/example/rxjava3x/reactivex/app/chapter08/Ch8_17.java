package org.example.rxjava3x.reactivex.app.chapter08;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.ThreadLocalRandom;

public class Ch8_17 {

  public static void main(String[] args) throws InterruptedException {
    randomGenerator(1, 10000)
        .subscribeOn(Schedulers.computation())
        .doOnNext(i -> System.out.println("Emitiendo " + i))
        .observeOn(Schedulers.io())
        .subscribe(i -> {
          Thread.sleep(50);
          System.out.println("Recibido " + i);
        });
    Thread.sleep(10000);
  }

  static Flowable<Integer> randomGenerator(int min, int max) {
    return Flowable.generate(
        emitter -> emitter.onNext(ThreadLocalRandom.current().nextInt(min, max)));
  }

}
