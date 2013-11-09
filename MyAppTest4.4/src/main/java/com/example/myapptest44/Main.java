package com.example.myapptest44;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by user on 09.11.13.
 */
public class Main extends Activity {
    private MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        myView = (MyView)findViewById(R.id.myView);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        myView.pX = event.getX();
        myView.pY = event.getY();
        myView.pS = event.getPressure() * 75;
        myView.isTouched = true;
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText("Touched!");
        myView.invalidate();
        //.setAllCaps(true);// append(pX + " " + pY + " " + pS);
        //invalidate();
        return true;
    }
}

class MyView extends View {
    private Paint mPaint;
    public float pX;
    public float pY;
    public float pS;
    public boolean isTouched = false;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.GREEN);
        canvas.drawARGB(128,128,0,0);
        if(!isTouched){
            Rect rect = new Rect();
                getDisplay().getRectSize(rect);
            canvas.drawCircle(rect.width()/2, rect.height()/2, rect.width()/4,mPaint);
        }else{
            canvas.drawCircle(pX,pY,pS,mPaint);
        }
    }

}
