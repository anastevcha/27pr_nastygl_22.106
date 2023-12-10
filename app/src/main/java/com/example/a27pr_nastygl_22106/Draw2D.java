package com.example.a27pr_nastygl_22106;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.View;

public class Draw2D extends View {

    private Paint mPaint = new Paint();
    private Rect mRect = new Rect();
   private final Bitmap mBitmap;

    public Draw2D(Context context) {
        super(context);

        // Выводим значок из ресурсов
        Resources res = this.getResources();
       mBitmap = BitmapFactory.decodeResource(res, R.drawable.img);

       // mBitmap.setWidth(180);
      //  mBitmap.setHeight(150);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = canvas.getWidth();
        int height = canvas.getHeight();

        // стиль Заливка
        mPaint.setStyle(Paint.Style.FILL);

        // закрашиваем холст белым цветом
        mPaint.setColor(Color.WHITE);
        canvas.drawPaint(mPaint);

        // Рисуем жёлтый круг
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.YELLOW);
        //canvas.drawCircle(950, 30, 25, mPaint);
        canvas.drawCircle(width - 90, 100, 70, mPaint);

        // Рисуем зелёный прямоугольник
        mPaint.setColor(Color.GREEN);
        //  canvas.drawRect(20, 650, 950, 680, mPaint);
        canvas.drawRect(0, canvas.getHeight() - 80, width, height, mPaint);
        mPaint.setColor(Color.DKGRAY);
        canvas.drawRect(- 100, canvas.getHeight() -600, width - 800, height-100, mPaint);
        Path path = new Path();

        path.moveTo(-100,1150);
        path.lineTo(-250,750);
        path.lineTo(450,1150);

        path.close();
        mPaint.setColor(Color.RED);
        canvas.drawPath(path, mPaint);


        // Рисуем текст
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(32);
        //canvas.drawText("Лужайка только для пушистых", 30, 648, mPaint);
        canvas.drawText("Лужайка только для пушистых", 35, height - 33, mPaint);

        // Текст под углом
        // int x = 810;
        int x = width - 275;
        int y = 295;

        mPaint.setColor(Color.LTGRAY);
        mPaint.setTextSize(30);
        String beam = "Лучик солнца!";

        canvas.save();
        // Создаём ограничивающий прямоугольник для наклонного текста
        // поворачиваем холст по центру текста
        canvas.rotate(-45, x + mRect.exactCenterX(), y + mRect.exactCenterY());

        // Рисуем текст
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawText(beam, x, y, mPaint);

        // восстанавливаем холст
        canvas.restore();

        // Выводим изображение
       // canvas.drawBitmap(mBitmap, 450, 530, mPaint);
       // canvas.drawBitmap(mBitmap, width - mBitmap.getWidth(), height - mBitmap.getHeight() - 100, mPaint);
    }
}