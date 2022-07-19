package com.example.data.participants.module

import com.example.data.participants.repo.ParticipantsRepositoryImpl
import com.example.domain.participants.repo.ParticipantsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ParticipantsModule {
    @Binds
    fun bindParticipantsRepo(
        participantsRepositoryImpl: ParticipantsRepositoryImpl
    ): ParticipantsRepository
}