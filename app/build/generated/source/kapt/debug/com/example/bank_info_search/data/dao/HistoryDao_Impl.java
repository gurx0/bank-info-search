package com.example.bank_info_search.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.bank_info_search.data.models.BinDomainModel;
import com.example.bank_info_search.data.models.HistoryItem;
import com.example.bank_info_search.domain.utils.Converters;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class HistoryDao_Impl implements HistoryDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<HistoryItem> __insertionAdapterOfHistoryItem;

  private final Converters __converters = new Converters();

  public HistoryDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfHistoryItem = new EntityInsertionAdapter<HistoryItem>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `history` (`id`,`bin`,`data`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final HistoryItem entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getBin() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getBin());
        }
        final String _tmp = __converters.fromBinDomainModel(entity.getData());
        if (_tmp == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, _tmp);
        }
      }
    };
  }

  @Override
  public Object insertHistory(final HistoryItem item,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfHistoryItem.insert(item);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getAllHistory(final Continuation<? super List<HistoryItem>> $completion) {
    final String _sql = "SELECT * FROM history";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<HistoryItem>>() {
      @Override
      @NonNull
      public List<HistoryItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfBin = CursorUtil.getColumnIndexOrThrow(_cursor, "bin");
          final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
          final List<HistoryItem> _result = new ArrayList<HistoryItem>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final HistoryItem _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpBin;
            if (_cursor.isNull(_cursorIndexOfBin)) {
              _tmpBin = null;
            } else {
              _tmpBin = _cursor.getString(_cursorIndexOfBin);
            }
            final BinDomainModel _tmpData;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfData)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfData);
            }
            _tmpData = __converters.toBinDomainModel(_tmp);
            _item = new HistoryItem(_tmpId,_tmpBin,_tmpData);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
