package chapter10;

import static org.junit.Assert.assertTrue;

import io.reactivex.rxjava3.core.Observable;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class Ch10_05 {

  @Test
  public void testSingle() {
    Observable<String> source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Zeta");
    List<String> allLenghtFour = source.filter(s -> s.length() == 4)
        .toList()
        .blockingGet();

    assertTrue(allLenghtFour.equals(Arrays.asList("Beta", "Zeta")));
  }

}
