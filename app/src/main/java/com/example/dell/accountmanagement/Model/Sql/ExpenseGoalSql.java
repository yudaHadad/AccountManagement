package com.example.dell.accountmanagement.Model.Sql;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dell.accountmanagement.Model.Common.ExpenseConsts;
import com.example.dell.accountmanagement.Model.Common.ExpenseGoalConsts;
import com.example.dell.accountmanagement.Model.Expense;
import com.example.dell.accountmanagement.Model.ExpenseGoal;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dell on 24/06/2017.
 */
public class ExpenseGoalSql {

    // create expense_goal table
    public static void create(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + ExpenseGoalConsts.EXPENSE_GOAL_TABLE + " ( id INTEGER PRIMARY KEY AUTOINCREMENT," +
                ExpenseGoalConsts.TYPE + " INTEGER, " + ExpenseGoalConsts.AMOUNT + " INTEGER);");
    }

    // drop expense_goal table
    public static void drop(SQLiteDatabase db) {
        db.execSQL("DROP TABLE " + ExpenseGoalConsts.EXPENSE_GOAL_TABLE);
    }

    // add expense_goal
    public static void addExpenseGoal(ModelSql.MyOpenHelper dbHelper, ExpenseGoal expense) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ExpenseGoalConsts.TYPE, expense.getType());
        contentValues.put(ExpenseGoalConsts.AMOUNT, expense.getAmount());
        dbHelper.getWritableDatabase().insert(ExpenseGoalConsts.EXPENSE_GOAL_TABLE, null, contentValues);
    }

    // delete expense_goal
    public static void deleteExpenseGoal(ModelSql.MyOpenHelper dbHelper, ExpenseGoal expense) {
        //TODO: for now do nothing
        dbHelper.getWritableDatabase().delete(ExpenseGoalConsts.EXPENSE_GOAL_TABLE, null, null);
    }

    // get all expenses goal
    public static List<ExpenseGoal> gatAllExpenseGoal (ModelSql.MyOpenHelper dbHelper) {
        List<ExpenseGoal> data = new LinkedList<ExpenseGoal>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Get all expense goal from db
        Cursor cursor = db.query(ExpenseGoalConsts.EXPENSE_GOAL_TABLE, null, null, null, null, null, null);

        // Run on all return raws
        if (cursor.moveToFirst()) {
            // Get column indexes
            int id_index = cursor.getColumnIndex("id");
            int type_index = cursor.getColumnIndex(ExpenseGoalConsts.TYPE);
            int amount_index = cursor.getColumnIndex(ExpenseConsts.AMOUNT);

            do
            {
                // Get column value of this raw
                int id = cursor.getInt(id_index);
                int type = cursor.getInt(type_index);
                double amount = cursor.getDouble(amount_index);

                // Create new expense goal with raw details
                ExpenseGoal expenseGoal = new ExpenseGoal(id, type, amount);

                // add income to list
                data.add(expenseGoal);
            } while (cursor.moveToNext());
        }
        return data;
    }

    // get all expenses_goal by type
    public static List<ExpenseGoal> getAllExpenseGoalByType(ModelSql.MyOpenHelper dbHelper, int type) {
        List<ExpenseGoal> data = new LinkedList<ExpenseGoal>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Get all Expenses from db
        Cursor cursor = db.query(ExpenseGoalConsts.EXPENSE_GOAL_TABLE, null, ExpenseConsts.TYPE + " = ? ", new String[]{"" + type}, null, null, null);

        // Run on all return raws
        if (cursor.moveToFirst()) {
            // Get column indexes
            int id_index = cursor.getColumnIndex("id");
            int type_index = cursor.getColumnIndex(ExpenseGoalConsts.TYPE);
            int amount_index = cursor.getColumnIndex(ExpenseConsts.AMOUNT);

            do
            {
                // Get column value of this raw
                int id = cursor.getInt(id_index);
                int type1 = cursor.getInt(type_index);
                double amount = cursor.getDouble(amount_index);

                // Create new expense goal with raw details
                ExpenseGoal expenseGoal = new ExpenseGoal(id, type1, amount);

                // add income to list
                data.add(expenseGoal);
            } while (cursor.moveToNext());
        }
        return data;
    }

    // get All Change expenses_goal with type 2
    public static List<ExpenseGoal> getAllChangeExpenseGoal(ModelSql.MyOpenHelper dbHelper) {
        // TODO:
        return null;
    }

    // get expenses_goal by id
    public static ExpenseGoal getExpenseGoalById (ModelSql.MyOpenHelper dbHelper ,int id) {
        ExpenseGoal expenseGoal;
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Get Expense from db
        Cursor cursor = db.query(ExpenseGoalConsts.EXPENSE_GOAL_TABLE, null, "id = ? ", new String[]{"" + id}, null, null, null);

        // Run on all return raws
        if (cursor.moveToFirst()) {
            // Get column indexes
            int id_index = cursor.getColumnIndex("id");
            int type_index = cursor.getColumnIndex(ExpenseGoalConsts.TYPE);
            int amount_index = cursor.getColumnIndex(ExpenseConsts.AMOUNT);

            do
            {
                // Get column value of this raw
                int id1 = cursor.getInt(id_index);
                int type = cursor.getInt(type_index);
                double amount = cursor.getDouble(amount_index);

                // Create new expense goal with raw details
                expenseGoal = new ExpenseGoal(id1, type, amount);

            } while (cursor.moveToNext());
            return expenseGoal;
        }
        return null;
        }

    }










