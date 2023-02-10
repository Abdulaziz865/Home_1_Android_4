package com.example.home_1_android_4.data.remote.pagingsourses

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.home_1_android_4.data.models.anime.AnimeData
import com.example.home_1_android_4.data.remote.apiservices.AnimeApiService
import retrofit2.HttpException

const val DEFAULT_PAGE_NUMBER = 1

class AnimePagingSource(private val service: AnimeApiService) : PagingSource<Int, AnimeData>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, AnimeData> {
        try {
            val page = params.key ?: DEFAULT_PAGE_NUMBER
            val responce = service.fetchAnime(params.loadSize , page)
            val nextPageNumber = if(responce.links.next == null) {
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

    override fun getRefreshKey(state: PagingState<Int, AnimeData>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}