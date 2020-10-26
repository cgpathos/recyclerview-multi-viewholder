package net.appthos.sdui.data

class DataProvider {
    fun getServerData(): List<ComponentData> {
        return listOf(
            TitleData(1, 1, "사진 갤러리"),
            GalleryGroupData(
                2, 1, listOf(
                    GalleryData(2, 1, ""),
                    GalleryData(3, 1, ""),
                    GalleryData(4, 1, ""),
                    GalleryData(5, 1, ""),
                    GalleryData(6, 1, ""),
                    GalleryData(7, 1, ""),
                )
            ),
            TitleData(8, 2, "추천 업체"),
            PartnerData(9, 2, "업체1", ""),
            PartnerData(10, 2, "업체2", ""),
            PartnerData(11, 2, "업체3", ""),
            PartnerData(12, 2, "업체4", ""),
            PartnerData(13, 2, "업체5", ""),
            PartnerData(14, 2, "업체6", ""),
            PartnerData(15, 2, "업체7", ""),
            PartnerData(16, 2, "업체8", ""),
            PartnerData(17, 2, "업체9", ""),
            TitleData(18, 3, "무언가 추천 정보"),
            FooterData(19, 3)
        )
    }
}