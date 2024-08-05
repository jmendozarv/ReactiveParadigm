package org.example.rxjava3x.reactivex.app.appendixa;

import java.util.function.Consumer;

public class A_08
{

  public static void main(String[] args) {
    Consumer<String> printConsumer = new Consumer<String>() {
      @Override
      public void accept(String s) {
        System.out.println(s);
      }
    };

    printConsumer.accept("Hello wordl!!");
  }

}
