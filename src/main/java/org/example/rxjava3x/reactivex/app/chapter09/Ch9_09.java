package org.example.rxjava3x.reactivex.app.chapter09;

import static org.example.rxjava3x.reactivex.util.Util.doOnEmptyFlowableOperator;

import io.reactivex.rxjava3.core.Flowable;

public class Ch9_09 {
  public static void main(String[] args) {
    Flowable.range(1, 5)
        .lift(doOnEmptyFlowableOperator(() ->
            System.out.println("Operation 1 Empty!")))
        .subscribe(v -> System.out.println("Operation 1: " + v));
    Flowable.<Integer>empty()
        .lift(doOnEmptyFlowableOperator(() ->
            System.out.println("Operation 2 Empty!")))
        .subscribe(v -> System.out.println("Operation 2: " + v));
  }
}
