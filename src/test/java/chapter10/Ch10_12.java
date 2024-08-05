package chapter10;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observers.TestObserver;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
public class Ch10_12 {
  @Test
  public void usingTestObserver(){
    //Un observable con 2 emisiones de un segundo
    Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS).take(3);

    //Declarar TestObserver
    TestObserver<Long> testObserver = new TestObserver<>();

    //Afirmar que no ha ocurrido ninguna suscripcion aun
    assertFalse(testObserver.hasSubscription());

    //Suscribir TestObserver a la fuente
    source.subscribe(testObserver);

    //Afirmar que TestObserver esta suscrito
    assertTrue(testObserver.hasSubscription());

    //Bloquear y esperar a que el Observable termine
    try{
      testObserver.await(4L, TimeUnit.SECONDS);
    }catch (InterruptedException e){
      e.printStackTrace();
    }

    // Afirmar que TestObserver llamo a onComplete()
    testObserver.assertComplete();

    //Afirmar que no hubo errores
    testObserver.assertNoErrors();

    //Afirmar que se recibieron 3 valores
    testObserver.assertValueCount(3);

    //Afirmar que las emisiones recibidas fueron 0,1,2
    testObserver.assertValues(0L,1L,2L);

  }

}
