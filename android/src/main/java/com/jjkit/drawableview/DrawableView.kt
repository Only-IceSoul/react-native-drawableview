package com.jjkit.drawableview

import android.annotation.SuppressLint
import android.content.Context
import android.view.ViewGroup
import com.jjlf.jjkit_utils.JJOutlineProvider
import com.jjlf.jjkit_utils.drawables.JJColorDrawable



class DrawableView(context: Context): ViewGroup(context) {

    private val mShadow = JJOutlineProvider()
    private val mBg = JJColorDrawable()
    init{

        outlineProvider = mShadow
        background = mBg
        clipChildren = false
    }
    @SuppressLint("RtlHardcoded")
    fun setOptions(radius: FloatArray,
                    shadowOpacity:Float,
                    soX:Float,soY:Float,
                    shadowColor:Int,
                    fillColor:Int,
                    strokeW:Float,strokeC:Int,
                    path:String?,
                    poX:Float,poY:Float,
                    vbMinX:Float,vbMinY:Float,
                    vbWidth:Float,vbHeight:Float,
                    vbAlign:String,vbMeetOrSlice:Int,
                    scale:Float,
                    shadowScale:Float,
                    ele:Float) {


        val density = resources.displayMetrics.density
        if(path != null && vbWidth > 0f && vbHeight > 0f){
             mShadow.setSvgPath(path, floatArrayOf(vbMinX,vbMinY,vbWidth,vbHeight),vbMeetOrSlice,vbAlign,density)
             mBg.setSvgPath(path, floatArrayOf(vbMinX,vbMinY,vbWidth,vbHeight),vbMeetOrSlice,vbAlign,density)
        }else{
            mShadow.setRadius(radius[0],radius[1],radius[2],radius[3])
            mBg.setRadius(radius[0],radius[1],radius[2],radius[3])
        }

        if(android.os.Build.VERSION.SDK_INT >= 28){
            outlineSpotShadowColor = shadowColor
            outlineAmbientShadowColor = shadowColor
        }

        mShadow.setAlpha(shadowOpacity)
                .setOffset(poX,poY,soX,soY)
                .setScale(shadowScale,shadowScale)

        mBg.setFillColor(fillColor)
                .setStroke(strokeW,strokeC)
                .setOffset(poX,poY,true)
                .setScale(scale,scale)


        elevation = ele

        invalidateOutline()
        invalidate()

    }



    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {

    }

}