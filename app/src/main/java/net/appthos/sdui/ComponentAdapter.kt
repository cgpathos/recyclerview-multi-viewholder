package net.appthos.sdui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.NO_POSITION
import net.appthos.sdui.data.ComponentData
import net.appthos.sdui.data.GalleryData
import net.appthos.sdui.data.PartnerData
import net.appthos.sdui.data.TitleData
import net.appthos.sdui.viewholder.*

class ComponentAdapter :
    ListAdapter<ComponentData, BaseViewHolder>(ComponentData.diffItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            0 -> TitleViewHolder(inflater, parent)
            1 -> GalleryViewHolder(inflater, parent)
            2 -> PartnerViewHolder(inflater, parent)
            else -> NoneViewHolder(inflater, parent)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return when (currentList[position]) {
            is TitleData -> 0
            is GalleryData -> 1
            is PartnerData -> 2
            else -> NO_POSITION
        }
    }
}
