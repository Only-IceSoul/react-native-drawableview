package com.jjkit.drawableview

import android.content.Context
import android.graphics.Color
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

    @ReactProp(name = "attrs")
    fun setAttrs(view: DrawableView, props:ReadableMap?)  {

        props?.let {
            val rtl = try { props.getDouble("borderRadiusTopLeft") }catch(e: Exception) {  0.0 }.toFloat()  //
            val rtr = try { props.getDouble("borderRadiusTopRight") }catch(e: Exception) {  0.0 }.toFloat() //
            val rbl = try { props.getDouble("borderRadiusBottomLeft") }catch(e: Exception) {  0.0 }.toFloat() //
            val rbr = try { props.getDouble("borderRadiusBottomRight") }catch(e: Exception) {  0.0 }.toFloat() //

            val path = try { props.getString("path") }catch(e: Exception) {  null } //
            val pathVb:FloatArray = try {
                if(props.hasKey("pathViewBox")){
                    val ra  = props.getArray("pathViewBox")

                    val x = try { ra!!.getDouble(0) } catch (e:Exception) { 0 }.toFloat()
                    val y = try { ra!!.getDouble(1) } catch (e:Exception) { 0 }.toFloat()
                    val w = try { ra!!.getDouble(2) } catch (e:Exception) { 0 }.toFloat()
                    val h = try { ra!!.getDouble(3) } catch (e:Exception) { 0 }.toFloat()

                    floatArrayOf(x,y,w,h)
                }else{
                    floatArrayOf(0f,0f,0f,0f)
                }

            }catch(e: Exception) {  floatArrayOf(0f,0f,0f,0f) }
            val pathAspect = try { props.getInt("pathViewBoxAspect") }catch(e: Exception) {  0 } //
            val pathAlign = try { props.getString("pathViewBoxAlign")!! }catch(e: Exception) {  "xMidYMid" } //
            val pathScaleX = try { props.getDouble("pathScaleX") }catch(e: Exception) {  1 }.toFloat() //
            val pathScaleY = try { props.getDouble("pathScaleY") }catch(e: Exception) {  1 }.toFloat() //
            val pathRotation = try { props.getDouble("pathRotation") }catch(e: Exception) {  0 }.toFloat() //
            val pathTx = try { props.getDouble("pathTranslationX") }catch(e: Exception) {  0 }.toFloat() //
            val pathTy = try { props.getDouble("pathTranslationY") }catch(e: Exception) {  0 }.toFloat() //
            val pathIsTransPerValue = try { props.getBoolean("pathTranslationIsPercent") }catch(e: Exception) { false } //

            val shadowOpacity = try { props.getDouble("shadowOpacity") }catch(e: Exception) {  0 }.toFloat() //
            val shadowRadius = try { props.getDouble("shadowRadius") }catch(e: Exception) {  1 }.toFloat() //
            val shadowOffsetX = try { props.getDouble("shadowOffsetX") }catch(e: Exception) {  0 }.toFloat() //
            val shadowOffsetY = try { props.getDouble("shadowOffsetY") }catch(e: Exception) {  0 }.toFloat() //
            val shadowColor = try { props.getInt("shadowColor") }catch(e: Exception) {  Color.BLACK } //

            val strokeWidth = try { props.getDouble("strokeWidth") }catch(e: Exception) {   0 }.toFloat() //
            val strokeColor = try { props.getInt("strokeColor") }catch(e: Exception) {   Color.BLACK } //
            val strokeStart = try { props.getDouble("strokeStart") }catch(e: Exception) {   0 }.toFloat() //
            val strokeEnd = try { props.getDouble("strokeEnd") }catch(e: Exception) { 0 }.toFloat() //

            val fillColor = try { props.getInt("fillColor") }catch(e: Exception) {   Color.TRANSPARENT } //
            val bg = try { props.getInt("backgroundColor") }catch(e: Exception) {   Color.TRANSPARENT } //


            val mDrawable = view.getDrawable()

            if(path != null){
                mDrawable.setShape(JJDrawable.SVG_PATH)
                        .setSvgPath(path,view.resources.displayMetrics.density,pathVb,pathAlign,pathAspect)
            }else{
                mDrawable.setShape(JJDrawable.NONE)
            }

            mDrawable.setRadius(toDip(rtl,view),toDip(rtr,view),toDip(rbl,view),toDip(rbr,view))

                    .setPathScale(pathScaleX,pathScaleY)
                    .setPathRotation(pathRotation)

            if(pathIsTransPerValue){
                mDrawable.setPathTranslation(pathTx,pathTy,0f,0f)
            }else{
                mDrawable.setPathTranslation(toDip(pathTx,view),toDip(pathTy,view))
            }

            mDrawable.setShadowRadius(toDip(shadowRadius,view))
                    .setShadowOffset(toDip(shadowOffsetX,view),toDip(shadowOffsetY,view))
                    .setShadowOpacity(shadowOpacity)
                    .setShadowColor(shadowColor)
                    .setStrokeWidth(toDip(strokeWidth,view))
                    .setStrokeColor(strokeColor)
                    .setFillColor(fillColor)
                    .setBackgroundColor(bg)
                    .setStrokeStart(strokeStart)
                    .setStrokeEnd(strokeEnd)




            mDrawable.invalidateSelf()
        }
      




    }


    private fun toDip(num:Float, view: DrawableView): Float{
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,num,view.resources.displayMetrics)
    }
}