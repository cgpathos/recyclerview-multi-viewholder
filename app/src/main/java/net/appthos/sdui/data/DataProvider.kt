package net.appthos.sdui.data

class DataProvider {
    fun getServerData(): List<ComponentData> {
        val dataList = ArrayList<ComponentData>()
        dataList.add(TitleData(1, 1, "사진 갤러리"))
        dataList.add(GalleryGroupData(2, 1, listOf(
            GalleryData(2, 1, ""),
            GalleryData(3, 1, ""),
            GalleryData(4, 1, ""),
            GalleryData(5, 1, ""),
            GalleryData(6, 1, ""),
            GalleryData(7, 1, ""),
        )))
        dataList.add(TitleData(8, 2, "추천 업체"))
        dataList.add(PartnerData(9, 2, "업체1", ""))
        dataList.add(PartnerData(10, 2, "업체2", ""))
        dataList.add(PartnerData(11, 2, "업체3", ""))
        dataList.add(PartnerData(12, 2, "업체4", ""))
        dataList.add(PartnerData(13, 2, "업체5", ""))
        dataList.add(PartnerData(14, 2, "업체6", ""))
        dataList.add(PartnerData(15, 2, "업체7", ""))
        dataList.add(PartnerData(16, 2, "업체8", ""))
        dataList.add(PartnerData(17, 2, "업체9", ""))
        dataList.add(TitleData(18, 3, "무언가 추천 정보"))
        return dataList
    }
}