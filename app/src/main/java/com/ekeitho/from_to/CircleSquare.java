package com.ekeitho.from_to;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CircleSquare extends View {

    public CircleSquare(Context context) {
        super(context);
        initAttrs(context, null);
    }

    public CircleSquare(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context, attrs);
    }

    public CircleSquare(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, null);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray styleSerializedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleSquare, 0, 0);
            mode = styleSerializedArray.getString(R.styleable.CircleSquare_mode);
            /* IF NO MODE SPEC, DEFAULT TO STRETCH */
            if (mode == null) {
                mode = "stretch";
            }
            styleSerializedArray.recycle();
            paint = new Paint();
        }
    }

    public void setMode(String mode) {
        this.mode = mode;
        this.invalidate();
    }

    private String mode;
    int width = 0;
    int height = 0;
    int smallerDimension = 0;
    int circleRadius = 0;
    Paint paint;

    private void initDrawingValues(Canvas canvas) {
        width = canvas.getWidth();
        height = canvas.getHeight();
        smallerDimension = width < height ? width : height;
        circleRadius = smallerDimension / 2 - (smallerDimension / 8);
    }

    private void drawCircle(Canvas canvas) {
        paint.setColor(getResources().getColor(R.color.colorPrimaryDark));
        canvas.drawCircle(width / 2, smallerDimension / 2 , circleRadius, paint);
    }

    private void drawRectangle(Canvas canvas) {
        paint.setColor(getResources().getColor(R.color.colorAccent));
        switch (mode) {
            case "top":
                canvas.drawRect(
                        width / 2 - (circleRadius / 2),
                        0,
                        width / 2 + (circleRadius / 2),
                        height / 2,  paint);
                break;
            case "stretch":
                canvas.drawRect(
                        width / 2 - (circleRadius / 2),
                        0,
                        width / 2 + (circleRadius / 2),
                        height,  paint);
                break;
            case "bottom":
                canvas.drawRect(
                        width / 2 - (circleRadius / 2),
                        height / 2,
                        width / 2 + (circleRadius / 2),
                        height,  paint);
                break;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initDrawingValues(canvas);

        drawRectangle(canvas);
        /* if mode is stetch then lets not draw a circle */
        if (!mode.equals("stretch")) {
            drawCircle(canvas);
        }
    }
}
