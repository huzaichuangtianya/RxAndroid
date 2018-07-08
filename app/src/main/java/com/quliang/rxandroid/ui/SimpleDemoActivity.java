package com.quliang.rxandroid.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.quliang.rxandroid.R;
import com.quliang.rxandroid.util.AppLog;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class SimpleDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_demo);
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        });
        //创建一个下游 Observer
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                AppLog.D("subscribe");
            }

            @Override
            public void onNext(Integer value) {
                AppLog.D("" + value);
            }

            @Override
            public void onError(Throwable e) {
                AppLog.D("error");
            }

            @Override
            public void onComplete() {
                AppLog.D("complete");
            }
        };
        //建立连接
        observable.subscribe(observer);

    }
}
