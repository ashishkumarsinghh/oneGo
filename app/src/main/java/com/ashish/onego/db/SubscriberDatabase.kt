package com.ashish.onego.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Subscriber::class], version=1)
abstract class SubscriberDatabase: RoomDatabase(){
    abstract  val subscriberDAO: SubscriberDAO

    companion object{
        @Volatile
        private var instance: SubscriberDatabase? = null
        fun getInstance(ctx: Context): SubscriberDatabase{
            synchronized(this){
                if(instance == null){
                    instance = Room.databaseBuilder(ctx.applicationContext, SubscriberDatabase::class.java, "subscriber_db").build()
                }
                return instance as SubscriberDatabase
            }
        }
    }
}