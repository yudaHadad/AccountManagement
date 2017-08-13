package com.example.dell.accountmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dell.accountmanagement.Model.OneMonthManagment;

import java.util.ArrayList;
import java.util.List;

public class ManagmentPerMonthActivity extends AppCompatActivity {

    // TODO: write management
    TextView managmentMontTV;
    TextView allIncomesPerMonthTV;
    TextView allExpansesPerMonthTV;
    Button addOneTimeIncomeBtn;

    // TODO: write management
    ListView managmentMontLV;
    ImageButton AddExpanseBtn;
    private List<OneMonthManagment> oneMonthManagement;
    LinearLayoutManager myLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_managment_per_month);

        // Init oneMonthManagement list
        oneMonthManagement = new ArrayList<>();

        //get the details from intent by kay
        Intent intent = getIntent();

        // get the details from the fragmet by intent
        int currentMonth = (int) intent.getLongExtra("id", 0);
        int allIncomes = intent.getIntExtra("SumAllIncomes", 0);
        int allExpanses = intent.getIntExtra("SumAllExpanse", 0);

        managmentMontTV = (TextView) findViewById(R.id.managmentMontTV);
        // TODO: month need to be string
        managmentMontTV.setText( "דוח חודש: "+ currentMonth);

        allIncomesPerMonthTV = (TextView) findViewById(R.id.allIncomesPerMonthTV);
        allIncomesPerMonthTV.setText( "סך הכנסות לחודש זה: "+ allIncomes);

        allExpansesPerMonthTV = (TextView) findViewById(R.id.allExpansesPerMonthTV);
        allExpansesPerMonthTV.setText( "סך הוצאות לחודש זה: "+ allExpanses);

        addOneTimeIncomeBtn = (Button) findViewById(R.id.addOneTimeIncomeBtn);

        // when you clicked on add button
        addOneTimeIncomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO:
            }
        });

        AddExpanseBtn = (ImageButton) findViewById(R.id.AddExpanseBtn);
        AddExpanseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // define fragment
                AddExpanseFragment addExpanseFragment = new AddExpanseFragment();
                getFragmentManager()
                        .beginTransaction()
                        .add(R.id.FragmentAddLL, addExpanseFragment)
                        .commit();
            }
        });
    }

//    class CustomAdapter extends BaseAdapter {
//
//        @Override
//        public int getCount() {
//            return oneMonthManagement.size();
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return oneMonthManagement.get(position);
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return oneMonthManagement.get(position);
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            if (convertView == null) {
//                LayoutInflater inflater = getActivity().getLayoutInflater();
//                convertView = inflater.inflate(R.layout.sec_month_item, null);
//            }
//
//            TextView month = (TextView) convertView.findViewById(R.id.monthTV);
//            TextView income = (TextView) convertView.findViewById(R.id.incomeTV);
//            TextView expense = (TextView) convertView.findViewById(R.id.expenseTV);
//            TextView deviation = (TextView) convertView.findViewById(R.id.deviationTV);
//
//            // Get all properties from Month management object
//            MonthManagment monthManagment = allMonthManagement.get(position);
//            month.setText("   חודש     "+allMonth.get(monthManagment.getMonth()));
//            income.setText(" הכנסות: "+String.valueOf(monthManagment.getSumIncomes()));
//            expense.setText(" הוצאות: "+String.valueOf(monthManagment.getSumExpanses()));
//            deviation.setText("חריגה/עודף: "+String.valueOf(monthManagment.getDeviation()));
//
//            return convertView;
//        }
    }


