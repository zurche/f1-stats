package com.zurche.f1stats

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.tyre_compound_view.view.*

class TyreCompoundView(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    private var compoundType: Int? = SOFT_COMPOUND

    companion object {
        private const val SOFT_COMPOUND = 0
        private const val MEDIUM_COMPOUND = 1
        private const val HARD_COMPOUND = 2
    }

    init {
        inflate(context, R.layout.tyre_compound_view, this)
        val typedArray = context.theme?.obtainStyledAttributes(
            attrs,
            R.styleable.TyreCompoundView,
            0, 0
        )

        try {
            compoundType =
                typedArray?.getInteger(R.styleable.TyreCompoundView_compound, SOFT_COMPOUND)
        } finally {
            typedArray?.recycle()
        }

        when (compoundType) {
            SOFT_COMPOUND -> setSoftView()
            MEDIUM_COMPOUND -> setMediumView()
            HARD_COMPOUND -> setHardView()
        }
    }

    /**
     * Update the view to display a Soft Compound Tyre.
     */
    fun setSoftView() {
        tyre_compound_text_view.text = context.getString(R.string.soft_compound_tyre)
        compound_color_view.setBackgroundResource(R.drawable.soft_tyre_compound_background)
    }

    /**
     * Update the view to display a Medium Compound Tyre.
     */
    fun setMediumView() {
        tyre_compound_text_view.text = context.getString(R.string.medium_compound_tyre)
        compound_color_view.setBackgroundResource(R.drawable.medium_tyre_compound_background)
    }

    /**
     * Update the view to display a Hard Compound Tyre.
     */
    fun setHardView() {
        tyre_compound_text_view.text = context.getString(R.string.hard_compound_tyre)
        compound_color_view.setBackgroundResource(R.drawable.hard_tyre_compound_background)
    }
}