package com.example.zsy.sourceurl;

/**
 * Created by zhaoxiaosi on 2016/12/23 11:24
 * Company yuerwang
 */

public class SelfQueue {
    private Msg msg;
    private Msg head;
    private Msg tail;

    public SelfQueue(){
        msg = null;
        head = tail = null;
    }

    public void enqueue(Msg msg){
        if(head == null){
            head = tail = msg;
        }else{
            tail.next = msg;
            tail = msg;
        }
    }

    public Msg poll(){
        if(head==null)return null;

        if(head != null){
            Msg msg = head;
            head = head.next;
            return msg;
        }
        return null;
    }
}
