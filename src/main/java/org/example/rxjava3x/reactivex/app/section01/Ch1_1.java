package org.example.rxjava3x.reactivex.app.section01;

import io.reactivex.Observable;

public class Ch1_1 {

  public static void main(String[] args) {
    Observable<String> myStrings = Observable.just("Alpha", "Beta", "Gamma");
    myStrings.subscribe(s -> System.out.println(s));
  }

}
