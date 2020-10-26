package net.appthos.sdui

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.appthos.sdui.data.ComponentData.Companion.VIEW_TYPE_FOOTER
import net.appthos.sdui.data.ComponentData.Companion.VIEW_TYPE_GALLERY_GROUP
import net.appthos.sdui.data.ComponentData.Companion.VIEW_TYPE_PARTNER
import net.appthos.sdui.data.ComponentData.Companion.VIEW_TYPE_TITLE
import net.appthos.sdui.extensions.dpToPx

class ComponentItemDecorator(private val context: Context) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        if (null != parent.adapter) {
            val itemCount = parent.adapter!!.itemCount
            if (itemCount > 0) {
                val currentPosition = parent.getChildAdapterPosition(view)

                var spanCount = 0           // layoutManager에 셋팅된 spanManager
                var itemSpanSize = 0        // 현재아이템의 spanSize
                var itemSpanRowIndex = 0    // 현재아이템의 rowIndex(e.g. spanCount=2, spanSize=1 인 경우 0, 1 가능)
                var spanGroupCount = 0      // 전체 row 수
                var spanGroupPosition = 0   // 현재아이템(==view) row position

                val currentItemType = parent.adapter!!.getItemViewType(currentPosition)
                var nextSpanGroupItemType = -1  // 다음 row의 itemType

                parent.layoutManager?.let {
                    if (it is GridLayoutManager) {
                        spanCount = it.spanCount
                        itemSpanSize = it.spanSizeLookup.getSpanSize(currentPosition)
                        itemSpanRowIndex = it.spanSizeLookup.getSpanIndex(currentPosition, spanCount)
                        spanGroupCount = it.spanSizeLookup.getSpanGroupIndex(itemCount - 1, spanCount)
                        spanGroupPosition = it.spanSizeLookup.getSpanGroupIndex(currentPosition, spanCount)


                        for (nextPosition in currentPosition until itemCount - 1) {
                            val nextSpanGroupIndex =
                                it.spanSizeLookup.getSpanGroupIndex(nextPosition, spanCount)
                            if (spanGroupPosition < nextSpanGroupIndex) {
                                nextSpanGroupItemType = parent.adapter!!.getItemViewType(nextPosition)
                                break
                            }
                        }
                    }
                }

                // vertical margins

                // top margin
                if (spanGroupPosition == 0) {
                    outRect.top = context.dpToPx(30F).toInt()
                }

                // bottom margin
                if (spanGroupPosition == spanGroupCount) {
                    if (currentItemType == VIEW_TYPE_FOOTER) {
                        outRect.bottom = 0
                    } else {
                        outRect.bottom = context.dpToPx(60F).toInt()
                    }
                } else if (currentItemType == VIEW_TYPE_TITLE && nextSpanGroupItemType == VIEW_TYPE_PARTNER) {
                    outRect.bottom = context.dpToPx(10F).toInt()
                } else if (currentItemType == VIEW_TYPE_TITLE && nextSpanGroupItemType == VIEW_TYPE_GALLERY_GROUP) {
                    outRect.bottom = context.dpToPx(5F).toInt()
                } else {
                    outRect.bottom = context.dpToPx(20F).toInt()
                }
            }
        }
    }
}