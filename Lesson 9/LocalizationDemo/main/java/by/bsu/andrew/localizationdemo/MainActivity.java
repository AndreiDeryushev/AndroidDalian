package by.bsu.andrew.localizationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et;
    TextView tv;
    String hello;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
        et = findViewById(R.id.editText);
        hello = getResources().getString(R.string.hello_string);

    }

    public void sayHello(View view) {
       tv.setText(hello+et.getText().toString());
    }
}
