package net.appthos.sdui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import net.appthos.sdui.data.ComponentData
import net.appthos.sdui.data.ComponentData.Companion.VIEW_TYPE_FOOTER
import net.appthos.sdui.data.ComponentData.Companion.VIEW_TYPE_GALLERY
import net.appthos.sdui.data.ComponentData.Companion.VIEW_TYPE_GALLERY_GROUP
import net.appthos.sdui.data.ComponentData.Companion.VIEW_TYPE_PARTNER
import net.appthos.sdui.data.ComponentData.Companion.VIEW_TYPE_TITLE
import net.appthos.sdui.viewholder.*

class ComponentAdapter() :
    ListAdapter<ComponentData, BaseViewHolder>(ComponentData.diffItemCallback()) {

    constructor(dataList: List<ComponentData>) : this() {
        submitList(dataList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_TITLE -> TitleViewHolder(inflater, parent)
            VIEW_TYPE_GALLERY -> GalleryViewHolder(inflater, parent)
            VIEW_TYPE_GALLERY_GROUP -> GalleryGroupViewHolder(inflater, parent)
            VIEW_TYPE_PARTNER -> PartnerViewHolder(inflater, parent)
            VIEW_TYPE_FOOTER -> FooterViewHolder(inflater, parent)
            else -> NoneViewHolder(inflater, parent)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return currentList[position].viewType
    }
}
