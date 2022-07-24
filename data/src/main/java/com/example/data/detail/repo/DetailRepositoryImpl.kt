package com.example.data.detail.repo

import com.example.core.base.*
import com.example.data.common.utils.Collection
import com.example.data.detail.dto.DetailDto
import com.example.data.detail.utils.mappers.DetailDtoToEntity
import com.example.data.news.dto.NewsDto
import com.example.data.news.utils.mappers.NewsDtoToEntity
import com.example.domain.detail.entity.DetailEntity
import com.example.domain.detail.repo.DetailRepository
import com.example.domain.news.entity.NewsEntity
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(
    private val db: FirebaseFirestore
) : DetailRepository {

    private val detailDtoToEntity = DetailDtoToEntity()
    override suspend fun getDetail(): Flow<BaseResult<List<DetailEntity>, String>> = callbackFlow {
        db.collection(Collection.info).get().addOnCompleteListener { task ->
            val list = mutableListOf<DetailDto>()
            task.result.forEach {
                list.add(it.toObject(DetailDto::class.java))
            }
            val temp = detailDtoToEntity.fromToList(list)
            temp?.let { trySend(SuccessResult(it)) }
        }.addOnFailureListener {
            trySend(ErrorResult(it.message))
        }
        awaitClose {
            trySend(PendingResult)
        }
    }
}