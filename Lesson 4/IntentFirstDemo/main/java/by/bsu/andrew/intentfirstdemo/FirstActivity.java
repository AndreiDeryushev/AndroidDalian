package by.bsu.andrew.intentfirstdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {

    EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        et1 = (EditText) findViewById(R.id.editText1);
    }

    public void goToSecond(View view) {
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("mydata",et1.getText().toString());
        startActivity(intent);
    }
}
