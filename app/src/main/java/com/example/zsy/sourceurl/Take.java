package com.example.zsy.sourceurl;

import android.os.Looper;

/**
 * Created by zhaoxiaosi on 2016/12/23 11:41
 * Company yuerwang
 */

public class Take {
    public Msg object;
    private SelfQueue queue ;
    private ThreadLocal<Bus> threadLocal;
    public Take(){
//        threadLocal = new ThreadLocal();
//        Bus bus = new Bus();
//        threadLocal.set(bus);

    }

    public void sendMsg(Msg object){
        this.object = object;
        Bus bus = new Bus();

        queue = bus.queue;
        queue.enqueue(object);
        bus.loop();
    }

    public void executeMsg(){

    }

}
