package com.example.zsy.sourceurl;

/**
 * Created by zhaoxiaosi on 2016/12/23 11:34
 * Company yuerwang
 */

public class Bus {
    public SelfQueue queue = new SelfQueue();

    public void loop(){
        for(;;){
            Msg msg = queue.poll();
            if(msg == null)return;
            msg.target.executeMsg();
        }
    }
}
