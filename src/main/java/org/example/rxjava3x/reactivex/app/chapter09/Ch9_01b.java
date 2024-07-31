package org.example.rxjava3x.reactivex.app.chapter09;

import static org.example.rxjava3x.reactivex.util.Util.toImmutableList;

import io.reactivex.rxjava3.core.Observable;

public class Ch9_01b
{

  public static void main(String[] args) {
    Observable.just("Alpha","Beta","Gamma","Delta","Epsilon")
        .compose(toImmutableList())
        .subscribe(System.out::println);

    Observable.range(1,10)
        .compose(toImmutableList())
        .subscribe(System.out::println);

  }

}
