package com.example.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import java.util.*

class display : View {
    private var params: ViewGroup.LayoutParams? = null

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        MainActivity.paint_brush.isAntiAlias = true
        MainActivity.paint_brush.color = Color.BLACK
        MainActivity.paint_brush.style = Paint.Style.STROKE
        MainActivity.paint_brush.strokeCap = Paint.Cap.ROUND
        MainActivity.paint_brush.strokeJoin = Paint.Join.ROUND
        MainActivity.paint_brush.strokeWidth = 20f
        params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x
        val y = event.y
        return when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                MainActivity.path.moveTo(x, y)
                invalidate()
                MainActivity.path.lineTo(x, y)
                pathList.add(MainActivity.path)
                colorList.add(current_brush)
                invalidate()
                true
            }
            MotionEvent.ACTION_MOVE -> {
                MainActivity.path.lineTo(x, y)
                pathList.add(MainActivity.path)
                colorList.add(current_brush)
                invalidate()
                true
            }
            else -> false
        }
    }

    override fun onDraw(canvas: Canvas) {
        for (i in pathList.indices) {
            MainActivity.paint_brush.color = colorList.get(i)
            canvas.drawPath(pathList.get(i), MainActivity.paint_brush)
            invalidate()
        }
    }

    companion object {
        var pathList = ArrayList<Path>()
        var colorList = ArrayList<Int>()
        var current_brush = Color.BLACK
    }
}