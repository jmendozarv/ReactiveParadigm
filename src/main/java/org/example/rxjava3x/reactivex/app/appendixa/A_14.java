package org.example.rxjava3x.reactivex.app.appendixa;

import io.reactivex.Observable;

public class A_14 {

  public static void main(String[] args) {
    Observable.just("Alpha","Beta","Gamma")
        .map(String::length) //acepta Function<T,R>
        .subscribe(System.out::println); //acepta Consumer<T>
  }

}
