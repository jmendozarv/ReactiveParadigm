package org.example.rxjava3x.reactivex.app.chapter09;

import static org.example.rxjava3x.reactivex.util.Util.doOnEmpty;

import io.reactivex.rxjava3.core.Observable;

public class Ch9_07 {
  public static void main(String[] args) {
    Observable.range(1, 5)
        .lift(doOnEmpty(() ->
            System.out.println("Operation 1 Empty!")))
        .subscribe(v -> System.out.println("Operation 1: " + v));
    Observable.<Integer>empty()
        .lift(doOnEmpty(() ->
            System.out.println("Operation 2 Empty!")))
        .subscribe(v -> System.out.println("Operation 2: " + v));
  }
}
