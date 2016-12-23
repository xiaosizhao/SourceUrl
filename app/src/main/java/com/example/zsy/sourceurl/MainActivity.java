package com.example.zsy.sourceurl;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONStringer;

public class MainActivity extends AppCompatActivity {

//    private Bus bus = new Bus(){
//        @Override
//        public void executeMsg() {
//            super.executeMsg();
//            textView.setText(object.toString());
//        }
//    };

    private TextView textView;

    ThreadLocal<Bus> threadLocal = new ThreadLocal<>();

    private Take take = new Take(){
        @Override
        public void executeMsg() {
            super.executeMsg();
            textView.setText(object.toString());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("3=="+ Looper.myLooper());
        textView = (TextView) findViewById(R.id.tv);

        //final int t = 0;

    }

    public void click(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
//                bus.receiveMsg(new String("hello world"));
                Msg msg = new Msg();
                msg.object = "hello";
                msg.target = take;
                take.sendMsg(msg);
            }
        }).start();
    }

//    class Bus{
//        Object object;
//        public void receiveMsg(Object object){
//            this.object = object;
//            executeMsg();
//        }
//
//        public void executeMsg(){
//
//        }
//
//    }
}
