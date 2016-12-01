package com.mcxtzhang.databindingutils.customview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 介绍：
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 2016/12/1.
 */

public class CstView extends View {
    public CstView(Context context) {
        super(context);
    }

    public CstView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CstView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private String count;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    private int haha;

    public int getHaha() {
        return haha;
    }

    public void setHaha(int haha) {
        this.haha = haha;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setTextSize(200);
        canvas.drawText(haha + "", 500, 500, paint);
    }
}
