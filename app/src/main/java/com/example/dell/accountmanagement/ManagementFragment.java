package com.example.dell.accountmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.accountmanagement.Model.Expense;
import com.example.dell.accountmanagement.Model.Income;
import com.example.dell.accountmanagement.Model.MonthManagment;
import com.example.dell.accountmanagement.Model.Sql.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagementFragment extends Fragment
{

    private List<MonthManagment> allMonthManagement;
    private Map<Integer, String> allMonth;
    LinearLayoutManager myLayoutManager;
    int sumAllExpanses=0;

    // defolt constractor
    public ManagementFragment()
    {
        // Required empty public constructor
    }

    // enter all month to 'hasMap'
    private void initAllMonth()
    {
        allMonth = new HashMap<>();
        allMonth.put(1,"ינואר");
        allMonth.put(2,"פברואר");
        allMonth.put(3,"מרץ");
        allMonth.put(4,"אפריל");
        allMonth.put(5,"מאי");
        allMonth.put(6,"יוני");
        allMonth.put(7,"יולי");
        allMonth.put(8,"אוגוסט");
        allMonth.put(9,"ספטמבר");
        allMonth.put(10,"אוקטובר");
        allMonth.put(11,"נובמבר");
        allMonth.put(12,"דצמבר");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_managment, container, false);

        // when you clicked on "Setting Budget For Expanses" Button
        ((Button)view.findViewById(R.id.SettingBudgetForExpansesBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SettingBudgetForExpansesActivity.class);
                startActivity(intent);
            }
        });
        // Init all month list
        this.initAllMonth();

        // Init allMonthManagement list
        allMonthManagement = new ArrayList<>();

        // Get all const incomes
        List<Income> allConstIncomes = Model.instance().getAllConstIncome();
        int sumOfConstIncomesAmounts = 0;

        // Calculate sum of all amount
        if (allConstIncomes != null & !allConstIncomes.isEmpty()) {
            for (Income income : allConstIncomes) {
                sumOfConstIncomesAmounts += income.getAmount();
            }
        }

        // Get current month
        int currentMonth = new Date().getMonth() + 1;
        int sumAllIncomesByMonth = sumOfConstIncomesAmounts;

        // Run all 12 month before current month
        int count = 12;
        while (count > 0)
        {
            // Get all incomes of this month
            List<Income> allOneTimeIncomes = Model.instance().getOneTimeIncomesByDate(currentMonth);

            // Calculate sum of all amount + const income
            if (allOneTimeIncomes != null & !allOneTimeIncomes.isEmpty()) {
                for (Income income : allOneTimeIncomes) {
                    sumAllIncomesByMonth += income.getAmount();
                }
            }

            // Get all expense of this month
            List<Expense> allExpanses = Model.instance().getAllChangeExpense();

            // Calculate sum of all expense
            if (allExpanses != null && !allExpanses.isEmpty()) {
                for (Expense expense : allExpanses) {
                    sumAllExpanses += expense.getAmount();
                }
            }

            int deviation = sumAllIncomesByMonth - sumAllExpanses;

            // Add this income and expense and deviation to allMontManagement
            allMonthManagement.add(new MonthManagment(sumAllIncomesByMonth ,
                    sumAllExpanses , deviation, currentMonth));

            // get next month
            if (currentMonth == 1)
            {
                currentMonth = 12;
            }
            else
            {
                currentMonth--;
            }

            sumAllIncomesByMonth = sumOfConstIncomesAmounts;
            count--;
        }

        // create adapter and connect to list view
        CustomAdapter adapter = new CustomAdapter();
        ListView listView = (ListView) view.findViewById(R.id.allMonthManagementLV);
        listView.setAdapter(adapter);

        // when you click on one item in the list
        final int finalSumAllIncomesByMonth = sumAllIncomesByMonth;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ManagmentPerMonthActivity.class);
                intent.putExtra("id", id);
                intent.putExtra("SumAllIncomes", finalSumAllIncomesByMonth);
                intent.putExtra("SumAllExpanse", sumAllExpanses);
                startActivity(intent);

            }
        });
        return view;
    }

    // create class CustomAdapter
    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return allMonthManagement.size();
        }

        @Override
        public Object getItem(int position) {
            return allMonthManagement.get(position);
        }

        @Override
        public long getItemId(int position) {
            return allMonthManagement.get(position).getMonth();
        }

        //insert all detailes to list
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = getActivity().getLayoutInflater();
                convertView = inflater.inflate(R.layout.one_month_item, null);
            }


            TextView month = (TextView) convertView.findViewById(R.id.monthTV);
            TextView income = (TextView) convertView.findViewById(R.id.incomeTV);
            TextView expense = (TextView) convertView.findViewById(R.id.expenseTV);
            TextView deviation = (TextView) convertView.findViewById(R.id.deviationTV);

            // get all properties from Month management object
            MonthManagment monthManagment = allMonthManagement.get(position);
            month.setText("   חודש     "+allMonth.get(monthManagment.getMonth()));
            income.setText(" הכנסות: "+String.valueOf(monthManagment.getSumIncomes()));
            expense.setText(" הוצאות: "+String.valueOf(monthManagment.getSumExpanses()));
            deviation.setText("חריגה/עודף: "+String.valueOf(monthManagment.getDeviation()));

            return convertView;
        }
    }


}
