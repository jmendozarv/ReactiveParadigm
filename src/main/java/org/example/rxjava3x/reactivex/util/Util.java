package org.example.rxjava3x.reactivex.util;

import com.google.common.collect.ImmutableList;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.FlowableOperator;
import io.reactivex.rxjava3.core.FlowableTransformer;
import io.reactivex.rxjava3.core.ObservableOperator;
import io.reactivex.rxjava3.core.ObservableTransformer;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.example.rxjava3x.reactivex.model.IndexedValue;

public class Util {

  public static <T> ObservableTransformer<T, ImmutableList<T>> toImmutableList() {
    return up ->
        up.collect(ImmutableList::<T>builder, ImmutableList.Builder::add)
            .map(ImmutableList.Builder::build)
            .toObservable();
  }

  public static ObservableTransformer<String, String> joinToString(String separator) {
    return upstream -> upstream.collect(StringBuilder::new, (b, s) -> {
          if (b.length() == 0) {
            b.append(s);
          } else {
            b.append(separator).append(s);
          }
        })
        .map(StringBuilder::toString)
        .toObservable();
  }

  public static <T> FlowableTransformer<T, ImmutableList<T>> toFlowableImmutableList() {
    return upstream ->
        upstream.collect(ImmutableList::<T>builder,
                ImmutableList.Builder::add)
            .map(ImmutableList.Builder::build)
            .toFlowable();
  }

  public static <T> ObservableTransformer<T, IndexedValue<T>> withIndex() {
    final AtomicInteger indexer = new AtomicInteger(-1);
    return upstream -> upstream
        .map(v -> new IndexedValue<T>(indexer.incrementAndGet(), v));
  }


  public static <T> ObservableOperator<T, T> doOnEmpty(Action action) {
    return observer -> new DisposableObserver<T>() {
      boolean isEmpty = true;

      @Override
      public void onNext(T value) {
        isEmpty = false;
        observer.onNext(value);
      }

      @Override
      public void onError(Throwable t) {
        observer.onError(t);
      }

      @Override
      public void onComplete() {
        if (isEmpty) {
          try {
            action.run();
          } catch (Throwable e) {
            onError(e);
            return;
          }
        }
        observer.onComplete();
      }
    };
  }

  public static <T> ObservableOperator<List<T>, T> myToList() {
    return observer -> new DisposableObserver<T>() {
      ArrayList<T> list = new ArrayList<>();

      @Override
      public void onNext(T value) {
        //add to List, but don't pass anything downstream
        list.add(value);
      }

      @Override
      public void onError(Throwable t) {
        observer.onError(t);
      }

      @Override
      public void onComplete() {
        observer.onNext(list); //push List downstream
        observer.onComplete();
      }
    };
  }

  public static <T> FlowableOperator<T, T> doOnEmptyFlowableOperator(Action action) {
    return new FlowableOperator<T, T>() {
      @Override
      public org.reactivestreams.@NonNull Subscriber<? super T> apply(
          org.reactivestreams.@NonNull Subscriber<? super T> subscriber) throws Throwable {
        return new DisposableSubscriber<T>() {
          boolean isEmpty = true;

          @Override
          public void onNext(T value) {
            isEmpty = false;
            subscriber.onNext(value);
          }

          @Override
          public void onError(Throwable t) {
            subscriber.onError(t);
          }

          @Override
          public void onComplete() {
            if (isEmpty) {
              try {
                action.run();
              } catch (Throwable e) {
                onError(e);
                return;
              }
            }
            subscriber.onComplete();
          }
        };
      }
    };
  }


}