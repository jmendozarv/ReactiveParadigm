package org.example.rxjava3x.reactivex.app.appendixa;

import java.util.function.Consumer;

public class A_09 {

  public static void main(String[] args) {
    Consumer<String> printConsumer = System.out::println;

    printConsumer.accept("Hello wordl!!");


  }

}
