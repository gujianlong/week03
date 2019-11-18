package com.example.lianxi;
/*
 *@auther:谷建龙
 *@Date: 2019/11/17
 *@Time:19:48
 *@Description:
 * */


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class ListView extends View {
    private Context context;
    private int width = 0;
    private int height = 0;
    private Paint linePaint;
    private Paint textPaint;
    private Paint pointPaint;

    public ListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    private void init() {
        linePaint = new Paint();
        linePaint.setStyle(Paint.Style.FILL);
        linePaint.setColor(Color.BLUE);
        linePaint.setAntiAlias(true);
        linePaint.setStrokeWidth((float) 2.0);

        textPaint = new Paint();
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAntiAlias(true);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setColor(Color.RED);
        textPaint.setTextSize(20);

        pointPaint = new Paint();
        pointPaint.setStyle(Paint.Style.FILL);
        pointPaint.setAntiAlias(true);
        pointPaint.setTextAlign(Paint.Align.CENTER);
        pointPaint.setColor(Color.RED);
        pointPaint.setTextSize(20);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

    protected float[][] points = new float[][]{{1, 10}, {2, 47}, {3, 11}, {4, 38}, {5, 9}, {6, 52}, {7, 14}, {8, 37}, {9, 29}, {10, 31}};

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(50, height - 50);
        drawLine(canvas);
        drawLineX(canvas);
        drawLineY(canvas);
    }

    float pointX = 0;
    float pointY = 0;

    private void drawLine(Canvas canvas) {
        float pointXTime = 0;
        float pointYTime = 0;
        for (int i = 0; i < points.length; i++) {
            float time = points[i][0] % points.length;
            if (time == 0) {
                pointX = (points[i][0]) * ((width - 100) / points.length);
            } else {
                pointX = (points[i][0] % points.length) * ((width - 100) / points.length);
            }
            pointY = 0 - (points[i][1] / 60) * (height - 100);
            canvas.drawCircle(pointX, pointY, 5, pointPaint);
            canvas.drawText(i + 1 + "", pointX - 10, pointY - 10, pointPaint);
            canvas.drawText(((int) points[i][0] + "," + (int) points[i][1]), pointX - 20, pointY - 20, textPaint);
            if (i != 0) {
                canvas.drawLine(pointXTime, pointYTime, pointX, pointY, linePaint);
            }
            pointXTime = pointX;
            pointYTime = pointY;
        }
    }

    private void drawLineY(Canvas canvas) {
        int startX = 0;
        int startY = 0;
        int spaceing = (height - 100) / points.length;
        for (int i = 0; (startY + spaceing * i) < height - 50; i++) {
            canvas.drawLine(startX, startY, startX, startY - spaceing * i, linePaint);
            canvas.drawCircle(startX, startY - spaceing * i, 5, linePaint);
            canvas.drawText(6 * i + "", startX - 30, startY - spaceing * i, textPaint);
        }
    }

    private void drawLineX(Canvas canvas) {
        int startX = 0;
        int startY = 0;
        int spaceing = (width - 100) / points.length;
        for (int i = 0; (startX + spaceing * i) < width - 50; i++) {
            canvas.drawLine(startX, startY, startX + spaceing * i, startY, linePaint);
            canvas.drawCircle(startX + spaceing * i, startY, 5, linePaint);
            canvas.drawText(i + "", startX + spaceing * i, startY + 30, textPaint);
        }
    }
}
