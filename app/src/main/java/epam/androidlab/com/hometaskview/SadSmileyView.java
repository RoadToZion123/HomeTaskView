package epam.androidlab.com.hometaskview;


import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.shapes.ArcShape;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

public class SadSmileyView extends View{

    private Paint CirclePaint;
    private Paint EyeAndMouthPaint;



    private float CenterX;
    private float CenterY;
    private float Radius;
    private RectF ArcBounds = new RectF();


    public SadSmileyView(Context context) {
        super(context);
    }

    public SadSmileyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SadSmileyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initPaints(){
        CirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        CirclePaint.setStyle(Paint.Style.FILL);
        CirclePaint.setColor(Color.YELLOW);
        EyeAndMouthPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        EyeAndMouthPaint.setStyle(Paint.Style.STROKE);
        EyeAndMouthPaint.setStrokeWidth(16 * getResources().getDisplayMetrics().density);
        EyeAndMouthPaint.setStrokeCap(Paint.Cap.ROUND);
        EyeAndMouthPaint.setColor(Color.BLACK);

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);

        int size = Math.min(w, h);
        setMeasuredDimension(size, size);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        CenterX = w / 2f;
        CenterY = h / 2f;
        Radius = Math.min(w, h) / 2f;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {

        initPaints();

        canvas.drawCircle(CenterX, CenterY, Radius, CirclePaint);

        float eyeRadius = Radius / 5f;
        float eyeOffsetX = Radius / 3f;
        float eyeOffsetY = Radius / 3f;
        canvas.drawCircle(CenterX - eyeOffsetX, CenterY - eyeOffsetY, eyeRadius, EyeAndMouthPaint);
        canvas.drawCircle(CenterX + eyeOffsetX, CenterY - eyeOffsetY, eyeRadius, EyeAndMouthPaint);

        float mouthInset = Radius /3f;
        ArcBounds.set( mouthInset, mouthInset, Radius * 2 - mouthInset, Radius * 2 - mouthInset);
        canvas.drawArc(ArcBounds, 45f, 90f, false, EyeAndMouthPaint);
        //canvas.drawArc(10f, 1002f, 100f, 100f, 123f, 2f, true, EyeAndMouthPaint);*/

    }
}

