package com.example.bank_info_search.data.repo;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\n\u0010\u0010\u001a\u00020\b*\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/example/bank_info_search/data/repo/BinRepositoryImpl;", "Lcom/example/bank_info_search/data/repo/BinRepository;", "apiService", "Lcom/example/bank_info_search/domain/network/ApiService;", "historyDao", "Lcom/example/bank_info_search/data/dao/HistoryDao;", "(Lcom/example/bank_info_search/domain/network/ApiService;Lcom/example/bank_info_search/data/dao/HistoryDao;)V", "getBinDetails", "Lcom/example/bank_info_search/data/models/BinDomainModel;", "bin", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHistory", "", "Lcom/example/bank_info_search/data/models/HistoryItem;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toDomainModel", "app_debug"})
public final class BinRepositoryImpl implements com.example.bank_info_search.data.repo.BinRepository {
    @org.jetbrains.annotations.NotNull
    private final com.example.bank_info_search.domain.network.ApiService apiService = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.bank_info_search.data.dao.HistoryDao historyDao = null;
    
    public BinRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.example.bank_info_search.domain.network.ApiService apiService, @org.jetbrains.annotations.NotNull
    com.example.bank_info_search.data.dao.HistoryDao historyDao) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getBinDetails(@org.jetbrains.annotations.NotNull
    java.lang.String bin, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.bank_info_search.data.models.BinDomainModel> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getHistory(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.bank_info_search.data.models.HistoryItem>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.bank_info_search.data.models.BinDomainModel toDomainModel(@org.jetbrains.annotations.NotNull
    com.example.bank_info_search.data.models.BinDomainModel $this$toDomainModel) {
        return null;
    }
}