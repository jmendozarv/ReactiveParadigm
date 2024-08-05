package org.example.rxjava3x.reactivex.app.appendixd;

import io.reactivex.Observable;

public class D_01 {

  public static void main(String[] args) {
    Observable<String> source = Observable.just("Alpha","Beta","Gamma","Delta","Epsilon");
    source.materialize().subscribe(System.out::println);
  }

}
