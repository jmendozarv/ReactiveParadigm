package org.example.rxjava3x.reactivex.app.chapter09;

import io.reactivex.rxjava3.core.Flowable;
import org.example.rxjava3x.reactivex.util.Util;

public class Ch9_03 {

  public static void main(String[] args) {
    Flowable.just("Alpha","Beta","Gamma","Delta","Epsilon")
        .compose(Util.toFlowableImmutableList())
        .subscribe(System.out::println);

    Flowable.range(1,10)
        .compose(Util.toFlowableImmutableList())
        .subscribe(System.out::println);
  }
}
