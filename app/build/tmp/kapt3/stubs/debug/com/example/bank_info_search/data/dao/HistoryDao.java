package com.example.bank_info_search.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/example/bank_info_search/data/dao/HistoryDao;", "", "getAllHistory", "", "Lcom/example/bank_info_search/data/models/HistoryItem;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertHistory", "", "item", "(Lcom/example/bank_info_search/data/models/HistoryItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao
public abstract interface HistoryDao {
    
    @androidx.room.Query(value = "SELECT * FROM history")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllHistory(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.bank_info_search.data.models.HistoryItem>> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertHistory(@org.jetbrains.annotations.NotNull
    com.example.bank_info_search.data.models.HistoryItem item, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}