package com.example.data.participants.repo

import com.example.core.base.*
import com.example.data.common.utils.Collection
import com.example.data.participants.dto.ParticipantsDto
import com.example.data.participants.utils.mappers.ParticipantsDtoToEntity
import com.example.domain.participants.entity.ParticipantEntity
import com.example.domain.participants.repo.ParticipantsRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class ParticipantsRepositoryImpl @Inject  constructor(
    private val db: FirebaseFirestore
) : ParticipantsRepository {

    private val participantsDtoToEntity = ParticipantsDtoToEntity()
    override suspend fun getNews(): Flow<BaseResult<List<ParticipantEntity>, String>> = callbackFlow {
        db.collection(Collection.news).get().addOnCompleteListener { task ->
            val list = mutableListOf<ParticipantsDto>()
            task.result.forEach {
                list.add(it.toObject(ParticipantsDto::class.java))
            }
            val temp = participantsDtoToEntity.fromToList(list)
            temp?.let { trySend(SuccessResult(it)) }
        }.addOnFailureListener {
            trySend(ErrorResult(it.message))
        }
        awaitClose {
            trySend(PendingResult)
        }
    }
}