package net.appthos.sdui.data

import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class DataProvider {
    private var disposable: Disposable? = null

    private fun getServerData(): Flowable<List<ComponentData>> {
        return Flowable.just(
            listOf(
                TitleData(1, 1, "사진 갤러리"),
                GalleryData(2, 1, ""),
                GalleryData(3, 1, ""),
                GalleryData(4, 1, ""),
                GalleryData(5, 1, ""),
                TitleData(8, 2, "추천 업체"),
                GalleryData(6, 1, ""),
                GalleryData(7, 1, ""),
                PartnerData(9, 2, "업체1", ""),
                PartnerData(10, 2, "업체2", ""),
                PartnerData(11, 2, "업체3", ""),
                PartnerData(12, 2, "업체4", ""),
                PartnerData(13, 2, "업체5", ""),
                TitleData(18, 3, "무언가 추천 정보"),
                PartnerData(14, 2, "업체6", ""),
                PartnerData(15, 2, "업체7", ""),
                PartnerData(16, 2, "업체8", ""),
                PartnerData(17, 2, "업체9", ""),

                GalleryData(6, 3, ""),
                GalleryData(7, 3, ""),
                GalleryData(3, 3, ""),
                GalleryData(4, 3, ""),
                GalleryData(18, 3, ""),
                GalleryData(19, 3, ""),
                GalleryData(20, 3, ""),
                GalleryData(21, 3, ""),
                GalleryData(22, 3, ""),
                GalleryData(23, 3, ""),
                GalleryData(24, 3, ""),
                GalleryData(25, 3, ""),
                FooterData(19, 4)
            )
        )
    }

    fun processingServerData(callback: (list: List<ComponentData>) -> Unit) {
        getServerData()
            .subscribeOn(Schedulers.io())
            .flatMapIterable { it }

            // groupId 기준으로 데이터 묶기
            .groupBy { it.groupId }
            .flatMapSingle { it.toList() }

            // 묶은 데이터 상위 컴포넌트로 합치기
            .map { mergeComponent(it) }

            // 하나의 리스트로 만들기
            .flatMapIterable { it }
            .toList()

            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                callback(it)
            }, { e -> Log.e(TAG, "test: ${e.message}") })
            .also { disposable = it }
    }

    private fun mergeComponent(list: List<ComponentData>): List<ComponentData> {
        val mergedList = ArrayList<ComponentData>()
        var groupComponent: ComponentData? = null
        for (componentData in list) {
            when (componentData) {
                is GalleryData -> {
                    if (null == groupComponent) {
                        groupComponent = GalleryGroupData(componentData.id, componentData.groupId)
                    }

                    if (groupComponent is GalleryGroupData) {
                        groupComponent.addGalleryData(componentData)
                    }

                }
                else -> mergedList.add(componentData)
            }
        }

        groupComponent?.let {
            mergedList.add(it)
        }

        return mergedList
    }

    fun onDestroy() {
        disposable?.let {
            if (!disposable!!.isDisposed) {
                disposable!!.dispose()
            }
        }
    }

    companion object {
        const val TAG = "DataProvider"
    }
}