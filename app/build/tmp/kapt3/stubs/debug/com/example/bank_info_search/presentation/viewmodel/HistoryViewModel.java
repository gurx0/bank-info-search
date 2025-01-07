package com.example.bank_info_search.presentation.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010\u000f\u001a\u00020\u000eR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/example/bank_info_search/presentation/viewmodel/HistoryViewModel;", "Landroidx/lifecycle/ViewModel;", "getHistoryUseCase", "Lcom/example/bank_info_search/domain/useCases/GetHistoryUseCase;", "(Lcom/example/bank_info_search/domain/useCases/GetHistoryUseCase;)V", "_history", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/bank_info_search/data/models/HistoryItem;", "history", "Lkotlinx/coroutines/flow/StateFlow;", "getHistory", "()Lkotlinx/coroutines/flow/StateFlow;", "loadHistory", "", "refreshHistory", "app_debug"})
public final class HistoryViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.bank_info_search.domain.useCases.GetHistoryUseCase getHistoryUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.bank_info_search.data.models.HistoryItem>> _history = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.bank_info_search.data.models.HistoryItem>> history = null;
    
    public HistoryViewModel(@org.jetbrains.annotations.NotNull
    com.example.bank_info_search.domain.useCases.GetHistoryUseCase getHistoryUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.bank_info_search.data.models.HistoryItem>> getHistory() {
        return null;
    }
    
    private final void loadHistory() {
    }
    
    public final void refreshHistory() {
    }
}