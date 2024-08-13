package com.example.manolja.data.repository

import RecordEntity
import com.example.manolja.data.dao.RecordDao

class RecordRepository(private val recordDao: RecordDao) {

    suspend fun insertRecord(record: RecordEntity) {
        recordDao.insertRecord(record)
    }

    suspend fun getRecordById(questId: Int): RecordEntity? {
        return recordDao.getRecordById(questId)
    }

    suspend fun updateRecord(record: RecordEntity) {
        recordDao.updateRecord(record)
    }

    suspend fun deleteRecord(record: RecordEntity) {
        recordDao.deleteRecord(record)
    }

    suspend fun getAllRecords(): List<RecordEntity> {
        return recordDao.getAllRecords()
    }
}
