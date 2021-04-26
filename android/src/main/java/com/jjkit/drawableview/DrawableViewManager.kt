package com.jjkit.drawableview

import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.uimanager.*


class DrawableViewManager : ViewGroupManager<DrawableView>() {

    override fun getName(): String {
        return "JJDrawableView"
    }

    override fun createViewInstance(reactContext: ThemedReactContext): DrawableView {
        return  DrawableView(reactContext as Context)
    }

    @ReactProp(name = "nativeProps")
    fun setNativeProps(view: DrawableView, nativeProps:ReadableMap?)  {

        val rtl = try { nativeProps!!.getDouble("radiusTopLeft") }catch(e: Exception) {  0.0 }.toFloat()  //
        val rtr = try { nativeProps!!.getDouble("radiusTopRight") }catch(e: Exception) {  0.0 }.toFloat() //
        val rbl = try { nativeProps!!.getDouble("radiusBottomLeft") }catch(e: Exception) {  0.0 }.toFloat() //
        val rbr = try { nativeProps!!.getDouble("radiusBottomRight") }catch(e: Exception) {  0.0 }.toFloat() //


        val elevation = try { nativeProps!!.getDouble("elevation") }catch(e: Exception) {  0 }.toFloat() //

        val path = try { nativeProps!!.getString("path") }catch(e: Exception) {  null } //
        val vbMinX = try { nativeProps!!.getDouble("vbMinX") }catch(e: Exception) {  0 }.toFloat() //
        val vbMinY = try { nativeProps!!.getDouble("vbMinY") }catch(e: Exception) {  0 }.toFloat() //
        val vbWidth = try { nativeProps!!.getDouble("vbWidth") }catch(e: Exception) {  0 }.toFloat() //
        val vbHeight = try { nativeProps!!.getDouble("vbHeight") }catch(e: Exception) {  0 }.toFloat() //
        val vbAlign = try { nativeProps!!.getString("vbAlign")!! }catch(e: Exception) {  "xMidYMid" } //
        val vbMeetOrSlice = try { nativeProps!!.getInt("vbMeetOrSlice") }catch(e: Exception) {  0 } //

        val pathOffsetX = try { nativeProps!!.getDouble("pathOffsetX") }catch(e: Exception) {  0 }.toFloat() //
        val pathOffsetY = try { nativeProps!!.getDouble("pathOffsetY") }catch(e: Exception) {  0 }.toFloat() //

        val shadowColor = try { nativeProps!!.getInt("shadowColor") }catch(e: Exception) {  Color.BLACK } //
        val shadowOpacity = try { nativeProps!!.getDouble("shadowOpacity") }catch(e: Exception) {  1 }.toFloat() //
        val shadowOffsetX = try { nativeProps!!.getDouble("shadowOffsetX") }catch(e: Exception) {  0 }.toFloat() //
        val shadowOffsetY = try { nativeProps!!.getDouble("shadowOffsetY") }catch(e: Exception) {  0 }.toFloat() //

        val fillColor = try { nativeProps!!.getInt("fillColor") }catch(e: Exception) {   Color.TRANSPARENT } //
        val strokeColor = try { nativeProps!!.getInt("strokeColor") }catch(e: Exception) {   Color.BLACK } //
        val strokeWidth = try { nativeProps!!.getDouble("strokeWidth") }catch(e: Exception) {   0 }.toFloat() //

        val scale = try { nativeProps!!.getDouble("scale") }catch(e: Exception) {  1 }.toFloat() //
        val shadowScale = try { nativeProps!!.getDouble("shadowScale") }catch(e: Exception) {  1 }.toFloat() //

        val arr = floatArrayOf(rtl,rtr,rbr,rbl)

        view.setOptions(arr,shadowOpacity,toDip(shadowOffsetX,view),toDip(shadowOffsetY,view),shadowColor,fillColor,
         toDip(strokeWidth,view),strokeColor,path,pathOffsetX,pathOffsetY,vbMinX,vbMinY,vbWidth,vbHeight,vbAlign,vbMeetOrSlice,scale,shadowScale,toDip(elevation,view))

    }


    private fun toDip(num:Float, view: DrawableView): Float{
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,num,view.resources.displayMetrics)
    }
}