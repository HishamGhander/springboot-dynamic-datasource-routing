package com.allegiancemd.config;

import com.allegiancemd.constant.DatabaseEnum;

public class DatabaseContextHolder {

    private static ThreadLocal<DatabaseEnum> threadLocal = new ThreadLocal<>();

    public static void setDatabaseContext(DatabaseEnum databaseEnum) {
        threadLocal.set(databaseEnum);
    }

    public static DatabaseEnum getDatabaseContext() {
        return threadLocal.get();
    }

    public static void clearDatabaseContext() {
        threadLocal.remove();
    }
}
