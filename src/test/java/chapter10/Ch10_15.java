package chapter10;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observers.TestObserver;
import org.junit.Test;

public class Ch10_15 {
  @Test
  public void debugWalkthrough() {
    TestObserver<String> testObserver = new TestObserver<>();
    Observable<String> items =
        Observable.just("521934/2342/Foxtrot",
            "Bravo/12112/78886/Tango",
            "283242/4542/Whiskey/2348562");
    items.concatMap(s -> Observable.fromArray(s.split("/")))
        .filter(s -> s.matches("[A-Za-z]+"))
        .subscribe(testObserver);
    System.out.println(testObserver.values());
    testObserver.assertValues("Foxtrot", "Bravo", "Tango", "Whiskey");
  }
}
