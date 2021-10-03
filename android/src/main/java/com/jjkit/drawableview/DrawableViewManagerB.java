package com.jjkit.drawableview;

import android.graphics.Color;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

class DrawableViewManagerB extends ViewGroupManager<DrawableViewB> {


    @Override
    public String getName() {
        return "JJSDrawableB";
    }

    @Override
    protected DrawableViewB createViewInstance(@NonNull ThemedReactContext reactContext) {
        return new DrawableViewB(reactContext);
    }

    @ReactProp(name = "d")
    public void setD(DrawableViewB view, String v){
        String p = v == null ? "" :  v;
        view.setD(p);
    }
    @ReactProp(name = "viewBox")
    public void setViewBox(DrawableViewB view, ReadableArray viewBox){
        float [] v = {0f,0f,-1f,-1f};
        if(viewBox != null) {
            v[0] = (float) viewBox.getDouble(0);
            v[1] = (float) viewBox.getDouble(1);
            v[2] = (float) viewBox.getDouble(2);
            v[3] = (float) viewBox.getDouble(3);
        }
        view.setViewBox(v);
    }

    @ReactProp(name = "align")
    public void setAlign(DrawableViewB view, String v){
        String p = v == null ? "xMidYMid" :  v;
        view.setAlign(p);
    }
    @ReactProp(name = "aspect")
    public void setAspect(DrawableViewB view, String v){
        int p = v == null ? SVGViewBox.MOS_MEET :  (v.equals("slice") ? SVGViewBox.MOS_SLICE :  (v.equals("none") ? SVGViewBox.MOS_NONE : SVGViewBox.MOS_MEET ) );
        view.setAspect(p);
    }

    @ReactProp(name = "translateZ",defaultFloat = 0f)
    public void setTranslateZ(DrawableViewB view ,float v) {
        view.setTranslateZ(v);
    }
    @ReactProp(name = "opacity",defaultFloat = 1f)
    public void setOpacity(DrawableViewB view ,float v) {
        view.setOpacity(v);
    }

    @ReactProp(name = "fill",defaultInt = Color.BLACK)
    public void setFill(DrawableViewB view , int v) {
        view.setFill(v);
    }
    @ReactProp(name = "fillRule")
    public void setFillRule(DrawableViewB view ,String v) {
        view.setFillRule(v == null ? "none" : v);

    }
    @ReactProp(name = "fillOpacity",defaultFloat = 1f)
    public void setFillOpacity(DrawableViewB view ,float v) {
        view.setFillOpacity(v);

    }
    @ReactProp(name = "stroke",defaultInt = Color.TRANSPARENT)
    public void setStroke(DrawableViewB view , int v) {
        view.setStroke(v);

    }
    @ReactProp(name = "strokeOpacity",defaultFloat = 1f)
    public void setStrokeOpacity(DrawableViewB view ,float v) {
        view.setStrokeOpacity(v);

    }

    @ReactProp(name = "strokeWidth",defaultFloat = 1f)
    public void setStrokeWith(DrawableViewB view ,float v) {
        view.setStrokeWith(v);

    }
    @ReactProp(name = "strokeCap")
    public void setStrokeCap(DrawableViewB view ,String v) {
        view.setStrokeCap(v == null ? "none" : v);

    }

    @ReactProp(name = "strokeJoin")
    public void setStrokeJoin(DrawableViewB view ,String v) {
        view.setStrokeJoin(v == null ? "none" : v);

    }
    @ReactProp(name = "strokeMiter",defaultFloat = 4f)
    public void setStrokeMiter(DrawableViewB view ,float v) {
        view.setStrokeMiter(v);

    }

    @ReactProp(name = "strokeStart",defaultFloat = 0f)
    public void setStrokeStart(DrawableViewB view ,float v) {
        view.setStrokeStart(v);

    }
    @ReactProp(name = "strokeEnd",defaultFloat = 1f)
    public void setStrokeEnd(DrawableViewB view ,float v) {
        view.setStrokeEnd(v);

    }

    @ReactProp(name = "shadow",defaultInt = Color.BLACK)
    public void setShadow(DrawableViewB view ,int v) {
        view.setShadow(v);

    }
    @ReactProp(name = "shadowOpacity",defaultFloat = 0f)
    public void setShadowOpacity(DrawableViewB view ,float v) {
        view.setShadowOpacity(v);

    }
    @ReactProp(name = "shadowRadius",defaultFloat = 2f)
    public void setShadowRadius(DrawableViewB view ,float v) {
        view.setShadowRadius(v);

    }

    @ReactProp(name = "shadowOffset",defaultFloat = 2f)
    public void setShadowOffset(DrawableViewB view , float v) {
        view.setShadowOffset(v);
    }
    @ReactProp(name = "shadowOffsetX",defaultFloat = 2f)
    public void setShadowOffsetX(DrawableViewB view , float v) {
        view.setShadowOffsetX(v);
    }
    @ReactProp(name = "shadowOffsetY",defaultFloat = 2f)
    public void setShadowOffsetY(DrawableViewB view , float v) {
        view.setShadowOffsetY(v);
    }
    @ReactProp(name = "shadowPercentageValue",defaultBoolean  = false)
    public void setShadowPercentageValue(DrawableViewB view , boolean v) {
        view.setShadowPercentageValue(v);
    }

    //MARK: Transform

    @ReactProp(name = "transX",defaultFloat = 0f)
    public void setTransX(DrawableViewB view, float v) {
        view.setTransX(v);
    }
    @ReactProp(name = "transY",defaultFloat = 0f)
    public void setTransY(DrawableViewB view, float v) {
        view.setTransY(v);
    }
    @ReactProp(name = "transPercentageValue",defaultBoolean = false)
    public void setTransPercentageValue(DrawableViewB view, boolean v) {
        view.setTransPercentageValue(v);
    }

    @ReactProp(name = "rot",defaultFloat = 0f)
    public void setRot(DrawableViewB view , float v) {
        view.setRot(v);
    }
    @ReactProp(name = "rotO",defaultFloat = 0f)
    public void setRotO(DrawableViewB view , float v) {
        view.setRotO(v);
    }
    @ReactProp(name = "rotOx",defaultFloat = 0f)
    public void setRotOx(DrawableViewB view , float v) {
        view.setRotOx(v);
    }
    @ReactProp(name = "rotOy",defaultFloat = 0f)
    public void setRotOy(DrawableViewB view , float v) {
        view.setRotOy(v);
    }
    @ReactProp(name = "rotPercentageValue",defaultBoolean  = false)
    public void setRotPercentageValue(DrawableViewB view , boolean v) {
        view.setRotPercentageValue(v);
    }

    @ReactProp(name = "sc",defaultFloat = 1f)
    public void setSc(DrawableViewB view, float v) {
        view.setSc(v);
    }
    @ReactProp(name = "scX",defaultFloat = 1f)
    public void setScX(DrawableViewB view, float v) {
        view.setScX(v);
    }
    @ReactProp(name = "scY",defaultFloat = 1f)
    public void setScY(DrawableViewB view, float v) {
        view.setScY(v);
    }
    @ReactProp(name = "scO",defaultFloat = 0f)
    public void setScO(DrawableViewB view, float v) {
        view.setScO(v);
    }
    @ReactProp(name = "scOx",defaultFloat = 0f)
    public void setScOx(DrawableViewB view, float v) {
        view.setScOx(v);
    }
    @ReactProp(name = "scOy",defaultFloat = 0f)
    public void setScOy(DrawableViewB view, float v) {
        view.setScOy(v);
    }
    @ReactProp(name = "scPercentageValue",defaultBoolean = false)
    public void setScPercentageValue(DrawableViewB view, boolean v) {
        view.setScPercentageValue(v);
    }
 
   
}