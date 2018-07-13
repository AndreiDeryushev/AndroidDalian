package by.bsu.andrew.intentseconddemo;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
implements AdapterView.OnItemLongClickListener
{
    ArrayList<Product> array;
    MyAdapter adapter;
    ListView lw;
    public static final int INPUT_CODE=6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lw = findViewById(R.id.listView);
        array = new ArrayList<>();
//        array.add(new Product("Phone",999,20));
//        array.add(new Product("Notebook",3999,25));

        MyDBHelper myHelper = new MyDBHelper(this);
        SQLiteDatabase db = myHelper.getReadableDatabase();
        String[] fields = new String[]{"name","price","discount"};
        String selection = "price>?";
        String[] selectionArgs = new String[]{"0"};
        //SELECT NAME,PRICE,DISCOUNT FROM PRODUCTS WHERE PRICE>0
        Cursor c = db.query("products",fields,selection,selectionArgs,
                null,null,null);
        c.moveToFirst();
        while(!c.isAfterLast()){
          String pname = c.getString(c.getColumnIndex("name"));
          Double pprice = c.getDouble(c.getColumnIndex("price"));
          Double pdiscount = c.getDouble(c.getColumnIndex("discount"));
          array.add(new Product(pname,pprice,pdiscount));
          c.moveToNext();
        }
        c.close();
        myHelper.close();

        adapter = new MyAdapter(this,array);
        lw.setAdapter(adapter);
        lw.setOnItemLongClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==INPUT_CODE && resultCode==RESULT_OK){
            String newProduct = data.getStringExtra("pname");
            double newPrice = data.getDoubleExtra("pprice",0);
            double newDiscount = data.getDoubleExtra("pdiscount",0);
            array.add(new Product(newProduct,newPrice,newDiscount));
            adapter.notifyDataSetChanged();

            MyDBHelper myHelper = new MyDBHelper(this);
            SQLiteDatabase db = myHelper.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("name",newProduct);
            cv.put("price",newPrice);
            cv.put("discount",newDiscount);
            db.insert("products",null,cv);

            myHelper.close();
        }
    }

    public void addProduct(View view) {
        Intent intent = new Intent(this,InputActivity.class);
        startActivityForResult(intent,INPUT_CODE);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        MyDBHelper myHelper = new MyDBHelper(this);
        SQLiteDatabase db = myHelper.getWritableDatabase();
        String whereClause = "name like ?";
        String[] whereArgs = new String[]{array.get(position).productName};
        db.delete("products",whereClause,whereArgs);


        array.remove(position);
        adapter.notifyDataSetChanged();
        return true;
    }
}
