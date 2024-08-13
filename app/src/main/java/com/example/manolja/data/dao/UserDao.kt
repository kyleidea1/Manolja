package com.example.manolja.data.dao

import androidx.room.*
import com.example.manolja.data.entity.UserEntity

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(users: List<UserEntity>)

    @Update
    suspend fun updateUser(user: UserEntity)

    @Delete
    suspend fun deleteUser(user: UserEntity)

    @Query("SELECT * FROM posts")
    suspend fun getAllUsers(): List<UserEntity>

    @Query("SELECT * FROM posts WHERE memberNo = :id LIMIT 1")
    suspend fun getUserById(id: Int): UserEntity?
}
