package org.example.rxjava3x.reactivex.app.chapter09;

import io.reactivex.rxjava3.core.Observable;
import org.example.rxjava3x.reactivex.util.Util;

public class Ch9_08 {
  public static void main(String[] args) {
    Observable.range(1, 5)
        .lift(Util.myToList())
        .subscribe(v -> System.out.println("Operation 1: " + v));
    Observable.<Integer>empty()
        .lift(Util.myToList())
        .subscribe(v -> System.out.println("Operation 2: " + v));
  }
}
