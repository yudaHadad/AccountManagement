package com.example.dell.accountmanagement.Model.Sql;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dell.accountmanagement.Model.Common.ExpenseConsts;
import com.example.dell.accountmanagement.Model.Common.ExpenseGoalConsts;
import com.example.dell.accountmanagement.Model.Common.ExpenseTypeConsts;
import com.example.dell.accountmanagement.Model.ExpenseGoal;
import com.example.dell.accountmanagement.Model.ExpenseType;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yuda on 25/06/2017.
 */

public class ExpenseTypeSql {
    // create expense type table
    public static void create(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + ExpenseTypeConsts.EXPENSE_TYPE_TABLE + " ( id INTEGER PRIMARY KEY AUTOINCREMENT," +
                ExpenseTypeConsts.TYPE + " INTEGER, " + ExpenseTypeConsts.NAME + " TEXT);");
    }

    // drop expense type table
    public static void drop(SQLiteDatabase db) {
        db.execSQL("DROP TABLE " + ExpenseTypeConsts.EXPENSE_TYPE_TABLE);
    }

    // add expense type
    public static void addExpenseType(ModelSql.MyOpenHelper dbHelper, ExpenseType expense) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ExpenseTypeConsts.TYPE, expense.getType());
        contentValues.put(ExpenseTypeConsts.NAME, expense.getName());
        dbHelper.getWritableDatabase().insert(ExpenseTypeConsts.EXPENSE_TYPE_TABLE, null, contentValues);
    }

    // delete expense type
    public static void deleteExpenseType(ModelSql.MyOpenHelper dbHelper, ExpenseType expense) {
        //TODO: for now do nothing
        dbHelper.getWritableDatabase().delete(ExpenseTypeConsts.EXPENSE_TYPE_TABLE, null, null);
    }

    // get all expense type
    public static List<ExpenseType> gatAllExpenseType (ModelSql.MyOpenHelper dbHelper) {
        List<ExpenseType> data = new LinkedList<ExpenseType>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Get all expense type from db
        Cursor cursor = db.query(ExpenseTypeConsts.EXPENSE_TYPE_TABLE, null, null, null, null, null, null);

        // Run on all return raws
        if (cursor.moveToFirst()) {
            // Get column indexes
            int id_index = cursor.getColumnIndex("id");
            int type_index = cursor.getColumnIndex(ExpenseTypeConsts.TYPE);
            int name_index = cursor.getColumnIndex(ExpenseTypeConsts.NAME);

            do
            {
                // Get column value of this raw
                int id = cursor.getInt(id_index);
                int type = cursor.getInt(type_index);
                String name = cursor.getString(name_index);

                // Create new expense type with raw details
                ExpenseType expenseType = new ExpenseType(id, name ,type);

                // add income to list
                data.add(expenseType);
            } while (cursor.moveToNext());
        }
        return data;
    }

    // get All Change expenses type with type 2
    public static List<ExpenseType> getAllChangeExpenseType(ModelSql.MyOpenHelper dbHelper) {
        // TODO:
        return null;
    }

    // get expenses type by id
    public static ExpenseType getExpenseTypeById (ModelSql.MyOpenHelper dbHelper ,int id) {
        ExpenseType expenseType;
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Get Expense from db
        Cursor cursor = db.query(ExpenseTypeConsts.EXPENSE_TYPE_TABLE, null, "id = ? ", new String[]{"" + id}, null, null, null);

        // Run on all return raws
        if (cursor.moveToFirst()) {
            // Get column indexes
            int id_index = cursor.getColumnIndex("id");
            int type_index = cursor.getColumnIndex(ExpenseTypeConsts.TYPE);
            int name_index = cursor.getColumnIndex(ExpenseTypeConsts.NAME);

            do
            {
                // Get column value of this raw
                int id1 = cursor.getInt(id_index);
                int type = cursor.getInt(type_index);
                String name = cursor.getString(name_index);

                // Create new expense type with raw details
                expenseType = new ExpenseType(id1, name ,type);

            } while (cursor.moveToNext());
            return expenseType;
        }
        return null;
    }

}
