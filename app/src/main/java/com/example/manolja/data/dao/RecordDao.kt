package com.example.manolja.data.dao

import RecordEntity
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Delete

@Dao
interface RecordDao {
    @Insert
    suspend fun insertRecord(record: RecordEntity)

    @Update
    suspend fun updateRecord(record: RecordEntity)

    @Delete
    suspend fun deleteRecord(record: RecordEntity)

    @Query("SELECT * FROM records WHERE recordId = :id")
    suspend fun getRecordById(id: Int): RecordEntity?

    @Query("SELECT * FROM records")
    suspend fun getAllRecords(): List<RecordEntity>
}
