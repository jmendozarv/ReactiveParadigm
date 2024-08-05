package org.example.rxjava3x.reactivex.app.appendixa;

import java.util.function.Function;

public class A_13
{

  public static void main(String[] args) {
    Function<String,Integer> lenghtMapper = String::length;
    Integer length = lenghtMapper.apply("Alpha");
    System.out.println(length);
  }

}
