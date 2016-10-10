package ch.dodora.ultraquizz.database;

import android.provider.BaseColumns;

/**
 * Created by rdomi on 10/10/2016.
 */

public final class TableTheme {

    public static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS \"" + ThemeEntry.TABLE_NAME + "\" (\n" +
            "\t`" + ThemeEntry.COLUMN_NAME_ID + "`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
            "\t`" + ThemeEntry.COLUMN_NAME_THEME + "`\tTEXT NOT NULL UNIQUE\n" + ");";
    public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + ThemeEntry.TABLE_NAME;
    public static final String SQL_CREATE_PART_00 = "INSERT INTO `" + TableTheme.ThemeEntry.TABLE_NAME + "` VALUES " +
            "(1,'Les capitales'),\n" +
            "(2,'Les sommets');";

    private TableTheme() {
    }

    public static class ThemeEntry implements BaseColumns {
        public static final String TABLE_NAME = "tb_theme";
        public static final String COLUMN_NAME_ID = "id_them";
        public static final String COLUMN_NAME_THEME = "theme_them";
    }
}
