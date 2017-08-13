package com.example.dell.accountmanagement.Model.Sql;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dell.accountmanagement.Model.Common.ExpenseConsts;
import com.example.dell.accountmanagement.Model.Common.IncomeConsts;
import com.example.dell.accountmanagement.Model.Expense;
import com.example.dell.accountmanagement.Model.Income;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dell on 24/06/2017.
 */
public class ExpenseSql {
    /**
     * create expense table
     */
    public static void create(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + ExpenseConsts.EXPENSE_TABLE + " ( id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ExpenseConsts.DATE + " TEXT,"
                + ExpenseConsts.TYPE + " INTEGER, "
                + ExpenseConsts.METHODS_OF_PAYMENT + " TEXT,"
                + ExpenseConsts.DISCRAPTION + " TEXT,"
                + ExpenseConsts.AMOUNT + " INTEGER);");
    }

    /**
     * drop expense table
     */
    public static void drop(SQLiteDatabase db) {
        db.execSQL("DROP TABLE " + ExpenseConsts.EXPENSE_TABLE);
    }

    // add expense
    public static void addExpense(ModelSql.MyOpenHelper dbHelper, Expense expense) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ExpenseConsts.TYPE, expense.getType());
        contentValues.put(ExpenseConsts.DATE, expense.getDate());
        contentValues.put(ExpenseConsts.METHODS_OF_PAYMENT, expense.getMethodsOfPayment());
        contentValues.put(ExpenseConsts.AMOUNT, expense.getAmount());
        contentValues.put(ExpenseConsts.DISCRAPTION, expense.getDiscraption());
        dbHelper.getWritableDatabase().insert(ExpenseConsts.EXPENSE_TABLE, null, contentValues);
    }

    // delete expense
    public static void deleteExpense(ModelSql.MyOpenHelper dbHelper, Expense expense) {
        //TODO: for now do nothing
        dbHelper.getWritableDatabase().delete(ExpenseConsts.EXPENSE_TABLE, null, null);
    }

    // get all expenses
    public static List<Expense> gatAllExpense (ModelSql.MyOpenHelper dbHelper) {
        List<Expense> data = new LinkedList<Expense>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Get all expense from db
        Cursor cursor = db.query(ExpenseConsts.EXPENSE_TABLE, null, null, null, null, null, null);

        // Run on all return raws
        if (cursor.moveToFirst()) {
            // Get column indexes
            int id_index = cursor.getColumnIndex("id");
            int date_index = cursor.getColumnIndex(ExpenseConsts.DATE);
            int type_index = cursor.getColumnIndex(ExpenseConsts.TYPE);
            int methodsOfPayment_index = cursor.getColumnIndex(ExpenseConsts.METHODS_OF_PAYMENT);
            int amount_index = cursor.getColumnIndex(ExpenseConsts.AMOUNT);
            int discraption_index = cursor.getColumnIndex(ExpenseConsts.DISCRAPTION);

            do
            {
                // Get column value of this raw
                int id = cursor.getInt(id_index);
                double amount = cursor.getDouble(amount_index);
                String date = cursor.getString(date_index);
                String methodsOfPayment = cursor.getString(methodsOfPayment_index);
                int type = cursor.getInt(type_index);
                String discraption = cursor.getString(discraption_index);

                // Create new Expense with raw details
                Expense expense = new Expense(id, date, type, methodsOfPayment, amount, discraption);

                // add income to list
                data.add(expense);
            } while (cursor.moveToNext());
        }
        return data;
    }

    // get all Expenses by type
    public static List<Expense> getAllExpenseByType(ModelSql.MyOpenHelper dbHelper, int type) {
        List<Expense> data = new LinkedList<Expense>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Get all Expenses from db
        Cursor cursor = db.query(ExpenseConsts.EXPENSE_TABLE, null, ExpenseConsts.TYPE + " = ? ", new String[]{"" + type}, null, null, null);

        // Run on all return raws
        if (cursor.moveToFirst()) {
            // Get column indexes
            int id_index = cursor.getColumnIndex("id");
            int amount_index = cursor.getColumnIndex(ExpenseConsts.AMOUNT);
            int date_index = cursor.getColumnIndex(ExpenseConsts.DATE);
            int methodsOfPayment_index = cursor.getColumnIndex(ExpenseConsts.METHODS_OF_PAYMENT);
            int type_index = cursor.getColumnIndex(ExpenseConsts.TYPE);
            int discraption_index = cursor.getColumnIndex(ExpenseConsts.DISCRAPTION);

            do {
                // Get column value of this raw
                int id = cursor.getInt(id_index);
                double amount = cursor.getDouble(amount_index);
                String date = cursor.getString(date_index);
                String methodsOfPayment = cursor.getString(methodsOfPayment_index);
                int type1 = cursor.getInt(type_index);
                String discraption = cursor.getString(discraption_index);

                // Create new Expense with raw details
                Expense expense = new Expense(id, date, type, methodsOfPayment, amount, discraption);

                // add income to list
                data.add(expense);
            } while (cursor.moveToNext());
        }
        return data;
    }

    // get All Change Expense with type 2
    public static List<Expense> getAllChangeExpense(ModelSql.MyOpenHelper dbHelper) {
        // TODO:
        return null;
    }

    // get expense by id
    public static Expense getExpenseById (ModelSql.MyOpenHelper dbHelper ,int id) {
        Expense expense;
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Get Expense from db
        Cursor cursor = db.query(ExpenseConsts.EXPENSE_TABLE, null, "id = ? ", new String[]{"" + id}, null, null, null);

        // Run on all return raws
        if (cursor.moveToFirst()) {
            // Get column indexes
            int id_index = cursor.getColumnIndex("id");
            int amount_index = cursor.getColumnIndex(ExpenseConsts.AMOUNT);
            int date_index = cursor.getColumnIndex(ExpenseConsts.DATE);
            int methodsOfPayment_index = cursor.getColumnIndex(ExpenseConsts.METHODS_OF_PAYMENT);
            int type_index = cursor.getColumnIndex(ExpenseConsts.TYPE);
            int discraption_index = cursor.getColumnIndex(ExpenseConsts.DISCRAPTION);

            do {
                // Get column value of this raw
                int id1 = cursor.getInt(id_index);
                double amount = cursor.getDouble(amount_index);
                String date = cursor.getString(date_index);
                String methodsOfPayment = cursor.getString(methodsOfPayment_index);
                int type = cursor.getInt(type_index);
                String discraption = cursor.getString(discraption_index);

                // Create new Expense with raw details
                expense = new Expense(id1, date, type, methodsOfPayment, amount, discraption);

            } while (cursor.moveToNext());
            return expense;
        }
        return null;
    }

}

