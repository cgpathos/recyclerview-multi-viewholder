package net.appthos.sdui.data

import androidx.recyclerview.widget.DiffUtil
import net.appthos.sdui.data.ComponentData.Companion.VIEW_TYPE_GALLERY
import net.appthos.sdui.data.ComponentData.Companion.VIEW_TYPE_GALLERY_GROUP
import net.appthos.sdui.data.ComponentData.Companion.VIEW_TYPE_PARTNER
import net.appthos.sdui.data.ComponentData.Companion.VIEW_TYPE_TITLE

interface ComponentData {
    val id: Int
    val groupId: Int
    val viewType: Int

    override fun equals(other: Any?): Boolean

    companion object {
        const val VIEW_TYPE_TITLE = 0
        const val VIEW_TYPE_GALLERY = 1
        const val VIEW_TYPE_GALLERY_GROUP = 2
        const val VIEW_TYPE_PARTNER = 3

        fun diffItemCallback() = object : DiffUtil.ItemCallback<ComponentData>() {
            override fun areItemsTheSame(oldItem: ComponentData, newItem: ComponentData): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ComponentData, newItem: ComponentData): Boolean {
                return oldItem == newItem
            }
        }
    }
}

data class TitleData(
    override val id: Int, override val groupId: Int,
    val title: String
) : ComponentData {
    override val viewType: Int = VIEW_TYPE_TITLE
}

data class PartnerData(
    override val id: Int, override val groupId: Int,
    val name: String,
    val coverImgUrl: String
) : ComponentData {
    override val viewType: Int = VIEW_TYPE_PARTNER
}

data class GalleryData(
    override val id: Int, override val groupId: Int,
    val imgUrl: String
) : ComponentData {
    override val viewType: Int = VIEW_TYPE_GALLERY
}

data class GalleryGroupData(
    override val id: Int, override val groupId: Int,
    val galleryList: List<GalleryData>
) : ComponentData {
    override val viewType: Int = VIEW_TYPE_GALLERY_GROUP
}