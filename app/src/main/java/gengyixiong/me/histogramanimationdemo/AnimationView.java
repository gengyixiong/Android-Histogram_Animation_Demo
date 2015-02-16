package gengyixiong.me.histogramanimationdemo;

/**
 * Created by gengyixiong on 2/15/15.
 */
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by gengyixiong on 2/15/15.
 */
public class AnimationView extends View {

    private Paint paint;
    private static final int RECT_WIDTH = 100;
    private static final int RECT_DISTANCE = 40;
    private static final int TOTAL_PAINT_TIME = 100;
    private int currPaintTimes = 0;

    private static final int[][] RECT_INFO = {       //height and color of rectangular
            {480, Color.GRAY},
            {700, Color.YELLOW},
            {250, Color.GREEN},
            {550, Color.RED},
            {400, Color.BLUE}
    };

    public AnimationView(Context context) {
        super(context);
        initialize();
    }

    public AnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public AnimationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }


    protected void initialize(){                    //initialize the paint
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        currPaintTimes++;
        for (int i = 0; i < RECT_INFO.length; i++){
            paint.setColor(RECT_INFO[i][1]);            //set color to paint
            int XPosition = i * (RECT_WIDTH + RECT_DISTANCE) + RECT_DISTANCE;
            int YPosition = RECT_INFO[i][0]/TOTAL_PAINT_TIME*currPaintTimes;
            canvas.drawRect(XPosition, getHeight()-YPosition, XPosition+ RECT_WIDTH, getHeight(), paint);
        }
        System.out.println(currPaintTimes);
        if (currPaintTimes < TOTAL_PAINT_TIME){
            invalidate();
        }
    }

}
