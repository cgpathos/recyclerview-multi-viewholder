package net.appthos.sdui.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.appthos.sdui.ComponentAdapter
import net.appthos.sdui.HorizontalSpaceDecoration
import net.appthos.sdui.R
import net.appthos.sdui.data.*
import net.appthos.sdui.databinding.ItemComponentGalleryBinding
import net.appthos.sdui.databinding.ItemComponentGalleryGroupBinding
import net.appthos.sdui.databinding.ItemComponentPartnerBinding
import net.appthos.sdui.databinding.ItemComponentTitleBinding
import net.appthos.sdui.extensions.dpToPx

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
        if (data is GalleryData) {

        }
    }
}

class GalleryGroupViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    BaseViewHolder(R.layout.item_component_gallery_group, inflater, parent) {
    private val bnd: ItemComponentGalleryGroupBinding = ItemComponentGalleryGroupBinding.bind(itemView)

    init {
        bnd.listGallery.apply {
            layoutManager = LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL, false)
            isNestedScrollingEnabled = false
        }.addItemDecoration(
            HorizontalSpaceDecoration(
                start = itemView.context.dpToPx(16F).toInt(),
                end = itemView.context.dpToPx(16F).toInt(),
                space = itemView.context.dpToPx(10F).toInt()
            )
        )
    }

    override fun bind(data: ComponentData) {
        if (data is GalleryGroupData) {
            bnd.listGallery.adapter = ComponentAdapter(data.galleryList)
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

class FooterViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    BaseViewHolder(R.layout.item_component_footer, inflater, parent) {

    override fun bind(data: ComponentData) {

    }
}

class NoneViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    BaseViewHolder(R.layout.item_none, inflater, parent) {

    override fun bind(data: ComponentData) {

    }
}
