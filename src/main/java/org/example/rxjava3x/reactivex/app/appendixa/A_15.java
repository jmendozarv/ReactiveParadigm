package org.example.rxjava3x.reactivex.app.appendixa;

import io.reactivex.Observable;

public class A_15 {

  public static void main(String[] args) {
    Observable.just("Alpha","Beta","Gamma")
        .map(String::length)
        .reduce((total,next)-> total+ next)////BiFunction<T,T,T>
        .subscribe(System.out::println);
  }

}
