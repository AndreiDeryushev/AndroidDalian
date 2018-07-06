package by.bsu.andrew.simplelistdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
implements AdapterView.OnItemLongClickListener
{

    ArrayList<String> array;
    ArrayAdapter adapter;
    ListView lw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        array = new ArrayList<>();
        array.add("John Smith");
        array.add("Andrew Rubin");
        array.add("Lin Na");
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,array);
        lw = findViewById(R.id.listView);
        lw.setAdapter(adapter);

        lw.setOnItemLongClickListener(this);

    }

    public void addNewItem(View view) {
        array.add("Smb. new");
        adapter.notifyDataSetChanged();
    }


    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        array.remove(i);
        adapter.notifyDataSetChanged();
        return true;
    }
}
