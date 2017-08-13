package com.example.dell.accountmanagement.Model.Sql;
import android.content.Context;

import com.example.dell.accountmanagement.Model.Expense;
import com.example.dell.accountmanagement.Model.ExpenseGoal;
import com.example.dell.accountmanagement.Model.ExpenseType;
import com.example.dell.accountmanagement.Model.Income;

import java.util.List;

/**
 * Created by Dell on 24/06/2017.
 */
public class Model
{
    interface ModelInterface
    {
        // add income
        public void addIncome(Income income);

        // delete income
        public void deleteIncome(Income income);

        // get all incomes that not one time
        public List<Income> getAllConstIncome();

        // get all one time income by date
        public List<Income> getOneTimeIncomesByDate(int month);

        // Get all incomes
        public List<Income> getAllIncomes ();

        // get incom by id
        public Income getNameById (int id);

        // add expense
        public void addExpense(Expense expense);

        // delete expense
        public void deleteExpense(Expense expense);

        // get all expenses
        public List<Expense> gatAllExpense();

        // get all Expenses by type
        public List<Expense> getAllExpenseByType(int type);

        // get All Change Expense with type 2
        public List<Expense> getAllChangeExpense();

        // get expense by id
        public Expense getExpenseById(int id);

        // add expense_goal
        public void addExpenseGoal(ExpenseGoal expense) ;

        // delete expense_goal
        public void deleteExpenseGoal(ExpenseGoal expense) ;

        // get all expenses goal
        public List<ExpenseGoal> gatAllExpenseGoal() ;

        // get all expenses_goal by type
        public List<ExpenseGoal> getAllExpenseGoalByType(int type) ;

        // get All Change expenses_goal with type 2
        public List<ExpenseGoal> getAllChangeExpenseGoal();

        // get expenses_goal by id
        public ExpenseGoal getExpenseGoalById (int id);

        // add expense type
        public void addExpenseType(ExpenseType expense) ;

        // delete expense type
        public void deleteExpenseType(ExpenseType expense) ;

        // get all expense type
        public List<ExpenseType> gatAllExpenseType() ;

        // get All Change expense type with type 2
        public List<ExpenseType> getAllChangeExpenseType();

        // get expense type by id
        public ExpenseType getExpenseTypeById (int id);
    }

    private static final Model instance = new Model();
    private ModelInterface modelImpl;

    private Model(){

    }

    public void init(Context applicationContext) {
        modelImpl = new ModelSql(applicationContext);
    }

    public static Model instance(){
        return instance;
    }

    // add income
    public void addIncome(Income income)
    {
        modelImpl.addIncome(income);
    }

    // delete income
    public void deleteIncome(Income income)
    {
        modelImpl.deleteIncome(income);
    }

    // get all incomes that not one time
    public List<Income> getAllConstIncome()
    {
        return modelImpl.getAllConstIncome();
    }

    // get all one time income by date
    public List<Income> getOneTimeIncomesByDate(int month) {
        return modelImpl.getOneTimeIncomesByDate(month);
    }

    // Get all incomes
    public List<Income> getAllIncomes ()
    {
        return modelImpl.getAllIncomes();
    }

    public Income getNameById (int id)
    {
        return modelImpl.getNameById(id);
    }

    // add expense
    public void addExpense(Expense expense){
        modelImpl.addExpense(expense);
    };

    // delete expense
    public void deleteExpense(Expense expense)
    {
        modelImpl.deleteExpense(expense);
    }

    // get all expenses
    public List<Expense> gatAllExpense()
    {
        return modelImpl.gatAllExpense();
    }

    // get all Expenses by type
    public List<Expense> getAllExpenseByType(int type) {return modelImpl.getAllExpenseByType(type);}

    // get All Change Expense with type 2
    public List<Expense> getAllChangeExpense() {return modelImpl.getAllChangeExpense();}

    // get expense by id
    public Expense getExpenseById(int id){return modelImpl.getExpenseById(id);}

    // add expense goal
    public void addExpenseGoal(ExpenseGoal expense) {
        modelImpl.addExpenseGoal(expense);
    };

    // delete expense goal
    public void deleteExpenseGoal(ExpenseGoal expense)
    {
        modelImpl.deleteExpenseGoal(expense);
    }

    // get all expenses goal
    public List<ExpenseGoal> gatAllExpenseGoal()
    {
        return modelImpl.gatAllExpenseGoal();
    }

    // get all expenses goal by type
    public List<ExpenseGoal> getAllExpenseGoalByType(int type) {return modelImpl.getAllExpenseGoalByType(type);}

    // get All Change expenses goal with type 2
    public List<ExpenseGoal> getAllChangeExpenseGoal() {return modelImpl.getAllChangeExpenseGoal();}

    // get expenses goal by id
    public ExpenseGoal getExpenseGoalById (int id){return modelImpl.getExpenseGoalById(id);}

    // add expense type
    public void addExpenseType(ExpenseType expense) {
        modelImpl.addExpenseType(expense);
    };

    // delete expense type
    public void deleteExpenseType(ExpenseType expense)
    {
        modelImpl.deleteExpenseType(expense);
    }

    // get all expenses type
    public List<ExpenseType> gatAllExpenseType()
    {
        return modelImpl.gatAllExpenseType();
    }

    // get All Change expenses type with type 2
    public List<ExpenseType> getAllChangeExpenseType() {return modelImpl.getAllChangeExpenseType();}

    // get expenses type by id
    public ExpenseType getExpenseTypeById (int id){return modelImpl.getExpenseTypeById(id);}

}
