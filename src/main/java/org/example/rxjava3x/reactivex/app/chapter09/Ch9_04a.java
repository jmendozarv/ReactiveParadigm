package org.example.rxjava3x.reactivex.app.chapter09;

import io.reactivex.rxjava3.core.Observable;
import org.example.rxjava3x.reactivex.model.IndexedValue;
import org.example.rxjava3x.reactivex.util.Util;

public class Ch9_04a {

  public static void main(String[] args) {
    Observable<IndexedValue<String>> indexedStrings =
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .compose(Util.withIndex());

    indexedStrings.subscribe(v-> System.out.println("Subscriber 1 : " + v));
    indexedStrings.subscribe(v-> System.out.println("Subscriber 2 : " + v));
  }
}
