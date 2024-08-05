package org.example.rxjava3x.reactivex.app.appendixb;

import io.reactivex.Observable;
import java.time.LocalDate;

public class C_01 {

  public static void main(String[] args) {
    Observable<LocalDate> dates = Observable.just(
        LocalDate.of(2020, 11, 3),
        LocalDate.of(2020, 10, 4),
        LocalDate.of(2020, 7, 5),
        LocalDate.of(2020, 10, 3)
    );
    // Obtener meses distintos
    dates.map(LocalDate::getMonth)
        .distinct()
        .subscribe(System.out::println);

  }

}
