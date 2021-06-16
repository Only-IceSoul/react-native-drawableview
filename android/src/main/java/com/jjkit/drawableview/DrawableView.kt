package com.jjkit.drawableview

import android.annotation.SuppressLint
import android.content.Context
import android.view.ViewGroup
import com.jjlf.jjkit_utils.JJOutlineProvider
import com.jjlf.jjkit_utils.drawables.JJColorDrawable
import com.jjlf.jjkit_utils.drawables.JJDrawable


class DrawableView(context: Context): ViewGroup(context) {


    private val mDrawable = JJDrawable()
    init{
        background = mDrawable
        clipChildren = false
        mDrawable.setShape(JJDrawable.SVG_PATH)
    }

    fun getDrawable(): JJDrawable{
        return mDrawable
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {

    }

}