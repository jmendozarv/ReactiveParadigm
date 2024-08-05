package chapter10;

import io.reactivex.Observable;
import io.reactivex.rxjava3.observers.TestObserver;
import org.junit.Test;

public class Ch10_14 {
  @Test
  public void debugWalkthrough(){
    TestObserver<String> testObserver = new TestObserver<>();

    //Fuente que empuja tres cadenas
    Observable<String> items = Observable.just("521934/2342/Foxtrot",
        "Bravo/12112/78886/Tango",
        "283242/4542/Whiskey/2348562");

    // Dividir y concatMap() en "/"
    items.concatMap(s->Observable.fromArray(s.split("/")));
  }

}
