package org.example.rxjava3x.reactivex.model;

public  class IndexedValue<T> {
  final int index ;

  final T value ;

  public IndexedValue(int index , T value){
    this.index = index;
    this.value = value;
  }

  @Override
  public String toString() {
    return "IndexedValue{" +
        "index=" + index +
        ", value=" + value +
        '}';
  }
}
