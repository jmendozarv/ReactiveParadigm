package org.example.rxjava3x.reactivex.app.appendixe;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

public class E_02 {
  public static void main(String[] args) {
    Scheduler scheduler = Schedulers.computation();
    Scheduler.Worker worker = scheduler.createWorker();

    // Ejecutar tarea ahora
    worker.schedule(() -> System.out.println("Now!"));

    // Retrasar tarea por 1 segundo
    worker.schedule(() -> System.out.println("Delayed!"), 1,
        TimeUnit.SECONDS);

    // Repetir tarea cada segundo
    worker.schedulePeriodically(() ->
        System.out.println("Repeat!"), 0, 1, TimeUnit.SECONDS);

    // Mantener vivo por 5 segundos, luego desechar Worker
    sleep(5000);
    worker.dispose();
  }

  public static void sleep(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}