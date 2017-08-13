package com.example.dell.accountmanagement;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.accountmanagement.Model.Expense;
import com.example.dell.accountmanagement.Model.ExpenseType;
import com.example.dell.accountmanagement.Model.Sql.Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class AddExpanseFragment extends Fragment {

    Spinner AllTypeExpansesSpinner, AllMethodsOfPaymenSpinner;
    TextView MethodsOfPaymentTV;
    EditText dayInMonthET, amountET ,descrepionET;
    Button addBtn;
    int dayInMonth;
    double amount;
    String descrepion;
    ArrayAdapter<ExpenseType> allExpensesTypeAdapter;
    ArrayAdapter<String> allMethodsOfPaymentAdapter;

    // defulet c'tor
    public AddExpanseFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        myCalendar = Calendar.getInstance();
//        date= new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                // TODO Auto-generated method stub
//                myCalendar.set(Calendar.YEAR, year);
//                myCalendar.set(Calendar.MONTH, monthOfYear);
//                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//                updateLabel();
//            }
//        };
//        dayInMonthET.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                new DatePickerDialog(getActivity(), date, myCalendar
//                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH))
//                        .show();
//            }
//        });
//    private void updateLabel() {
//            String myFormat = "dd/MM/yy"; //In which you need put here
//            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
//
//            dayInMonthET.setText(sdf.format(myCalendar.getTime()));
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_expanse, container, false);


        AllTypeExpansesSpinner = (Spinner) view.findViewById(R.id.listAllexpanseTypeSpinner);
        addItemsOnAllTypeExpansesSpinner();

        AllMethodsOfPaymenSpinner = (Spinner) view.findViewById(R.id.MethodsOfPaymentSpinner);
        addItemsOnAllMethodsOfPaymenSpinner();


        dayInMonthET = (EditText) view.findViewById(R.id.dayInMonthET);
        amountET = (EditText) view.findViewById(R.id.amountET);
        descrepionET = (EditText) view.findViewById(R.id.descrepionET);
        addBtn = (Button) view.findViewById(R.id.addBtn);

        // when you lik on add button
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //String ExpanseTyprSelected = String.valueOf(AllTypeExpansesSpinner.getSelectedItem());

                // get all date that user insert
                String MethodsOfPaymentSelected = String.valueOf(AllMethodsOfPaymenSpinner.getSelectedItem());
                dayInMonth = Integer.parseInt(dayInMonthET.getText().toString());
                amount = Integer.parseInt(amountET.getText().toString());
                descrepion = (descrepionET.getText().toString());

                // check if the day is valid between 1-31
                if (dayInMonth < 1 || dayInMonth> 31)
                {
                    Toast.makeText(getActivity(), "אתה חייב להכניס תאריך בין 1 ל31", Toast.LENGTH_SHORT).show();
                }

                // check if the amount is valid more then 0
                if (amount<1)
                {
                    Toast.makeText(getActivity(), "אתה חייב להכניס סכום הגדול מאפס", Toast.LENGTH_SHORT).show();
                }

                //create expanse and insert it to expanse table
                Expense expense = new Expense(AllTypeExpansesSpinner.getId(), String.valueOf(dayInMonth), 0 , MethodsOfPaymentSelected, amount, descrepion);
                Model.instance().addExpense(expense);

                //TODO: close the fragment
            }
        });
        return view;
    }


    // add items into allTypeExpanses spinner
    public void addItemsOnAllTypeExpansesSpinner()
    {
        // Get all type expenses from DB
        List<ExpenseType> allTypeExpanses = Model.instance().gatAllExpenseType();

        // Add this list to adapter
        allExpensesTypeAdapter = new ArrayAdapter<ExpenseType>(getActivity(), android.R.layout.simple_spinner_item, allTypeExpanses);
        allExpensesTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        AllTypeExpansesSpinner.setAdapter(allExpensesTypeAdapter);
    }

    // add items into allTypeExpanses spinner
    public void addItemsOnAllMethodsOfPaymenSpinner()
    {
        // create list whit all Methods Of Payment
        List<String> allMethodsOfPaymentList = new ArrayList<String>();
        allMethodsOfPaymentList.add("מזומן");
        allMethodsOfPaymentList.add("כרטיס אשראי");
        allMethodsOfPaymentList.add("שיק");
        allMethodsOfPaymentList.add("הוראת קבע");

        // Add this list to adapter
        allMethodsOfPaymentAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, allMethodsOfPaymentList);
        allMethodsOfPaymentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        AllMethodsOfPaymenSpinner.setAdapter(allMethodsOfPaymentAdapter);
    }
};






