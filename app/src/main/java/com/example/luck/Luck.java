package com.example.luck;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Luck extends RelativeLayout {
    TextView tv;
    Button button;
    List<String> list;
    int index=0;
    Timer timer;
    public Luck(Context context) {
        this(context,null);
    }

    public Luck(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Luck(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init(){
        initlist(list);
        addTextView();
        addButton();
    }

    void addTextView(){
        tv=new TextView(getContext());
        tv.setTextSize(20);
        tv.setGravity(Gravity.CENTER);
        tv.setText(list.get(index));
        tv.setBackgroundColor(Color.CYAN);
        RelativeLayout.LayoutParams params=new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,200);
        addView(tv,params);
    }

    void addButton(){
        button=new Button(getContext());
        button.setText("Start");
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button.getText().toString().equals("Start")){
                    //开始
                    startSelect();
                }else{
                    //停止
                    endSelect();
                }
            }
        });
        button.setGravity(Gravity.CENTER);
        addView(button);
    }

    private void endSelect() {
        timer.cancel();
        button.setText("Start");
    }

    private void startSelect() {
        button.setText("End");
        timer=new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                index=(index+1)%list.size();
                System.out.println(index+"   "+list.get(index));
                tv.setText(list.get(index));
            }
        },0,100);
    }

    void initlist(List<String > list){
        if(list==null){
            this.list= new ArrayList<String>();
            this.list.add("张三");
            this.list.add("李四");
            this.list.add("王五");
        }
    }

    void setterList(List<String> list){
        this.list=list;
    }

}
