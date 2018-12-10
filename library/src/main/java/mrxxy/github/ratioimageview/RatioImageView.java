package mrxxy.github.ratioimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class RatioImageView extends android.support.v7.widget.AppCompatImageView {

    private static final String TAG = RatioImageView.class.getSimpleName();

    private float ratio;

    public RatioImageView(Context context) {
        this(context, null);
    }

    public RatioImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RatioImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RatioImageView, defStyleAttr, 0);

        ratio = typedArray.getFloat(R.styleable.RatioImageView_ratio, 0);
        if (ratio == 0) {
            float ratioW = typedArray.getFloat(R.styleable.RatioImageView_ratio_w, 0);
            float ratioH = typedArray.getFloat(R.styleable.RatioImageView_ratio_h, 1);
            ratio = ratioW / ratioH;
        }

        typedArray.recycle();
    }

    /**
     * 设置比例
     *
     * @param ratio 宽高比
     */
    public void setRatio(float ratio) {
        this.ratio = ratio;
        invalidate();
    }

    public void setRatio(float widthRatio, @FloatRange(from = 0.1) float heightRatio) {
        setRatio(widthRatio / heightRatio);
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthPadding = getPaddingStart() + getPaddingEnd();
        int heightPadding = getPaddingTop() + getPaddingBottom();
        int width = MeasureSpec.getSize(widthMeasureSpec) - widthPadding;
        int height = MeasureSpec.getSize(heightMeasureSpec) - heightPadding;
        if (ratio != 0) {
            if (widthMode == MeasureSpec.EXACTLY) {
                // 宽度确定时计算新高度
                height = (int) (width / ratio + 0.5f) + heightPadding;
                heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
            } else if (heightMode == MeasureSpec.EXACTLY) {
                // 高度确定时计算新宽度
                width = (int) (height * ratio + 0.5f) + widthPadding;
                widthMeasureSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY);
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}
