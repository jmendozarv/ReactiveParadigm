package org.example.rxjava3x.reactivex.app.appendixb;

import io.reactivex.Observable;
import java.time.LocalDate;
import java.util.List;

public class C_04 {

  public static void main(String[] args) {
    List<Warehouse> warehouses = null; // obtener almacenes
    Observable.fromIterable(warehouses)
        .flatMap(Warehouse::getProducts)
        .map(ProductStock::getQuantity)
        .reduce(0, (total, next) -> total + next)
        .subscribe(i -> System.out.println("Hay " + i + " unidades en el inventario"));

  }

  interface Warehouse {

    Observable<ProductStock> getProducts();

    Observable<ProductStock> getProductsOnDate(LocalDate date);
  }

  interface ProductStock {

    int getId();

    String getDescription();

    int getQuantity();
  }

}
