package net.appthos.sdui

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class HorizontalSpaceDecoration(
    private val start: Int,
    private val end: Int,
    private val space: Int,
    private val isReverse: Boolean = false
) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        if(null != parent.adapter) {
            if (parent.getChildAdapterPosition(view) == 0) {
                if (isReverse) {
                    outRect.left = space
                    outRect.right = end
                } else {
                    outRect.left = start
                }
            } else if (parent.getChildAdapterPosition(view) == parent.adapter!!.itemCount - 1) {
                if (isReverse) {
                } else {
                    outRect.left = space
                    outRect.right = end
                }
            } else {
                outRect.left = space
            }
        }
    }
}