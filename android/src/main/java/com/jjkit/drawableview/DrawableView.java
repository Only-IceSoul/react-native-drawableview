package com.jjkit.drawableview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewGroup;

import java.util.Objects;

public class DrawableView extends ViewGroup {

    DrawableView(Context context){
        super(context);
        setClipChildren(false);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) {
            //shadow layer
            setLayerType(LAYER_TYPE_SOFTWARE,null);
        }
        mPaint.setStyle(Paint.Style.FILL);
        mPaintStroke.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        drawPath(canvas);
        super.dispatchDraw(canvas);
    }

    //MARK: DRAW
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint mPaintStroke = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final RectF mRectPath = new RectF();
    private final Path mPath = new Path();
    private final Path mPath2 = new Path();
    private final PathMeasure mPathMeasure = new PathMeasure();
    private final RectF mBounds = new RectF();
    private final Matrix mMatrix = new Matrix();
    private String mD = "";
    private final RectF mRectVb = new RectF();
    private final RectF mRectVbDensity = new RectF();
    private String mAlign = "xMidYMid";
    private int mAspect = SVGViewBox.MOS_MEET;
    private final DrawableTransform mTransform = new DrawableTransform();
    private final DrawableProps mProps = new DrawableProps();
    public void setD(String d){
        mD = d;
        invalidate();
    }

    public void setViewBox(float[] viewBox){
        float density = getResources().getDisplayMetrics().density;
        mRectVb.set(viewBox[0]  ,viewBox[1] ,(viewBox[0] + viewBox[2])  ,(viewBox[1] + viewBox[3]) );
        mRectVbDensity.set(viewBox[0] * density ,viewBox[1] * density,(viewBox[0] + viewBox[2]) * density ,(viewBox[1] + viewBox[3]) * density );
        invalidate();
    }

    public void setAlign(String align){
        if(!mAlign.equals(align)){
            mAlign = align;
            invalidate();
        }
    }
    public void setAspect(int aspect){
        if(mAspect != aspect){
            mAspect = aspect;
            invalidate();
        }
    }

    protected float mTranslationZ = 0f;
    public void setTranslateZ(float v) {
        if(mTranslationZ != v ){
            mTranslationZ = v;
            setTranslationZ(mTranslationZ);
        }
    }
    public void setOpacity(float v) {
        if(mProps.mOpacity != v) {
            mProps.mOpacity = v;
            invalidate();
        }
    }

    public void setFill(int v) {
        if(mProps.mFillColor != v) {
            mProps.mFillColor = v;
            invalidate();
        }
    }
    public void setFillRule(String v) {
        if(!Objects.equals(mProps.mFillRule, v)) {
            mProps.mFillRule = v;
            invalidate();
        }
    }
    public void setFillOpacity(float v ) {
        if(mProps.mFillOpacity != v) {
            mProps.mFillOpacity = v;
            invalidate();
        }
    }
    public void setStroke(int v) {
        if(mProps.mStrokeColor != v) {
            mProps.mStrokeColor = v;
            invalidate();
        }
    }
    public void setStrokeOpacity(float v) {
        if(mProps.mStrokeOpacity != v) {
            mProps.mStrokeOpacity = v;
            invalidate();
        }
    }
    public void setStrokeWith(float v) {
        if(mProps.mStrokeWidth != v) {
            mProps.mStrokeWidth = v;
            invalidate();
        }

    }

    public void setStrokeCap(String v) {
        if(!Objects.equals(mProps.mStrokeCap, v)) {
            mProps.mStrokeCap = v;
            invalidate();
        }
    }

    public void setStrokeJoin(String v) {
        if(!Objects.equals(mProps.mStrokeJoin, v)) {
            mProps.mStrokeJoin = v;
            invalidate();
        }
    }

    public void setStrokeMiter(float v) {
        if(mProps.mStrokeMiter != v) {
            mProps.mStrokeMiter = v;
            invalidate();
        }
    }

    public void setStrokeStart(float v) {
        if(mProps.mStrokeStart != v) {
            mProps.mStrokeStart = v;
            invalidate();
        }
    }

    public void setStrokeEnd(float v) {
        if(mProps.mStrokeEnd != v){
            mProps.mStrokeEnd = v;
            invalidate();
        }
    }

    public void setShadow(int v) {
        if(mProps.mShadowColor != v){
            mProps.mShadowColor = v;
            invalidate();
        }
    }

    public void setShadowOpacity(float v ) {
        if(mProps.mShadowOpacity != v) {
            mProps.mShadowOpacity = v;
            invalidate();
        }
    }

    public void setShadowRadius(float v ) {
        if(mProps.mShadowRadius != v){
            mProps.mShadowRadius = v;
            invalidate();
        }
    }

    public void setShadowOffset(float v) {
        if(mProps.mShadowOffsetX != v || mProps.mShadowOffsetY != v ){
            mProps.mShadowOffsetX = v;
            mProps.mShadowOffsetY = v;
            invalidate();
        }
    }
    public void setShadowOffsetX(float v) {
        if(mProps.mShadowOffsetX != v){
            mProps.mShadowOffsetX = v;
            invalidate();
        }
    }
    public void setShadowOffsetY(float v) {
        if(mProps.mShadowOffsetY != v ){
            mProps.mShadowOffsetY = v;
            invalidate();
        }
    }
    public void setShadowPercentageValue(boolean v) {
        if(mProps.mShadowOffsetIsPercent != v ){
            mProps.mShadowOffsetIsPercent = v;
            invalidate();
        }
    }

    //MARK: Transform props
    public void setTransX(float v) {
        if(mTransform.mTranslationX != v ){
            mTransform.mTranslationX = v;
            invalidate();
        }
    }
    public void setTransY(float v) {
        if(mTransform.mTranslationY != v ){
            mTransform.mTranslationY = v;
            invalidate();
        }
    }
    public void setTransPercentageValue(boolean v) {
        if(mTransform.mTranslationIsPercent != v ){
            mTransform.mTranslationIsPercent = v;
            invalidate();
        }
    }

    public void setRot(float v) {
        if(mTransform.mRotation != v ){
            mTransform.mRotation = v;
            invalidate();
        }
    }
    public void setRotO(float v) {
        if(mTransform.mRotationOx != v || mTransform.mRotationOy != v ){
            mTransform.mRotationOx = v;
            mTransform.mRotationOy = v;
            invalidate();
        }
    }
    public void setRotOx(float v) {
        if(mTransform.mRotationOx != v ){
            mTransform.mRotationOx = v;
            invalidate();
        }
    }
    public void setRotOy(float v) {
        if(mTransform.mRotationOy != v ){
            mTransform.mRotationOy = v;
            invalidate();
        }
    }
    public void setRotPercentageValue(boolean v) {
        if(mTransform.mRotationIsPercent != v ){
            mTransform.mRotationIsPercent = v;
            invalidate();
        }
    }
    public void setSc(float v){
        if(mTransform.mScaleX != v || mTransform.mScaleY != v){
            mTransform.mScaleX = v;
            mTransform.mScaleY = v;
            invalidate();
        }
    }
    public void setScX(float v) {
        if(mTransform.mScaleX != v ){
            mTransform.mScaleX = v;
            invalidate();
        }
    }

    public void setScY(float v) {
        if(mTransform.mScaleY != v ){
            mTransform.mScaleY = v;
            invalidate();
        }
    }
    public void setScO(float v){
        if(mTransform.mScaleOriginX != v || mTransform.mScaleOriginY != v){
            mTransform.mScaleOriginX = v;
            mTransform.mScaleOriginY = v;
            invalidate();
        }
    }
    public void setScOx(float v) {
        if(mTransform.mScaleOriginX != v ){
            mTransform.mScaleOriginX = v;
            invalidate();
        }
    }
    public void setScOy(float v) {
        if(mTransform.mScaleOriginY != v ){
            mTransform.mScaleOriginY = v;
            invalidate();
        }
    }
    public void setScPercentageValue(boolean v) {
        if(mTransform.mScaleIsPercent != v ){
            mTransform.mScaleIsPercent = v;
            invalidate();
        }
    }


    private void drawPath(Canvas canvas){

        setupPath();

        viewBoxTransform();

        props();

        transform();

        int checkpoint = canvas.save();
        canvas.concat(mMatrix);
        try {
            if(fill()) canvas.drawPath(mPath, mPaint);
            if(stroke())  canvas.drawPath(mPath2,mPaintStroke);
        } finally {
            canvas.restoreToCount(checkpoint);
        }
    }

    private void setupPath(){
        float density = getResources().getDisplayMetrics().density;
        mPath.reset();
        try{
            SVGPathParser.mScale = density;
            final Path p = SVGPathParser.parse(mD);
            mPath.set(p);
        }catch(Error ignored) {

        }
    }

    private void viewBoxTransform(){
        float density = getResources().getDisplayMetrics().density;
        if (validateViewBox()){
            mRectPath.set(mRectVbDensity);
            SVGViewBox.transform(mRectVb,mBounds, mAlign,mAspect,density,mMatrix);
            mPath.transform(mMatrix);
            mMatrix.mapRect(mRectPath);
        }else{
            mRectPath.set(mBounds);
        }
    }


    protected void transform() {
        mMatrix.reset();

        if (mTransform.mRotation != 0f) {
            float rotX;
            float rotY;
            if (mTransform.mRotationIsPercent) {
                rotX = (mTransform.mRotationOx * getWidth());
                rotY = (mTransform.mRotationOy * getHeight());
            } else if (validateViewBox()) {
                rotX =  mRectPath.left +  ModUtil.viewBoxToWidth(mTransform.mRotationOx, mRectVb,mRectPath.width());
                rotY =  mRectPath.top + ModUtil.viewBoxToHeight(mTransform.mRotationOy, mRectVb, mRectPath.height());
            } else {
                rotX = toDip(mTransform.mRotationOx);
                rotY =  toDip(mTransform.mRotationOy);
            }
            mMatrix.postRotate(mTransform.mRotation,rotX,rotY);
        }

        if (mTransform.mScaleX != 1f || mTransform.mScaleY != 1f) {
            float oX;
            float oY;
            if (mTransform.mScaleIsPercent) {
                oX = (mTransform.mScaleOriginX * getWidth());
                oY = (mTransform.mScaleOriginY * getHeight());
            } else if (validateViewBox()) {
                oX =  mRectPath.left +  ModUtil.viewBoxToWidth(mTransform.mScaleOriginX, mRectVb,mRectPath.width()) ;
                oY =  mRectPath.top +   ModUtil.viewBoxToHeight(mTransform.mScaleOriginY, mRectVb,mRectPath.height()) ;
            } else {
                oX = toDip(mTransform.mScaleOriginX);
                oY = toDip(mTransform.mScaleOriginY);
            }
            mMatrix.postScale(mTransform.mScaleX,mTransform.mScaleY,oX,oY);

        }

        if (mTransform.mTranslationX != 0f || mTransform.mTranslationY != 0f) {
            float transX;
            float transY;
            if (mTransform.mTranslationIsPercent) {
                transX = (mTransform.mTranslationX * getWidth());
                transY = (mTransform.mTranslationY * getHeight());
            } else if (validateViewBox()) {
                transX = (mTransform.mTranslationX / mRectVb.width()) * mRectPath.width();
                transY = (mTransform.mTranslationY / mRectVb.height()) * mRectPath.height();
            } else {
                transX = toDip(mTransform.mTranslationX);
                transY = toDip(mTransform.mTranslationY);
            }
            mMatrix.postTranslate(transX,transY);
        }

    }
    private void props(){

        mPath.setFillType(mProps.getFillRule());

        if (fill()) {
            setupPaintFill();
            setupShadow(mPaint);
        }

        if (stroke()){
            setupPaintStroke();
            setupPathStroke();
            if (!fill()) setupShadow(mPaintStroke);
        }

    }

    protected void setupPaintFill() {
        mPaint.setColor(mProps.getFillColor());
        float opacity = mProps.getFillOpacity() * mProps.getOpacity();
        mPaint.setAlpha((int) (opacity * 255f));

    }
    protected void setupPaintStroke() {
        float sw ;
        if (validateViewBox()) {
            float size = Math.max( mRectPath.width(), mRectPath.height() );
            sw =  mProps.getStrokeWidth() / Math.max( mRectVb.width(), mRectVb.height() ) * size;
        }else{
            sw = toDip(mProps.getStrokeWidth());
        }
        mPaintStroke.setStrokeWidth(sw);
        mPaintStroke.setColor(mProps.getStrokeColor());

        float opacity = mProps.getStrokeOpacity() * mProps.getOpacity();
        mPaintStroke.setAlpha((int)(opacity * 255f));

        mPaintStroke.setStrokeCap(mProps.getStrokeCap());
        mPaintStroke.setStrokeMiter(mProps.getStrokeMiter());
        mPaintStroke.setStrokeJoin(mProps.getStrokeJoin());
    }

    protected void setupShadow(Paint paint) {
        if (mProps.getShadowOpacity() > 0f) {
            final int alpha = Color.alpha(mProps.getShadowColor());
            final int red = Color.red(mProps.getShadowColor());
            final int green = Color.green(mProps.getShadowColor());
            final int blue = Color.blue(mProps.getShadowColor());
            final int c = Color.argb((int) (mProps.getShadowOpacity() * alpha), red, green, blue);

            float ox;
            float oy;
            if (mProps.getShadowOffsetIsPercent()) {
                ox = mProps.getShadowOffsetX() * getWidth();
                oy = mProps.getShadowOffsetY() * getHeight();
            } else if (validateViewBox()) {
                ox = (mProps.getShadowOffsetX() / mRectVb.width()) * mRectPath.width();
                oy = (mProps.getShadowOffsetY() / mRectVb.height()) * mRectPath.height();
            } else {
                ox = toDip(mProps.getShadowOffsetX());
                oy = toDip(mProps.getShadowOffsetY());
            }

            float radius;
            if (validateViewBox()) {
                float size = Math.max( mRectPath.width(), mRectPath.height() );
                radius =  (mProps.getShadowRadius() /  Math.max( mRectVb.width(), mRectVb.height() ) ) * size;
            }else{
                radius = toDip(mProps.getShadowRadius());
            }
            paint.setShadowLayer(radius, ox, oy, c);

        } else {
            paint.clearShadowLayer();
        }
    }

    protected void setupPathStroke(){
        mPath2.reset();
        if(mProps.getStrokeStart() != 0f || mProps.getStrokeEnd() != 1f) {
            mPathMeasure.setPath(mPath, false);
            mPathMeasure.getSegment((mPathMeasure.getLength() * mProps.getStrokeStart()), (mPathMeasure.getLength() * mProps.getStrokeEnd()), mPath2, true);
            mPath2.rLineTo(0f, 0f);
        }else{
            mPath2.set(mPath);
        }

    }

    protected boolean stroke(){
        return  mProps.getStrokeColor() != Color.TRANSPARENT && mProps.getStrokeWidth() > 0f;
    }
    protected boolean fill(){
        return  mProps.getFillColor() != Color.TRANSPARENT;
    }

    private boolean validateViewBox(){
        return mRectVb.width() >= 0f && mRectVb.height() >= 0f;
    }

    protected float toDip(float value) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,value,getResources().getDisplayMetrics());
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mBounds.set(0f,0f,w,h);
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }



}