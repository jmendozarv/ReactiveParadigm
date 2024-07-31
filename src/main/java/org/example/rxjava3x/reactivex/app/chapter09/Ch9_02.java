package org.example.rxjava3x.reactivex.app.chapter09;

import io.reactivex.rxjava3.core.Observable;
import org.example.rxjava3x.reactivex.util.Util;

public class Ch9_02 {

  public static void main(String[] args) {
    Observable.just("Alpha" , "Beta","Gamma","Delta","Epsilon")
        .compose(Util.joinToString("/"))
        .subscribe(System.out::println);
  }
}
