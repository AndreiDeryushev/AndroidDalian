package by.bsu.andrew.servicedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);

    }

    public void startPlayer(View view) {
        Intent intent = new Intent(this,MyService.class);
        tv.setText("Let's go...");
        startService(intent);
    }

    public void stopPlayer(View view) {
        Intent intent = new Intent(this,MyService.class);
        tv.setText("No more music...");
        stopService(intent);
    }
}
