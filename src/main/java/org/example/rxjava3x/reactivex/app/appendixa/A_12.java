package org.example.rxjava3x.reactivex.app.appendixa;

import java.util.function.Function;

public class A_12 {

  public static void main(String[] args) {
    Function<String,Integer> lenghtMapper = new Function<String, Integer>() {
      @Override
      public Integer apply(String s) {
        return s.length();
      }
    };

    Integer length = lenghtMapper.apply("Alpha");
    System.out.println(length);
  }

}
