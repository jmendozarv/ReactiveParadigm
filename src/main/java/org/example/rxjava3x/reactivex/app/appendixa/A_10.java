package org.example.rxjava3x.reactivex.app.appendixa;

import java.util.function.Consumer;

public class A_10 {

  public static void main(String[] args) {
    Consumer<String> printConsumer = s-> System.out.println(s);
    printConsumer.accept("Hello world");
  }

}
