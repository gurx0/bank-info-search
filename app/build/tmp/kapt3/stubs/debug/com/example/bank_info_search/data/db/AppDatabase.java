package com.example.bank_info_search.data.db;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lcom/example/bank_info_search/data/db/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "historyDao", "Lcom/example/bank_info_search/data/dao/HistoryDao;", "app_debug"})
@androidx.room.Database(entities = {com.example.bank_info_search.data.models.HistoryItem.class}, version = 1, exportSchema = false)
@androidx.room.TypeConverters(value = {com.example.bank_info_search.domain.utils.Converters.class})
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.bank_info_search.data.dao.HistoryDao historyDao();
}