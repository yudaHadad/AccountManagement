package com.example.dell.accountmanagement.Model.Sql;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dell.accountmanagement.Model.Expense;
import com.example.dell.accountmanagement.Model.ExpenseGoal;
import com.example.dell.accountmanagement.Model.ExpenseType;
import com.example.dell.accountmanagement.Model.Income;

import java.util.List;

/**
 * Created by Dell on 24/06/2017.
 */
public class ModelSql implements Model.ModelInterface
{
    private MyOpenHelper dbHelper;

    public ModelSql(Context context) {
        dbHelper = new MyOpenHelper(context);
    }

    // add income
    @Override
    public void addIncome(Income income) {
        IncomeSql.addIncome(dbHelper, income);
    }

    // delete income
    @Override
    public void deleteIncome(Income income) {
        IncomeSql.deleteIncome(dbHelper, income);
    }

    // get all incomes that not one time
    @Override
    public List<Income> getAllConstIncome()
    {
        return IncomeSql.getAllConstIncome(dbHelper);
    }

    // get all one time income by date
    @Override
    public List<Income> getOneTimeIncomesByDate(int month) {return IncomeSql.getOneTimeIncomesByMonth(dbHelper, month);}

    // Get all incomes
    @Override
    public List<Income> getAllIncomes ()
    {
        return IncomeSql.getAllIncomes(dbHelper);
    }

    // get name income by id
    @Override
    public Income getNameById (int id)
    {
        return IncomeSql.getNameById(dbHelper, id);
    }

    // add expense
    @Override
    public void addExpense(Expense expense)
    {
        ExpenseSql.addExpense(dbHelper, expense);
    }

    // delete expense
    @Override
    public void deleteExpense(Expense expense) {
        ExpenseSql.deleteExpense(dbHelper, expense);
    }

    // get all expenses
    @Override
    public List<Expense> gatAllExpense() { return ExpenseSql.gatAllExpense(dbHelper); }

    // get all Expenses by type
    @Override
    public List<Expense> getAllExpenseByType(int type) {return ExpenseSql.getAllExpenseByType(dbHelper, type);}

    // get All Change Expense with type 2
    @Override
    public List<Expense> getAllChangeExpense() {
        return ExpenseSql.getAllChangeExpense(dbHelper);
    }

    // get expense by id
    @Override
    public Expense getExpenseById(int id) {
        return ExpenseSql.getExpenseById(dbHelper, id);
    }

    // add expense_goal
    @Override
    public void addExpenseGoal(ExpenseGoal expense){ExpenseGoalSql.addExpenseGoal(dbHelper, expense);}

    // delete expense_goal
    @Override
    public void deleteExpenseGoal(ExpenseGoal expense) {ExpenseGoalSql.deleteExpenseGoal(dbHelper, expense); }

    // get all expenses goal
    @Override
    public List<ExpenseGoal> gatAllExpenseGoal() {return ExpenseGoalSql.gatAllExpenseGoal(dbHelper);}

    // get all expenses_goal by type
    @Override
    public List<ExpenseGoal> getAllExpenseGoalByType(int type){return ExpenseGoalSql.getAllExpenseGoalByType(dbHelper, type);}

    // get All Change expenses_goal with type 2
    @Override
    public List<ExpenseGoal> getAllChangeExpenseGoal(){return ExpenseGoalSql.getAllChangeExpenseGoal(dbHelper);}

    // get expenses_goal by id
    @Override
    public ExpenseGoal getExpenseGoalById(int id) {return ExpenseGoalSql.getExpenseGoalById(dbHelper, id);}

    // add expense type
    @Override
    public void addExpenseType(ExpenseType expense) {ExpenseTypeSql.addExpenseType(dbHelper, expense);    }

    // delete expense type
    @Override
    public void deleteExpenseType(ExpenseType expense) {ExpenseTypeSql.deleteExpenseType(dbHelper, expense);}

    // get all expense type
    @Override
    public List<ExpenseType> gatAllExpenseType() {return ExpenseTypeSql.gatAllExpenseType(dbHelper); }

    // get All Change expenses type with type 2
    @Override
    public List<ExpenseType> getAllChangeExpenseType() {return ExpenseTypeSql.getAllChangeExpenseType(dbHelper);}

    // get expenses type by id
    @Override
    public ExpenseType getExpenseTypeById(int id) {return ExpenseTypeSql.getExpenseTypeById(dbHelper, id);}

    class MyOpenHelper extends SQLiteOpenHelper {
        final static String dbName = "database.db";
        final static int version = 1;

        public MyOpenHelper(Context context) {
            super(context, dbName, null, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // create income table
            IncomeSql.create(db);

            // create expense table
            ExpenseSql.create(db);

            // create expense goal table
            ExpenseGoalSql.create(db);

            // create expense type table
            ExpenseTypeSql.create(db);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            IncomeSql.drop(db);
            ExpenseSql.drop(db);
            ExpenseGoalSql.drop(db);
            ExpenseTypeSql.drop(db);

            onCreate(db);
        }
    }
}
