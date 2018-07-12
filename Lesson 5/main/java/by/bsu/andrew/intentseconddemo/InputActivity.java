package by.bsu.andrew.intentseconddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {

    EditText inputProduct,inputPrice,inputDiscount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        inputProduct = findViewById(R.id.editProduct);
        inputPrice = findViewById(R.id.editPrice);
        inputDiscount = findViewById(R.id.editDiscount);
    }

    public void submit(View view) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("pname",inputProduct.getText().toString());
        returnIntent.putExtra("pprice",Double.valueOf(inputPrice.getText().toString()));
        returnIntent.putExtra("pdiscount",Double.valueOf(inputDiscount.getText().toString()));
        setResult(RESULT_OK,returnIntent);
        finish();
    }
}
