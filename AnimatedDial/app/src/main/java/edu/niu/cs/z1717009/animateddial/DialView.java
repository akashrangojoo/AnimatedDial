package edu.niu.cs.z1717009.animateddial;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by z1717009 on 4/19/2016.
 */
public class DialView extends View {

    private float angle;
    private Paint paint;

    public DialView(Context context) {
        super(context);
        angle=0;

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(05);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //set BG color
        canvas.drawRGB(0,0,0);

        int canvasWidth= getMeasuredWidth();
        int canvasHeight= getMeasuredHeight();
        int radius;

        //set radius checking if the screen is in Landscape or portrait
        if(canvasWidth>canvasHeight){
            radius = canvasHeight/2;
        }
        else{
            radius = canvasWidth/2;
        }

        // increment angle
        angle+=(0.1333333333333333333);
        if(angle>360) angle=0;

        // Draw line
        float radians = (float)(angle*(180/Math.PI));
        float startX = canvasWidth/2;
        float startY = canvasHeight/2;
        float stopX = (float) (startX + radius * Math.sin(radians));
        float stopY = (float) (startY - radius * Math.cos(radians));

        paint.setColor(Color.rgb(34,67,234));

        canvas.drawLine(startX, startY, stopX,stopY,paint);

    }

    public void update(){
        invalidate();
    }
}
