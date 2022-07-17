package com.example.data.news.repo

import com.example.core.base.*
import com.example.data.common.utils.Collection
import com.example.data.news.dto.NewsDto
import com.example.data.news.utils.mappers.NewsDtoToEntity
import com.example.domain.news.entity.NewsEntity
import com.example.domain.news.repo.NewsRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val db: FirebaseFirestore
) : NewsRepository {

    private val newsDtoToEntity = NewsDtoToEntity()
    override suspend fun getNews(): Flow<BaseResult<List<NewsEntity>, String>> = callbackFlow {
        db.collection(Collection.news).get().addOnCompleteListener { task ->
            val list = mutableListOf<NewsDto>()
            task.result.forEach {
                list.add(it.toObject(NewsDto::class.java))
            }
            val temp = newsDtoToEntity.fromToList(list)
            temp?.let { trySend(SuccessResult(it)) }
        }.addOnFailureListener {
            trySend(ErrorResult(it.message))
        }
        awaitClose {
            trySend(PendingResult)
        }
    }
}