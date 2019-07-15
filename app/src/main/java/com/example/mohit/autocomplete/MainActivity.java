package com.example.mohit.autocomplete;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private AutoCompleteTextView auto;
    private MultiAutoCompleteTextView multi;
    private Spinner ssp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auto = findViewById(R.id.actv1);
        //pick the values of list of string and put it in str
        auto.setThreshold(1);
        String[] str=getResources().getStringArray(R.array.names);
        //this is arrayadapter which accepts 3 parameter:  this means class, layout is of activity, and array of string
        //it is a container which contains data
        ArrayAdapter apdt = new ArrayAdapter(this , android.R.layout.simple_list_item_1, str);
        auto.setAdapter(apdt);

        //MultiAutoComplete
        multi=findViewById(R.id.mactv);
        String[] str1=getResources().getStringArray(R.array.names);
        ArrayAdapter aap=new ArrayAdapter(this, android.R.layout.simple_list_item_1,str1);
        //multi.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        multi.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        multi.setAdapter(aap);

        //Spinner Example
        ssp=findViewById(R.id.spin);
        String[] str2={"mohit","jatin","ekansh","mukul","sandeep","rohan"};
        ArrayAdapter aapt=new ArrayAdapter(this, android.R.layout.simple_list_item_1,str2);
        ssp.setAdapter(aapt);
        ssp.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = ((TextView) view).getText().toString();//the selected item is converted to string
        Toast.makeText(MainActivity.this, "Selected item is " + item, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
