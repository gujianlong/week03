package com.bawei.gujianlong20191118.view;
/*
 *@auther:谷建龙
 *@Date: 2019/11/18
 *@Time:10:40
 *@Description:
 * */


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MyView extends View {
    private Context context;
    private int width = 0;
    private int height = 0;
    private Paint linePaint;
    private Paint TextPaint;
    private Paint pointPaint;

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    private void init() {
        linePaint = new Paint();
        linePaint.setAntiAlias(true);
        linePaint.setStrokeWidth((float) 2.0);
        linePaint.setColor(Color.RED);
        linePaint.setTextSize(20);

        TextPaint = new Paint();
        TextPaint.setTextSize(10);
        TextPaint.setColor(Color.BLUE);
        TextPaint.setStyle(Paint.Style.FILL);
        TextPaint.setAntiAlias(true);
        TextPaint.setTextAlign(Paint.Align.CENTER);

        pointPaint = new Paint();
        pointPaint.setTextSize(10);
        pointPaint.setColor(Color.BLUE);
        pointPaint.setStyle(Paint.Style.FILL);
        pointPaint.setAntiAlias(true);
        pointPaint.setTextAlign(Paint.Align.CENTER);
    }

    float[][] points = {{1, 20}, {2, 15}, {3, 5}, {4, 25}, {5, 30}, {6, 35}, {7, 10}, {8, 26}, {9, 15}, {10, 20}};

    @Override

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(50, height - 50);
        drawLineX(canvas);
        drawLineY(canvas);
    }

    private void drawLineX(Canvas canvas) {
        int startX = 0;
        int startY = 0;
        int spaceing = (startX) * (width - 100) / points.length;
        for (int i = 0; (startX + spaceing * i) < width - 100; i++) {
            canvas.drawLine(startX, startY, startX + spaceing * i, startY, linePaint);
            canvas.drawCircle(startX + spaceing * i, startY, 5, linePaint);
            canvas.drawText(i + "", startX + spaceing * i, startY + 30, TextPaint);
        }
    }

    private void drawLineY(Canvas canvas) {
        int startX = 0;
        int startY = 0;
        int spaceing = (startY) * (height - 100) / points.length;
        for (int i = 0; (startY + spaceing * i) < width - 100; i++) {
            canvas.drawLine(startX, startY, startX, startY - spaceing * i, linePaint);
            canvas.drawCircle(startX, startY - spaceing * i, 5, linePaint);
            canvas.drawText(6 + i + "", startX - 30, startY - spaceing * i, TextPaint);
        }
    }
}
