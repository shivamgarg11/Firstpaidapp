package com.shivam.multitouch;
import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class TouchableFrameLayout extends FrameLayout {

    private SparseArray mActivePointers = new SparseArray();

    private OnTouchListener onTouchListener;

    float lastXPosition;
    float lastYPosition;
    double lastdist = 0;

    Context ctx;
    private boolean onScaleMove = false;

    public TouchableFrameLayout(Context context) {
        super(context);
        ctx = context;
    }


    public TouchableFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        ctx = context;
    }

    public TouchableFrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        ctx = context;
    }

    public void setTouchListener(OnTouchListener onTouchListener) {
        this.onTouchListener = onTouchListener;
    }

    @Override
    public boolean dispatchTouchEvent(final MotionEvent event) {
        if (onTouchListener == null)
            return false;

        int pointerIndex = event.getActionIndex();
        int pointerId = event.getPointerId(pointerIndex);

        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:

                lastYPosition = event.getY();
                lastXPosition = event.getX();
                onTouchListener.onTouch();
                return true;

            case MotionEvent.ACTION_UP:
                onScaleMove = false;
                lastdist = 0;
                onTouchListener.onRelease();
                break;

            case MotionEvent.ACTION_CANCEL:
                onScaleMove = false;
                mActivePointers.remove(pointerId);
                onTouchListener.onRelease();

            return false;
        }
        return super.dispatchTouchEvent(event);
    }


    public interface OnTouchListener {
        void onTouch();

        void onRelease();

    }

}
