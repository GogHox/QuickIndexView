package com.example.goghox.quickindex;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by goghox on 17-7-30.
 */

public class QuickIndexView extends View {
    private String[] abc = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};
    private static final String TAG = "QuickIndexView";
    private float width = 0;
    private float height = 0;
    private String prevLetter = "";
    private String backgroundColor = "#55111111";
    private String textColor = "#303030";

    public QuickIndexView(Context context) {
        super(context, null);
    }

    public QuickIndexView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public QuickIndexView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = (float) getMeasuredWidth();
        height = (float) getMeasuredHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setBackgroundColor(Color.parseColor(backgroundColor));
        Paint paint = new Paint();
        paint.setColor(Color.parseColor(textColor));
        paint.setTextSize(50);
        paint.setTextAlign(Paint.Align.CENTER);

        float bottom = paint.getFontMetrics().bottom;
        float blockHeight = height / abc.length;
        for (int i = 0; i < abc.length; i++) {
            canvas.drawText(abc[i], width / 2.0f,
                    //(blockHeight * (i+1.0f)) - bottom,
                    blockHeight * i + blockHeight / 2f + bottom,
                    paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                float y = event.getY();
                int index = (int) (y / (height / abc.length));
                if (index > abc.length - 1 || index < 0)
                    return true;

                if (prevLetter == abc[index])
                    return true;
                else
                    prevLetter = abc[index];

                // 回调
                listener.onSelect(abc[index]);
                break;
            case MotionEvent.ACTION_UP:
                listener.onSelectOver();
                break;
        }
        return true;
    }

    private OnLetterSelectListener listener;

    interface OnLetterSelectListener {
        /**
         * 当点击字母时调用
         *
         * @param letter 被点击的字母
         */
        void onSelect(String letter);

        void onSelectOver();
    }

    ;

    /**
     * 当点击字母时的监听事件
     *
     * @param listener
     */
    public void setOnLetterSelectListener(OnLetterSelectListener listener) {
        this.listener = listener;
    }

    /**
     * 设置显示的字母
     *
     * @param letters
     */
    public void setLetters(String[] letters) {
        this.abc = letters;
    }

    public void setBackgroundColor(String color) {
        this.backgroundColor = color;
    }

    public void setTextColor(String color) {
        this.textColor = color;
    }
}
