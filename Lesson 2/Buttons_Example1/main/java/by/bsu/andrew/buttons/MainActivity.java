package by.bsu.andrew.buttons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tw = (TextView) findViewById(R.id.textView);

    }

    public void Btn1Click(View view) {
        tw.setText("Button1 pressed");
    }

    public void Btn2Click(View view) {
        tw.setText("Button2 pressed");
    }
}
