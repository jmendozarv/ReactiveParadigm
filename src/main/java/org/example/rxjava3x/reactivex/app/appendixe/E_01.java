package org.example.rxjava3x.reactivex.app.appendixe;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

public class E_01 {

  public static void main(String[] args) throws InterruptedException {
    Scheduler scheduler = Schedulers.computation();

    //ejecutar tarea
    scheduler.scheduleDirect(() -> System.out.println("Now!"));

    //Retarasar tarea por 1 segundo
    scheduler.scheduleDirect(() -> System.out.println("Delayed!"), 1, TimeUnit.SECONDS);

    //Repetir tarea cada segundo
    scheduler.schedulePeriodicallyDirect(() -> System.out.println("Repeat!"), 0, 1,
        TimeUnit.SECONDS);

    //Mantener vivo por 5 segundos
    Thread.sleep(5000);
  }

}
