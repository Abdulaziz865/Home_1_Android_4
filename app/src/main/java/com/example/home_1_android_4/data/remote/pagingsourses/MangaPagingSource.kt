package com.example.home_1_android_4.data.remote.pagingsourses

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.home_1_android_4.data.models.manga.MangaData
import com.example.home_1_android_4.data.remote.apiservices.MangaApiService
import retrofit2.HttpException

class MangaPagingSource(private val service: MangaApiService) : PagingSource<Int, MangaData>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MangaData> {
        try {
            val page = params.key ?: DEFAULT_PAGE_NUMBER
            val responce = service.fetchManga(params.loadSize , page)
            val nextPageNumber = if (responce.links.next == null) {
                null
            } else {
                Uri.parse(responce.links.next).getQueryParameter("page[offset]")!!.toInt()
            }
            return LoadResult.Page(
                data = responce.data,
                prevKey = null,
                nextKey = nextPageNumber
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        } catch (e: HttpException) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, MangaData>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}