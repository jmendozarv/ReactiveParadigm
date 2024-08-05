package org.example.rxjava3x.reactivex.app.appendixd;

import io.reactivex.Observable;

public class D_03 {

  public static void main(String[] args) {
    Observable.just("Alpha","Beta","Gamma","Delta","Epsilon")
        .materialize()
        .doOnNext(System.out::println)
        .dematerialize(v->v)
        .subscribe(System.out::println);
  }

}
