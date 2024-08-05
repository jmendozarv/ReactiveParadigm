package org.example.rxjava3x.reactivex.app.section01;

import io.reactivex.Observable;

public class Ch1_2 {

  public static void main(String[] args) {
    Observable<String> myStrings = Observable.just("Alpha", "Beta", "Gamma");
    myStrings.map(s -> s.length())
        .subscribe(System.out::println);
  }

}
