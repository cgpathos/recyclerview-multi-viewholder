package net.appthos.sdui.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import net.appthos.sdui.R
import net.appthos.sdui.data.ComponentData
import net.appthos.sdui.data.GalleryGroupData
import net.appthos.sdui.data.PartnerData
import net.appthos.sdui.data.TitleData
import net.appthos.sdui.databinding.ItemComponentGalleryBinding
import net.appthos.sdui.databinding.ItemComponentPartnerBinding
import net.appthos.sdui.databinding.ItemComponentTitleBinding

sealed class BaseViewHolder(
    @LayoutRes layoutId: Int, inflater: LayoutInflater, parent: ViewGroup
) : RecyclerView.ViewHolder(inflater.inflate(layoutId, parent, false)) {

    abstract fun bind(data: ComponentData)
}

class TitleViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    BaseViewHolder(R.layout.item_component_title, inflater, parent) {
    private val bnd: ItemComponentTitleBinding = ItemComponentTitleBinding.bind(itemView)

    override fun bind(data: ComponentData) {
        if (data is TitleData) {
            bnd.txtTitle.text = data.title
        }
    }
}

class GalleryViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    BaseViewHolder(R.layout.item_component_gallery, inflater, parent) {
    private val bnd: ItemComponentGalleryBinding = ItemComponentGalleryBinding.bind(itemView)

    override fun bind(data: ComponentData) {
        if (data is GalleryGroupData) {

        }
    }
}

class PartnerViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    BaseViewHolder(R.layout.item_component_partner, inflater, parent) {
    private val bnd: ItemComponentPartnerBinding = ItemComponentPartnerBinding.bind(itemView)

    override fun bind(data: ComponentData) {
        if (data is PartnerData) {
            bnd.txtPartnerName.text = data.name
        }
    }
}

class NoneViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    BaseViewHolder(R.layout.item_none, inflater, parent) {

    override fun bind(data: ComponentData) {

    }
}
