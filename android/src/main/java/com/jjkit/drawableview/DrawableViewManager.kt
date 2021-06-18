package com.jjkit.drawableview

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.util.TypedValue
import android.view.View
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.uimanager.*
import com.jjlf.jjkit_utils.drawables.JJDrawable


class DrawableViewManager : ViewGroupManager<DrawableView>() {

    override fun getName(): String {
        return "Drawable"
    }

    override fun createViewInstance(reactContext: ThemedReactContext): DrawableView {
        val v = DrawableView(reactContext as Context)
        v.setLayerType(View.LAYER_TYPE_SOFTWARE,null)
        return v
    }

    @ReactProp(name = "path")
    fun setPath(view: DrawableView, p:ReadableMap?){


        val d = try { p!!.getString("d")!! }catch(e: Exception) { "" }
        val viewBox = try { p!!.getArray("viewBox") }catch(e: Exception) { null }
        val aspect = try { p!!.getString("aspect")!! }catch(e: Exception) { "none" }
        val align = try { p!!.getString("align")!! }catch(e: Exception) { "none" }

        val a  = when(aspect) {
            "meet" ->  JJDrawable.VIEW_BOX_MEET
            "slice" -> JJDrawable.VIEW_BOX_SLICE
            else -> JJDrawable.VIEW_BOX_NONE
        }

        val v = floatArrayOf(0f,0f,0f,0f)
        viewBox?.let {
            v[0] = it.getDouble(0).toFloat()
            v[1] = it.getDouble(1).toFloat()
            v[2] = it.getDouble(2).toFloat()
            v[3] = it.getDouble(3).toFloat()
        }
        val mDrawable = view.getDrawable()
        mDrawable.setSvgPath(d,view.resources.displayMetrics.density, v,align,a)
        mDrawable.invalidateSelf()


    }
    @ReactProp(name = "pathRotation",defaultFloat = 0f)
    fun setPathRotation(view: DrawableView, r:Float){
        val mDrawable = view.getDrawable()
        mDrawable.setPathRotation(r)
        mDrawable.invalidateSelf()
    }
    @ReactProp(name = "pathScale")
    fun setPathScale(view: DrawableView, v:ReadableMap?){
        val mDrawable = view.getDrawable()
        val x = try { v!!.getDouble("x") }catch(e: Exception) { 1.0 }.toFloat()
        val y = try { v!!.getDouble("y") }catch(e: Exception) { 1.0 }.toFloat()
        mDrawable.setPathScale(x,y)
        mDrawable.invalidateSelf()
    }
    @ReactProp(name = "pathTranslation")
    fun setPathTranslation(view: DrawableView, v:ReadableMap?){
        val dx = try { v!!.getDouble("dx") }catch(e: Exception) { 0.0 }.toFloat()
        val dy = try { v!!.getDouble("dy") }catch(e: Exception) { 0.0 }.toFloat()
        val per = try { v!!.getBoolean("percentageValue") }catch(e: Exception) { false }
        val mDrawable = view.getDrawable()
        if(per){
            mDrawable.setPathTranslation(dx,dy,0f,0f)
        }else{
            mDrawable.setPathTranslation(toDip(dx,view),toDip(dy,view))
        }
        mDrawable.invalidateSelf()
    }

    @ReactProp(name = "shadowColor",defaultInt = Color.BLACK)
    override fun setShadowColor(view: DrawableView, v:Int){
        val mDrawable = view.getDrawable()
        mDrawable.setShadowColor(v)
        mDrawable.invalidateSelf()
    }
    @ReactProp(name = "shadowOffset")
    fun setShadowOffset(view: DrawableView, v:ReadableMap?){
        val x = try { v!!.getDouble("x") }catch(e: Exception) { 0.0 }.toFloat()
        val y = try { v!!.getDouble("y") }catch(e: Exception) { 0.0 }.toFloat()
        val mDrawable = view.getDrawable()
        mDrawable.setShadowOffset(toDip(x,view),toDip(y,view))
        mDrawable.invalidateSelf()
    }
    @ReactProp(name = "shadowOpacity",defaultFloat = 0f)
    fun setShadowOpacity(view: DrawableView,v:Float){
        val mDrawable = view.getDrawable()
        mDrawable.setShadowOpacity(v)
        mDrawable.invalidateSelf()
    }
    @ReactProp(name = "shadowRadius",defaultFloat = 1f)
    fun setShadowRadius(view: DrawableView,v:Float){
        val mDrawable = view.getDrawable()
        mDrawable.setShadowRadius(toDip(v,view))
        mDrawable.invalidateSelf()
    }
    @ReactProp(name = "strokeWidth",defaultFloat = 0f)
    fun setStrokeWidth(view: DrawableView,v:Float){
        val mDrawable = view.getDrawable()
        mDrawable.setStrokeWidth(toDip(v,view))
        mDrawable.invalidateSelf()
    }
    @ReactProp(name = "strokeColor",defaultInt = Color.BLACK)
    fun setStrokeColor(view: DrawableView,v:Int){
        val mDrawable = view.getDrawable()
        mDrawable.setStrokeColor(v)
        mDrawable.invalidateSelf()
    }
    @ReactProp(name = "strokeStart",defaultFloat = 0f)
    fun setStrokeStart(view: DrawableView,v:Float){
        val mDrawable = view.getDrawable()
        mDrawable.setStrokeStart(v)
        mDrawable.invalidateSelf()
    }
    @ReactProp(name = "strokeEnd",defaultFloat = 1f)
    fun setStrokeEnd(view: DrawableView,v:Float){
        val mDrawable = view.getDrawable()
        mDrawable.setStrokeEnd(v)
        mDrawable.invalidateSelf()
    }
     @ReactProp(name = "strokeCap")
    fun setStrokeCap(view: DrawableView,v:String?){
        val mDrawable = view.getDrawable()
        val cap = when(v ?: "butt"){
                "round" -> Paint.Cap.ROUND
                "square" -> Paint.Cap.SQUARE
                 else -> Paint.Cap.BUTT
        }
        mDrawable.setStrokeCap(cap)
        mDrawable.invalidateSelf()
    }
    @ReactProp(name = "strokeJoin")
    fun setStrokeJoin(view: DrawableView,v:String?){
        val mDrawable = view.getDrawable()
        val join = when(v ?: "miter"){
            "round" -> Paint.Join.ROUND
            "bevel" -> Paint.Join.BEVEL
            else -> Paint.Join.MITER
        }
        mDrawable.setStrokeJoin(join)
        mDrawable.invalidateSelf()
    }
    @ReactProp(name = "strokeMiter",defaultFloat = 4f)
    fun setStrokeMiter(view: DrawableView,v:Float){
        val mDrawable = view.getDrawable()
        mDrawable.setStrokeMiter(v)
        mDrawable.invalidateSelf()
    }
    @ReactProp(name = "pathInset")
    fun setPathInset(view: DrawableView,v:ReadableMap?){
        val mDrawable = view.getDrawable()
        val x = try { v!!.getDouble("x") }catch(e: Exception) { 0.0 }.toFloat()
        val y = try { v!!.getDouble("y") }catch(e: Exception) { 0.0 }.toFloat()
        mDrawable.setInset(x,y)
        mDrawable.invalidateSelf()
    }
    @ReactProp(name = "fillColor", defaultInt = Color.TRANSPARENT)
    fun setFillColor(view: DrawableView,v:Int){
        val mDrawable = view.getDrawable()
        mDrawable.setFillColor(v)
        mDrawable.invalidateSelf()
    }
    @ReactProp(name = "bgColor",defaultInt = Color.TRANSPARENT)
    fun setBgColor(view: DrawableView,v:Int){
        val mDrawable = view.getDrawable()
        mDrawable.setBackgroundColor(v)
        mDrawable.invalidateSelf()
    }


    private fun toDip(num:Float, view: DrawableView): Float{
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,num,view.resources.displayMetrics)
    }
}