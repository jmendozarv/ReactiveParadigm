package org.example.rxjava3x.reactivex.app.chapter09;

import io.reactivex.rxjava3.core.Observable;
import com.google.common.collect.ImmutableList;


public class Ch9_01a {

  public static void main(String[] args) {
    Observable.just("Alpha","Beta","Gamma","Delta","Epsilon")
        .collect(ImmutableList::builder, ImmutableList.Builder::add)
        .map(ImmutableList.Builder::build)
        .subscribe(System.out::println);

    Observable.range(1,10)
        .collect(ImmutableList::builder,ImmutableList.Builder::add)
        .map(ImmutableList.Builder::build)
        .subscribe(System.out::println);
  }

}
