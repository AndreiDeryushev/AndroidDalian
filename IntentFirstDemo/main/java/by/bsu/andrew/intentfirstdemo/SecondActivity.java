package by.bsu.andrew.intentfirstdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    EditText et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        et2 = (EditText) findViewById(R.id.editText2);
        Intent dataIntent = getIntent();
        et2.setText(dataIntent.getStringExtra("mydata"));

    }

    public void goToFirst(View view) {
       finish();
    }
}
