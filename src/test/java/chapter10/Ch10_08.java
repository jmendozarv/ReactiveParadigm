package chapter10;

import static org.junit.Assert.assertTrue;

import io.reactivex.rxjava3.core.Observable;
import org.junit.Test;

public class Ch10_08 {
  @Test
  public void testBlockingForEach(){
    Observable<String> source = Observable.just("Alpha","Beta","Gamma","Delta","Zeta");
    source.filter(s->s.length() == 5)
        .blockingForEach(s-> assertTrue(s.length() == 5));
  }
}
