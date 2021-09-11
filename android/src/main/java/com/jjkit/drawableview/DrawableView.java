package com.jjkit.drawableview;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.view.ViewGroup;

public class DrawableView extends ViewGroup {


    private final SVGDrawable mDrawable = new SVGDrawable();

    DrawableView(Context context){
        super(context);
        setClipChildren(false);
        mDrawable.setShape(SVGDrawable.SVG_PATH);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) {
            //shadow layer
            setLayerType(LAYER_TYPE_SOFTWARE,null);
        }
    }

    SVGDrawable getDrawable(){
        return mDrawable;
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        mDrawable.draw(canvas);
        super.dispatchDraw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mDrawable.setBounds(0,0,w,h);
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}