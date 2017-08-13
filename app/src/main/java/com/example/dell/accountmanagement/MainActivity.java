package com.example.dell.accountmanagement;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.dell.accountmanagement.Model.ExpenseType;
import com.example.dell.accountmanagement.Model.Sql.Model;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init table
        Model.instance().init(this);

        // check if expanse type table is empty
        if (Model.instance().gatAllExpenseType().size()==0)
        {
            // fill the expanse type table
            Model.instance().addExpenseType(new ExpenseType(1,"משכנתא", 0));
            Model.instance().addExpenseType(new ExpenseType(2,"ביטוח משכנתא", 0));
            Model.instance().addExpenseType(new ExpenseType(3,"שכר דירה", 0));
            Model.instance().addExpenseType(new ExpenseType(4,"ועד בית", 0));
            Model.instance().addExpenseType(new ExpenseType(5,"ביטוחים", 0));
            Model.instance().addExpenseType(new ExpenseType(6,"הוראות קבע לחיסכון", 0));
            Model.instance().addExpenseType(new ExpenseType(7,"מנויים", 0));
            Model.instance().addExpenseType(new ExpenseType(8,"ארנונה", 0));
            Model.instance().addExpenseType(new ExpenseType(9,"ביטוח רכב + טסט", 0));
            Model.instance().addExpenseType(new ExpenseType(10,"חשמל", 1));
            Model.instance().addExpenseType(new ExpenseType(11,"גז", 1));
            Model.instance().addExpenseType(new ExpenseType(12,"חינוך", 1));
            Model.instance().addExpenseType(new ExpenseType(13,"חוגם וקייטנות ובריכה", 1));
            Model.instance().addExpenseType(new ExpenseType(14,"מים", 1));
            Model.instance().addExpenseType(new ExpenseType(15,"תיקוני רכב", 1));
            Model.instance().addExpenseType(new ExpenseType(16,"ביגוד והנעלה", 1));
            Model.instance().addExpenseType(new ExpenseType(17,"טיפולי שיניים", 1));
            Model.instance().addExpenseType(new ExpenseType(18,"אופטיקה", 1));
            Model.instance().addExpenseType(new ExpenseType(19,"בילוים", 1));
            Model.instance().addExpenseType(new ExpenseType(20,"מתנות לאירועים", 1));
            Model.instance().addExpenseType(new ExpenseType(21,"תספורת וקוסמטיקה", 1));
            Model.instance().addExpenseType(new ExpenseType(22,"מזון", 1));
            Model.instance().addExpenseType(new ExpenseType(23,"תחבורה ציבורית", 1));
            Model.instance().addExpenseType(new ExpenseType(24,"דלק וחניה", 1));
            Model.instance().addExpenseType(new ExpenseType(25,"טלפון", 1));
            Model.instance().addExpenseType(new ExpenseType(26,"עוזרת", 1));
            Model.instance().addExpenseType(new ExpenseType(27,"סיגריות", 1));
        }

        // define fragment
        ManagementFragment managementFragment = new ManagementFragment();
        getFragmentManager().beginTransaction().add(R.id.FragmentsContainerLL, managementFragment).commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
