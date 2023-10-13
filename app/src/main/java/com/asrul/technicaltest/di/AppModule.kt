package com.asrul.technicaltest.di

import android.content.Context
import androidx.room.Room
import com.asrul.technicaltest.data.datastore.UserDataStore
import com.asrul.technicaltest.data.local.dao.TransactionDao
import com.asrul.technicaltest.data.local.database.AppDatabase
import com.asrul.technicaltest.data.repository.RepositoryImpl
import com.asrul.technicaltest.domain.repository.Repository
import com.asrul.technicaltest.domain.usecase.TransactionUseCase
import com.asrul.technicaltest.domain.usecase.TransactionUseCaseInteractor
import com.asrul.technicaltest.domain.usecase.UserUseCase
import com.asrul.technicaltest.domain.usecase.UserUseCaseInteractor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideTransactionDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "app_db").build()
    }

    @Singleton
    @Provides
    fun provideTransactionDao(database: AppDatabase) : TransactionDao = database.transactionDao()

    @Singleton
    @Provides
    fun provideDataStore(@ApplicationContext context: Context): UserDataStore = UserDataStore(context)

    @Singleton
    @Provides
    fun provideRepository(dao: TransactionDao, userDataStore: UserDataStore): Repository = RepositoryImpl(dao, userDataStore)

    @Singleton
    @Provides
    fun provideTransactionUseCase(repository: Repository): TransactionUseCase = TransactionUseCaseInteractor(repository)

    @Singleton
    @Provides
    fun provideUserUseCase(repository: Repository): UserUseCase = UserUseCaseInteractor(repository)
}