package com.example.bank_info_search.data.repo;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/example/bank_info_search/data/repo/BinRepository;", "", "getBinDetails", "Lcom/example/bank_info_search/data/models/BinDomainModel;", "bin", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHistory", "", "Lcom/example/bank_info_search/data/models/HistoryItem;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface BinRepository {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getBinDetails(@org.jetbrains.annotations.NotNull
    java.lang.String bin, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.bank_info_search.data.models.BinDomainModel> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getHistory(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.bank_info_search.data.models.HistoryItem>> $completion);
}