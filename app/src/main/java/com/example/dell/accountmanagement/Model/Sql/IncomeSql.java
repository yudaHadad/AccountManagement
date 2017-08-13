package com.example.dell.accountmanagement.Model.Sql;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dell.accountmanagement.Model.Common.IncomeConsts;
import com.example.dell.accountmanagement.Model.Income;

import java.util.LinkedList;
import java.util.List;
/**
 * Created by Dell on 24/06/2017.
 */
public class IncomeSql
{

    /**
     * create income table
     */
    public static void create(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + IncomeConsts.INCOME_TABLE + " ( id INTEGER PRIMARY KEY AUTOINCREMENT," +
                IncomeConsts.AMOUNT + " REAL," + IncomeConsts.MONTH + " INTEGER, " + IncomeConsts.IS_ONE_TIME_INCOME
                 +  " INTEGER, " + IncomeConsts.YEAR + " INTEGER," + IncomeConsts.TYPE + " TEXT);");
    }

    /**
     * drop income table
     */
    public static void drop(SQLiteDatabase db) {
        db.execSQL("DROP TABLE " + IncomeConsts.INCOME_TABLE);
    }

    /**
     * Add new income to db
     * @param dbHelper
     * @param income
     */
    public static void addIncome(ModelSql.MyOpenHelper dbHelper, Income income) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(IncomeConsts.TYPE, income.getType());
        contentValues.put(IncomeConsts.MONTH, income.getMonth());
        contentValues.put(IncomeConsts.YEAR, income.getYear());
        contentValues.put(IncomeConsts.AMOUNT, income.getAmount());
        contentValues.put(IncomeConsts.IS_ONE_TIME_INCOME, income.getIsOneTimeIncome());
        dbHelper.getWritableDatabase().insert(IncomeConsts.INCOME_TABLE, null, contentValues);
    }

    // delete income
    public static void deleteIncome(ModelSql.MyOpenHelper dbHelper, Income income) {
       //TODO: for now do nothing
        dbHelper.getWritableDatabase().delete(IncomeConsts.INCOME_TABLE,null ,null);
    }

    // get all incomes
    public static List<Income> getAllIncomes (ModelSql.MyOpenHelper dbHelper) {
        List<Income> data = new LinkedList<Income>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Get all incomes from db
        Cursor cursor = db.query(IncomeConsts.INCOME_TABLE, null, null, null, null, null, null);

        // Run on all return raws
        if (cursor.moveToFirst()) {
            // Get column indexes
            int id_index = cursor.getColumnIndex("id");
            int amount_index = cursor.getColumnIndex(IncomeConsts.AMOUNT);
            int month_index = cursor.getColumnIndex(IncomeConsts.MONTH);
            int year_index = cursor.getColumnIndex(IncomeConsts.YEAR);
            int isOneTimeIncome_index = cursor.getColumnIndex(IncomeConsts.IS_ONE_TIME_INCOME);
            int type_index = cursor.getColumnIndex(IncomeConsts.TYPE);
            do {
                // Get column value of this raw
                int id = cursor.getInt(id_index);
                double amount = cursor.getDouble(amount_index);
                int month = cursor.getInt(month_index);
                int year = cursor.getInt(year_index);
                int isOneTimeIncome = cursor.getInt(isOneTimeIncome_index);
                String type = cursor.getString(type_index);

                // Create new income with raw details
                Income income = new Income(id, type, month, isOneTimeIncome, amount, year);

                // add income to list
                data.add(income);
            } while (cursor.moveToNext());
        }
        return data;
    }

    // get all incomes that not one time
    public static List<Income> getAllConstIncome(ModelSql.MyOpenHelper dbHelper) {
        List<Income> data = new LinkedList<Income>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Get all incomes from db
        Cursor cursor = db.query(IncomeConsts.INCOME_TABLE, null, IncomeConsts.IS_ONE_TIME_INCOME + " = ? ", new String[]{"0"}, null, null, null);

        // Run on all return raws
        if (cursor.moveToFirst()) {
            // Get column indexes
            int id_index = cursor.getColumnIndex("id");
            int amount_index = cursor.getColumnIndex(IncomeConsts.AMOUNT);
            int month_index = cursor.getColumnIndex(IncomeConsts.MONTH);
            int year_index = cursor.getColumnIndex(IncomeConsts.YEAR);
            int isOneTimeIncome_index = cursor.getColumnIndex(IncomeConsts.IS_ONE_TIME_INCOME);
            int type_index = cursor.getColumnIndex(IncomeConsts.TYPE);
            do {
                // Get column value of this raw
                int id = cursor.getInt(id_index);
                double amount = cursor.getDouble(amount_index);
                int month = cursor.getInt(month_index);
                int year = cursor.getInt(year_index);
                int isOneTimeIncome = cursor.getInt(isOneTimeIncome_index);
                String type = cursor.getString(type_index);

                // Create new income with raw details
                Income income = new Income(id, type, month, isOneTimeIncome, amount, year);

                // add income to list
                data.add(income);
            } while (cursor.moveToNext());
        }
        return data;
    }

    // get all incomes that one time
    public static List<Income> getOneTimeIncomesByMonth(ModelSql.MyOpenHelper dbHelper, int month) {
        List<Income> data = new LinkedList<Income>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Get all incomes from db
        Cursor cursor = db.query(IncomeConsts.INCOME_TABLE, null, IncomeConsts.IS_ONE_TIME_INCOME
                + " = ? and " + IncomeConsts.MONTH + " = ?", new String[]{"1", String.valueOf(month)}, null, null, null);

        // Run on all return raws
        if (cursor.moveToFirst()) {
            // Get column indexes
            int id_index = cursor.getColumnIndex("id");
            int amount_index = cursor.getColumnIndex(IncomeConsts.AMOUNT);
            int month_index = cursor.getColumnIndex(IncomeConsts.MONTH);
            int year_index = cursor.getColumnIndex(IncomeConsts.YEAR);
            int isOneTimeIncome_index = cursor.getColumnIndex(IncomeConsts.IS_ONE_TIME_INCOME);
            int type_index = cursor.getColumnIndex(IncomeConsts.TYPE);
            do {
                // Get column value of this raw
                int id = cursor.getInt(id_index);
                double amount = cursor.getDouble(amount_index);
                int month2 = cursor.getInt(month_index);
                int year = cursor.getInt(year_index);
                int isOneTimeIncome = cursor.getInt(isOneTimeIncome_index);
                String type = cursor.getString(type_index);

                // Create new income with raw details
                Income income = new Income(id, type, month2, isOneTimeIncome, amount, year);

                // add income to list
                data.add(income);
            } while (cursor.moveToNext());
        }
        return data;
    }

    // get income by id
    public static Income getNameById (ModelSql.MyOpenHelper dbHelper ,int id) {
        Income income;
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Get incomes from db
        Cursor cursor = db.query(IncomeConsts.INCOME_TABLE, null, "id = ? ", new String[]{"" + id}, null, null, null);

        // Run on all return raws
        if (cursor.moveToFirst()) {
            // Get column indexes
            int id_index = cursor.getColumnIndex("id");
            int amount_index = cursor.getColumnIndex(IncomeConsts.AMOUNT);
            int month_index = cursor.getColumnIndex(IncomeConsts.MONTH);
            int year_index = cursor.getColumnIndex(IncomeConsts.YEAR);
            int isOneTimeIncome_index = cursor.getColumnIndex(IncomeConsts.IS_ONE_TIME_INCOME);
            int type_index = cursor.getColumnIndex(IncomeConsts.TYPE);
            do {
                // Get column value of this raw
                int id1 = cursor.getInt(id_index);
                double amount = cursor.getDouble(amount_index);
                int month2 = cursor.getInt(month_index);
                int year = cursor.getInt(year_index);
                int isOneTimeIncome = cursor.getInt(isOneTimeIncome_index);
                String type = cursor.getString(type_index);

                // Create new income with raw details
                income = new Income(id1, type, month2, isOneTimeIncome, amount, year);

            } while (cursor.moveToNext());
            return income;

        }
        return null;
    }
}
