package org.example.rxjava3x.reactivex.app.appendixb;

import io.reactivex.Observable;

public class C_03 {

  public static void main(String[] args) {
    DroneBot droneBot = null; // crear droneBot
    droneBot.getLocation().subscribe(
        location -> System.out.println("El dron se movio a " + location.x + "," + location.y));
  }

  interface DroneBot {

    int getId();

    String getModel();

    Observable<Location> getLocation();
  }

  static final class Location {

    private final double x;
    private final double y;

    Location(double x, double y) {
      this.x = x;
      this.y = y;
    }
  }

}
