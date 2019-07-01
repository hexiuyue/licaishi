package com.guoshi.baselib.view

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.TextView

import com.github.mikephil.charting.charts.Chart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.utils.MPPointF
import com.guoshi.baselib.R
import java.text.DecimalFormat

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/4
 * 文件描述：图标点击显示view
 */
class LineChartMarkView(context: Context, private val xAxisValueFormatter: IAxisValueFormatter) :
    MarkerView(context, R.layout.layout_markview) {

    private val tvDate: TextView
    private val tvValue0: TextView
    private val tvValue1: TextView
    internal var df = DecimalFormat("0.00")

    init {
        tvDate = findViewById<View>(R.id.tv_date) as TextView
        tvValue0 = findViewById<View>(R.id.tv_value0) as TextView
        tvValue1 = findViewById<View>(R.id.tv_value1) as TextView
    }

    @SuppressLint("SetTextI18n")
    override fun refreshContent(e: Entry, highlight: Highlight) {
        val chart = chartView
        if (chart is LineChart) {
            val lineData = chart.lineData
            //获取到图表中的所有曲线
            val dataSetList = lineData.dataSets
            for (i in dataSetList.indices) {
                val dataSet = dataSetList[i] as LineDataSet
                //获取到曲线的所有在Y轴的数据集合，根据当前X轴的位置 来获取对应的Y轴值
                val y = dataSet.values[e.x.toInt()].y
                if (i == 0) {
                    tvValue0.text = dataSet.label + "：" + y
                }
                if (i == 1) {
                    tvValue1.text = dataSet.label + "：" + y
                }
            }
            tvDate.text = xAxisValueFormatter.getFormattedValue(e.x, null)
        }
        super.refreshContent(e, highlight)
    }

    override fun getOffset(): MPPointF {
        return MPPointF((-(width / 2)).toFloat(), (-height).toFloat())
    }
}
