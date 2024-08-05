package chapter10;

import static org.junit.Assert.assertTrue;

import io.reactivex.rxjava3.core.Observable;
import org.junit.Test;

public class Ch10_06 {

  @Test
  public void testLast() {
    Observable<String> source = Observable.just("Alpa","Beta","Gamma","Delta","Zeta");
    String lastLengthFour = source.filter(s->s.length() == 4).blockingLast();
    assertTrue(lastLengthFour.equals("Zeta"));
  }

}
