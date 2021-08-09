package com.jjkit.drawableview;

import android.graphics.BlurMaskFilter;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SVGDrawable extends Drawable{


        static final int NONE = 0;
        static final int CIRCLE = 1;
        static final int SVG_PATH = 2;
        static final int RADIUS_RELATIVE_WIDTH = 3;
        static final int RADIUS_RELATIVE_HEIGHT = 4;
        static final int VIEW_BOX_MEET = 0;
        static final int VIEW_BOX_SLICE = 1;
        static final int VIEW_BOX_NONE = 2;
        static final int AXIS_X = 1;
        static final int AXIS_Y = 2;
        static final int AXIS_Z = 3;
     

private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
private final Paint mPaintBg = new Paint(Paint.ANTI_ALIAS_FLAG);
private final Paint mPaintStroke = new Paint(Paint.ANTI_ALIAS_FLAG);
private float  mRotationX  = 0f;
private float mRotationY  = 0f;
private float mRotationZ  = 0f;
private int[] mRotationOrder = {AXIS_Z, AXIS_X, AXIS_Y};
private float mTranslationX  = 0f;
private float mTranslationY  = 0f;
private float mTranslationPlusX  = 0f;
private float mTranslationPlusY  = 0f;
private boolean mIsTranslationPercent  = false;
private float mScaleX   = 1f;
private float mScaleY   = 1f;
private float mInsetX = 0f;
private float mInsetY = 0f;
private final RectF mBaseRect = new RectF();
private final RectF mRect = new RectF();
private float[] mRadius  = {0f,0f,0f,0f,0f,0f,0f,0f};
private int mShape = NONE;
private String mSvgPath = "";
private String mSvgAlign = "none";
private int mSvgAspect = VIEW_BOX_NONE;
private final RectF mVbRect = new RectF();
private final Matrix mVbMatrix = new Matrix();
private final Matrix mCanvasMatrix = new Matrix();
private float mDensity = 1f;
private final PathMeasure mPathMeasure = new PathMeasure();

//MAR: STROKE start and end

private float mStrokeStart = 0f;
private float mStrokeEnd = 1f;

//MARK : SHADOW PROPS
private float mShadowOffsetX = 0f;
private float mShadowOffsetY = 0f;
private boolean mIsShadowOffsetPercent = false;
private float mShadowRadius = 2f;
private float mShadowOpacity = 0f;
private int mShadowColor = Color.BLACK;

//MARK: Path PROPS;
private final Path mPath  = new Path();
private final Path mPathStroke = new Path();
private float mPathScaleX = 1f;
private float mPathScaleY = 1f;
private float mPathTranslationX = 0f;
private float mPathTranslationY = 0f;
private float mPathRotation = 0f;
private boolean mIsPathTranslationPercent = false;
private float mPathTranslationPlusX = 0f;
private float mPathTranslationPlusY = 0f;
private final Matrix mPathMatrix = new Matrix();
private final RectF mPathBounds = new RectF();

private float mBlurRadius = 0f;
private float mBorderBlurRadius = 0f;
private float mBgBlurRadius = 0f;

        SVGDrawable() {
                mPaint.setStyle(Paint.Style.FILL);
                mPaint.setColor(Color.TRANSPARENT); 
                mPaint.setStrokeWidth(0f);
                mPaintBg.setStyle(Paint.Style.FILL);
                mPaintBg.setColor(Color.TRANSPARENT);
                mPaintStroke.setStyle(Paint.Style.STROKE);
                mPaintStroke.setStrokeWidth(0f);
                mPaintStroke.setColor(Color.BLACK);

        }

        SVGDrawable setBlur(float radius)  {
        mBlurRadius = radius;
        mBorderBlurRadius = radius;
        mBgBlurRadius = radius;
        return this;
        }
        SVGDrawable setBackgroundBlur(float radius)  {
        mBgBlurRadius = radius;
        return this;
        }
        SVGDrawable setFillBlur(float radius)  {
        mBlurRadius = radius;
        return this;
        }
        SVGDrawable setBorderBlur(float radius)  {
        mBorderBlurRadius = radius;
        return this;
        }

        //MARK: Path set and get
        SVGDrawable setPathScale(float sx,float sy)  {
        mPathScaleX = sx;
        mPathScaleY = sy;
        return this;
        }

        SVGDrawable setPathRotation(float degrees)  {
        mPathRotation = degrees;
        return this;
        }
        //pixels
        SVGDrawable setPathTranslation(float dx,float dy)  {
        mIsPathTranslationPercent = false;
        mPathTranslationX = dx;
        mPathTranslationY = dy;
        return this;
        }

        SVGDrawable setPathTranslation(float percentX,float percentY, float plusX, float plusY)  {
        mPathTranslationX = percentX;
        mPathTranslationY = percentY;
        mPathTranslationPlusX = plusX;
        mPathTranslationPlusY = plusY;
        mIsPathTranslationPercent = true;
        return this;
        }

        //MARK: SHADOW SET

        SVGDrawable setShadowOffset(float x,float y ,boolean percent)   {
        mShadowOffsetX = x;
        mShadowOffsetY = y;
        mIsShadowOffsetPercent = percent;
        return this;
        }

        SVGDrawable setShadowRadius(float r)  {
        mShadowRadius = r;
        return this;
        }

        SVGDrawable setShadowOpacity(float o)   {
        mShadowOpacity = ModUtil.clamp(o);
        return this;
        }

        SVGDrawable setShadowColor(int c)   {
        mShadowColor = c;
        return this;
        }

        //MARK: STROKE SET
        SVGDrawable setStrokeWidth(float w)  {
        mPaint.setStrokeWidth(w);
        mPaintStroke.setStrokeWidth(w);
        return this;
        }

        SVGDrawable setStrokeColor(int color)  {
        mPaintStroke.setColor(color);
        return this;
        }
        SVGDrawable setStrokeStart(float s){
        mStrokeStart = ModUtil.clamp(s);
        return this;
        }

        SVGDrawable setStrokeEnd(float e)  {
        mStrokeEnd =  ModUtil.clamp(e);
        return this;
        }
        SVGDrawable setStrokeCap(Paint.Cap cap)   {
        mPaintStroke.setStrokeCap(cap);
        return this;
        }
        SVGDrawable setStrokeMiter(float miter) {
        mPaintStroke.setStrokeMiter(miter);
        return this;
        }
        SVGDrawable setStrokeJoin(Paint.Join join)  {
        mPaintStroke.setStrokeJoin(join);
        return this;
        }

        //MARK: LAYER SET

        SVGDrawable setSvgPath(String d,float density,float[] viewBox,String align,int aspect)  {
        mSvgPath = d;
        mSvgAlign = align;
        mSvgAspect = aspect;
        mDensity = density;
        mVbRect.set(viewBox[0] * density ,viewBox[1] * density,(viewBox[0] + viewBox[2]) * density ,(viewBox[1] + viewBox[3]) * density);
        return this;
        }

        SVGDrawable setShape(int s)   {
        mShape = s;
        return this;
        }

        SVGDrawable setRadius(float v)  {
        mRadius = new float[]{v,v,v,v,v,v,v,v};
        return this;
        }

        SVGDrawable setRadius(float topLeft,float topRight,float bottomLeft,float bottomRight)   {
        mRadius = new float[]{topLeft,topLeft,topRight,topRight,bottomRight,bottomRight,bottomLeft,bottomLeft};
        return this;
        }

        SVGDrawable setFillColor(int c)  {
        mPaint.setColor(c);
        return this;
        }

        SVGDrawable setBackgroundColor(int c){
        mPaintBg.setColor(c);
        return this;
        }
        SVGDrawable setInset(float dx,float dy){
        mInsetX = dx;
        mInsetY = dy;
        return this;
        }

        //MARK: layer set transform

        SVGDrawable setScale(float sx,float sy) {
        mScaleX = sx;
        mScaleY = sy;
        return this;
        }

        SVGDrawable setRotationZ(float degrees)  {
        mRotationZ = degrees;

        return this;
        }
        SVGDrawable setRotationX(float degrees) {
        mRotationX = degrees;
        return this;
        }
        SVGDrawable setRotationY(float degrees)  {
        mRotationY = degrees;
        return this;
        }
        SVGDrawable setRotationOrder(int f,int s,int t)  {
        if(f < 0 || f > 3 ){ return this; }
        if(t < 0 || t > 3){ return this; }
        if(s < 0 || s > 3){ return this;}
        if((f == s || f == t) || (s == t)){ return this; }
        mRotationOrder = new int[]{f,s,t};
        return this;
        }
        //pixels
        SVGDrawable setTranslation(float dx,float dy)  {
        mIsTranslationPercent = false;
        mTranslationX = dx;
        mTranslationY = dy;
        return this;
        }

        SVGDrawable setTranslation(float percentX,float percentY,float plusX,float plusY)  {
        mTranslationX = percentX;
        mTranslationY = percentY;
        mTranslationPlusX = plusX;
        mTranslationPlusY = plusY;
        mIsTranslationPercent = true;
        return this;
        }


        private float mBoundsX = 0f;
        private float mBoundsY = 0f;
        private float mBoundsWidth = 0f;
        private float mBoundsHeight = 0f;
        private boolean mIsBoundsDynamically = false;
        private boolean mIsBoundsPercentPos = false;
        private boolean mIsBoundsPercentSize = false;

        SVGDrawable setBoundsDynamically(float x,float y,float width,float height,boolean percentPos, boolean percentSize)  {
        mIsBoundsDynamically = true;
        mIsBoundsPercentPos = percentPos;
        mIsBoundsPercentSize = percentSize;
        mBoundsX = x;
        mBoundsY = y;
        mBoundsWidth = width;
        mBoundsHeight = height;
        return this;
        }

private final RectF mBlurRect = new RectF();
        //MARK: DRAWABLE METHODS


        @Override
        protected void onBoundsChange(Rect bounds) {
                if(bounds != null){
                        if(mIsBoundsPercentPos){
                                mBoundsX *= bounds.width();
                                mBoundsY *= bounds.height();
                        }
                        if(mIsBoundsPercentSize){
                                mBoundsWidth *= bounds.width();
                                mBoundsHeight *= bounds.height();
                        }
                        if(mIsBoundsDynamically){
                                mBaseRect.set(mBoundsX,mBoundsY,mBoundsX+mBoundsWidth,mBoundsY+mBoundsHeight);
                        }else{
                                mBaseRect.set(bounds);
                        }
                }
        }

        @Override
        public void draw(@NonNull Canvas canvas) {
                if(getBounds().width() > 0f && getBounds().height() >0f) {

                        setupRect();
                        setupPath();

                        setupCanvasMatrix();

                        int checkpoint = canvas.save();
                        canvas.concat(mCanvasMatrix);
                        try {

                                if(mPaintBg.getColor() != Color.TRANSPARENT) {
                                        mBlurRect.set(mBaseRect);
                                        mPaintBg.setMaskFilter(mBgBlurRadius > 0f ? new BlurMaskFilter(mBgBlurRadius, BlurMaskFilter.Blur.NORMAL) : null );
                                        if(mBlurRadius > 0f ){
                                                mBlurRect.inset(mBgBlurRadius,mBgBlurRadius);
                                        }
                                        canvas.drawRect(mBlurRect,mPaintBg);
                                }

                                if (mPaint.getColor() != Color.TRANSPARENT || mShadowOpacity > 0f) {
                                        if(mShadowOpacity > 0f){
                                                final int alpha = Color.alpha(mShadowColor);
                                                final  int red = Color.red(mShadowColor);
                                                final int green = Color.green(mShadowColor);
                                                final int blue = Color.blue(mShadowColor);
                                                final int c = Color.argb((int)(mShadowOpacity * alpha),red,green,blue);

                                                float ox = mShadowOffsetX;
                                                float oy = mShadowOffsetY;
                                                if(mIsShadowOffsetPercent){
                                                        ox = mShadowOffsetX * mBaseRect.width();
                                                        oy = mShadowOffsetY * mBaseRect.height();
                                                }
                                                mPaint.setShadowLayer(mShadowRadius,ox,oy,c);
                                        }else{
                                                mPaint.clearShadowLayer();
                                        }
                                        mPaint.setMaskFilter(mBlurRadius > 0f ? new BlurMaskFilter(mBlurRadius,BlurMaskFilter.Blur.NORMAL) : null);
                                        canvas.drawPath(mPath, mPaint);
                                }
                                if (mPaintStroke.getColor() != Color.TRANSPARENT && mPaintStroke.getStrokeWidth() > 0f && mStrokeStart < mStrokeEnd) {
                                        mPaintStroke.setMaskFilter(mBorderBlurRadius > 0f ? new BlurMaskFilter(mBorderBlurRadius,BlurMaskFilter.Blur.NORMAL) : null);
                                        if(mStrokeStart != 0f || mStrokeEnd != 1f){
                                                mPathStroke.reset();
                                                mPathMeasure.setPath(mPath,false);
                                                mPathMeasure.getSegment((mPathMeasure.getLength() * mStrokeStart),(mPathMeasure.getLength() * mStrokeEnd),mPathStroke,true);
                                                mPathStroke.rLineTo(0f,0f);
                                                canvas.drawPath(mPathStroke, mPaintStroke);
                                        }else{
                                                canvas.drawPath(mPath, mPaintStroke);
                                        }

                                }
                        } finally {
                                canvas.restoreToCount(checkpoint);
                        }


                }
        }

        private final Camera mCamera = new Camera();
private void setupCanvasMatrix(){
        float  transX = mTranslationX;
        float transY = mTranslationY;
        if(mIsTranslationPercent){
        transX = (mTranslationX * getBounds().width()) + mTranslationPlusX;
        transY = (mTranslationY * getBounds().height()) + mTranslationPlusY;
        }

        mCanvasMatrix.reset();
        mCamera.save();

        for(int e : mRotationOrder){
                if(e == AXIS_Z){
                mCamera.rotate(0f,0f, -mRotationZ);
                }
                if(e == AXIS_X){
                mCamera.rotate(-mRotationX,0f, 0f);
                }
                if(e == AXIS_Y){
                mCamera.rotate(0f,-mRotationY, 0f);
                }
        }

        mCamera.getMatrix(mCanvasMatrix);
        mCamera.restore();

        mCanvasMatrix.postScale(mScaleX,mScaleY);
        mCanvasMatrix.preTranslate(-mBaseRect.centerX(),-mBaseRect.centerY());
        mCanvasMatrix.postTranslate(mBaseRect.centerX(),mBaseRect.centerY());
        mCanvasMatrix.postTranslate(transX,transY);
        }

        @Override
        public void setAlpha(int alpha) {
                mPaint.setAlpha(alpha);
                mPaintStroke.setAlpha(alpha);
                invalidateSelf();
        }

        @Override
        public int getOpacity() {
                return PixelFormat.TRANSLUCENT;
        }

        @Override
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
                mPaintStroke.setColorFilter(colorFilter);
                mPaint.setColorFilter(colorFilter);
                invalidateSelf();
        }

        private void setupRect(){
                mRect.set(mBaseRect);
                mRect.inset( mInsetX, mInsetY);

        }

private void setupPath(){
        mPath.reset();
        switch(mShape){
        case CIRCLE :
                final float radius = Math.min(mRect.height(),mRect.width()) / 2f;
                for (int  i = 0 ; i < 8; i++){
                        mRadius[i] = radius;
                }
                mPath.addRoundRect(mRect,mRadius,Path.Direction.CW);
        break;
        case RADIUS_RELATIVE_HEIGHT: case RADIUS_RELATIVE_WIDTH :
                final float  tl = ModUtil.clamp(mRadius[0]);
                final float tr = ModUtil.clamp(mRadius[2]);
                final float br = ModUtil.clamp(mRadius[4]);
                final float bl = ModUtil.clamp(mRadius[6]);
                final float size = mShape == RADIUS_RELATIVE_WIDTH ? mRect.width() : mRect.height();
                mRadius[0] = tl * size;
                mRadius[1] = tl * size;
                mRadius[2] = tr * size;
                mRadius[3] = tr * size;
                mRadius[4] = br * size;
                mRadius[5] = br * size;
                mRadius[6] = bl * size;
                mRadius[7] = bl * size;
                mPath.addRoundRect(mRect,mRadius,Path.Direction.CW);
        break;
                case SVG_PATH :
        try{
                SVGPathParser.mScale = mDensity;
                final Path p = SVGPathParser.parse(mSvgPath);
                mPath.set(p);
                if (mVbRect.width() > 0f && mVbRect.height() > 0f){
                         SVGViewBox.transform(mVbRect,mRect,mSvgAlign,mSvgAspect,mVbMatrix);
                        mPath.transform(mVbMatrix);
                }
        }catch(Error ignored) {

        }

        break;
        default:
                mPath.addRoundRect(mRect,mRadius,Path.Direction.CW);
        break;

        }


        //path transform
        float  transX = mPathTranslationX;
        float transY = mPathTranslationY;
        if(mIsPathTranslationPercent){
                transX = (mPathTranslationX * mBaseRect.width()) + mPathTranslationPlusX;
                transY = (mPathTranslationY * mBaseRect.height()) + mPathTranslationPlusY;
        }
        mPathBounds.set(0f,0f,0f,0f);
        mPath.computeBounds(mPathBounds,true);
        mPathMatrix.reset();
        mPathMatrix.postRotate(mPathRotation,mPathBounds.centerX(),mPathBounds.centerY());
        mPathMatrix.postScale(mPathScaleX,mPathScaleY,mPathBounds.centerX(),mPathBounds.centerY());
        mPathMatrix.postTranslate(transX,transY);
        mPath.transform(mPathMatrix);
        }

}