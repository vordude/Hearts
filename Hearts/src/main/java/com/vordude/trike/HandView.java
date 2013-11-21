package com.vordude.trike;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.vordude.hearts.model.HeartsHand;

/**
 * Created by kleve on 8/15/13.
 */
public class HandView  extends View {
    private Hand hand;

    public HandView(Context context){
        super(context);
        setUp();
    }

    public HandView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        setUp();
    }

    private void setUp() {
        if (hand == null) {
            hand = new HeartsHand();
        }
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y / 4;
        setMinimumWidth(width);
        setMinimumHeight(height);
        setFocusable(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        setMeasuredDimension(getSuggestedMinimumWidth(), getSuggestedMinimumHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.GREEN);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(hasFocus() ? Color.BLUE : Color.GRAY);
        canvas.drawRect(0, 0, getWidth() - 1, getHeight() - 1, paint);
        Log.e("stuff", hand.toString());
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Hand getHand(){
        if(this.hand == null) {
            return null;
        }
        else {
            return hand;
        }
    }

}