package com.jjkit.drawableview;

import android.graphics.Color;
import android.graphics.Paint;
import android.util.TypedValue;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;


class DrawableViewManager extends ViewGroupManager<DrawableView> {


    @Override
    public String getName() {
        return "JJSDrawable";
    }

    @Override
    protected DrawableView createViewInstance(@NonNull ThemedReactContext reactContext) {
        return new DrawableView(reactContext);
    }

    @ReactProp(name = "path")
    public void setPath(DrawableView view, ReadableMap p){
        String d = ModUtil.getString(p,"d","");
        ReadableArray viewBox = ModUtil.getArray(p,"viewBox",null);
        String aspect = ModUtil.getString(p,"aspect","none"); 
        String align = ModUtil.getString(p,"align","none");
        int a  = "meet".equals(aspect) ? SVGDrawable.VIEW_BOX_MEET : (
                "slice".equals(aspect) ? SVGDrawable.VIEW_BOX_SLICE :  SVGDrawable.VIEW_BOX_NONE);
        

        float [] v = {0f,0f,0f,0f};
        if(viewBox != null) {
            v[0] = (float) viewBox.getDouble(0);
            v[1] = (float) viewBox.getDouble(1);
            v[2] = (float) viewBox.getDouble(2);
            v[3] = (float)viewBox.getDouble(3);
        }
        view.getDrawable().setSvgPath(d,view.getResources().getDisplayMetrics().density, v,align,a);
        view.getDrawable().invalidateSelf();
    }
    @ReactProp(name = "pathRotation",defaultFloat = 0f)
    public void setPathRotation(DrawableView view , float r){
        view.getDrawable().setPathRotation(r);
        view.getDrawable().invalidateSelf();
    }
    @ReactProp(name = "pathScale")
    public void setPathScale(DrawableView view,ReadableMap v){
        float x = (float) ModUtil.getDouble(v,"x",1.0);
        float y = (float) ModUtil.getDouble(v,"y",1.0);
        view.getDrawable().setPathScale(x,y);
        view.getDrawable().invalidateSelf();
    }

    @ReactProp(name = "pathTranslation")
    public void setPathTranslation(DrawableView view,ReadableMap v){
        float dx = (float)ModUtil.getDouble(v,"dx",0.0);
        float dy = (float)ModUtil.getDouble(v,"dy",0.0);
        boolean per = ModUtil.getBoolean(v,"percentageValue",false);

        if(per){
            view.getDrawable().setPathTranslation(dx,dy,0f,0f);
        }else{
            view.getDrawable().setPathTranslation(toDip(dx,view),toDip(dy,view));
        }
        view.getDrawable().invalidateSelf();
    }

    @ReactProp(name = "shadow",defaultInt = Color.BLACK)
    public void setShadow(DrawableView view , int v){
        view.getDrawable().setShadowColor(v);
        view.getDrawable().invalidateSelf();
    }
    @ReactProp(name = "shadowOffset")
    public void setShadowOffset(DrawableView view ,ReadableMap v){
        float x = (float) ModUtil.getDouble(v,"x",0.0);
        float y = (float) ModUtil.getDouble(v,"y",0.0);
        view.getDrawable().setShadowOffset(toDip(x,view),toDip(y,view),false);
        view.getDrawable().invalidateSelf();
    }
    @ReactProp(name = "shadowOpacity",defaultFloat = 0f)
    public void setShadowOpacity(DrawableView view, float v){
        view.getDrawable().setShadowOpacity(v);
        view.getDrawable().invalidateSelf();
    }
    @ReactProp(name = "shadowRadius",defaultFloat = 1f)
    public void setShadowRadius(DrawableView view ,float v){
        view.getDrawable().setShadowRadius(toDip(v,view));
        view.getDrawable().invalidateSelf();
    }
    @ReactProp(name = "strokeWidth",defaultFloat = 0f)
    public void setStrokeWidth(DrawableView view ,float v){
        view.getDrawable().setStrokeWidth(toDip(v,view));
        view.getDrawable().invalidateSelf();
    }
    @ReactProp(name = "stroke",defaultInt = Color.BLACK)
    public void setStroke(DrawableView view ,int v){
        view.getDrawable().setStrokeColor(v);
        view.getDrawable().invalidateSelf();
    }
    @ReactProp(name = "strokeStart",defaultFloat = 0f)
    public void setStrokeStart(DrawableView view ,float v){
        view.getDrawable().setStrokeStart(v);
        view.getDrawable().invalidateSelf();
    }
    @ReactProp(name = "strokeEnd",defaultFloat = 1f)
    public void setStrokeEnd(DrawableView view ,float v){
        view.getDrawable().setStrokeEnd(v);
        view.getDrawable().invalidateSelf();
    }
    @ReactProp(name = "strokeCap")
    public void setStrokeCap(DrawableView view ,String v){

        Paint.Cap cap = "round".equals(v) ? Paint.Cap.ROUND
                : ("square".equals(v) ? Paint.Cap.SQUARE : Paint.Cap.BUTT );

        view.getDrawable().setStrokeCap(cap);
        view.getDrawable().invalidateSelf();
    }
    @ReactProp(name = "strokeJoin")
    public void setStrokeJoin(DrawableView view,String v){
        Paint.Join join = "round".equals(v) ? Paint.Join.ROUND
                : ("bevel".equals(v) ? Paint.Join.BEVEL : Paint.Join.MITER );
        view.getDrawable().setStrokeJoin(join);
        view.getDrawable().invalidateSelf();
    }
    @ReactProp(name = "strokeMiter",defaultFloat = 4f)
    public void setStrokeMiter(DrawableView view ,float v){
        view.getDrawable().setStrokeMiter(v);
        view.getDrawable().invalidateSelf();
    }
    @ReactProp(name = "pathInset")
    public void setPathInset(DrawableView view,ReadableMap v){
        float x = (float) ModUtil.getDouble(v,"x",0.0);
        float y = (float) ModUtil.getDouble(v,"y",0.0);
        view.getDrawable().setInset(toDip(x,view),toDip(y,view));
        view.getDrawable().invalidateSelf();
    }
    @ReactProp(name = "fill", defaultInt = Color.TRANSPARENT)
    public void setFill(DrawableView view ,int v){
        view.getDrawable().setFillColor(v);
        view.getDrawable().invalidateSelf();
    }
    @ReactProp(name = "bgColor",defaultInt = Color.TRANSPARENT)
    public void setBgColor(DrawableView view,int v){
        view.getDrawable().setBackgroundColor(v);
        view.getDrawable().invalidateSelf();
    }

    private float toDip(float num, DrawableView view){
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,num,view.getResources().getDisplayMetrics());
    }
}