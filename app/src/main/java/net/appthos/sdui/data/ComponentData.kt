package net.appthos.sdui.data

import androidx.recyclerview.widget.DiffUtil

interface ComponentData {
    val id: Int
    val groupId: Int

    override fun equals(other: Any?): Boolean

    companion object {
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
) : ComponentData

data class PartnerData(
    override val id: Int, override val groupId: Int,
    val name: String,
    val coverImgUrl: String
) : ComponentData

data class GalleryData(
    override val id: Int, override val groupId: Int,
    val imgUrl: String
) : ComponentData

data class GalleryGroupData(
    override val id: Int, override val groupId: Int,
    val galleryList: List<GalleryData>
) : ComponentData