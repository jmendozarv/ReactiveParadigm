package chapter10;

import static org.junit.Assert.assertTrue;

import io.reactivex.rxjava3.core.Observable;
import org.junit.Test;

public class Ch10_04 {

  @Test
  public void testFirst() {
    Observable<String> source =
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Zeta");

    String firstWithLenghtFour = source.filter(s -> s.length() == 4).blockingFirst();
    assertTrue(firstWithLenghtFour.equals("Beta"));


  }

}
