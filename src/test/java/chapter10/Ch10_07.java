package chapter10;

import static org.junit.Assert.assertTrue;

import io.reactivex.rxjava3.core.Observable;
import org.junit.Test;

public class Ch10_07 {

  @Test
  public void testIterable() {
    Observable<String> source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Zeta");
    Iterable<String> allLengthFive = source.filter(s -> s.length() == 5).blockingIterable();
    for (String s : allLengthFive) {
      assertTrue(s.length() == 5);
    }

  }

}
