package com.winupon.andframe.bigapple.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * 一个更接近底层数据库操作的适配器，可使用安卓原生API操作数据库，多线程操作不同实例，可能会有问题<br>
 * 废弃不建议使用
 * 
 * @author xuan
 */
@Deprecated
public class BasicDaoAdapter {
    private final SQLiteDatabase sqliteDatabase;
    private final DBHelper dbHelper;
    private final Context context;

    public BasicDaoAdapter(Context context) {
        dbHelper = new DBHelper(context);
        this.context = context;
        sqliteDatabase = dbHelper.getWritableDatabase();
    }

    public SQLiteDatabase getSQLiteDatabase() {
        return sqliteDatabase;
    }

    /**
     * 使用完后请Close数据库连接
     */
    public void close() {
        dbHelper.close();
    }

    protected Context getContext() {
        return context;
    }

}
