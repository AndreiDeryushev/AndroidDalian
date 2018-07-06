package by.bsu.andrew.customlistdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
implements AdapterView.OnItemLongClickListener
{

    ListView lw;
    ArrayList<Person> array;
    MyAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lw = findViewById(R.id.listVew);
        array = new ArrayList<>();
        array.add(new Person("Joe Smith","Li Ping","teacher",R.drawable.p1));
        array.add(new Person("Abram Word","Lu Yu Ping","director",R.drawable.p2));

        adapter = new MyAdapter(this,array);

        lw.setAdapter(adapter);
        lw.setOnItemLongClickListener(this);

    }

    public void addNew(View view) {
      array.add(new Person("English","Chinese","job",R.drawable.p6));
      adapter.notifyDataSetChanged();

    }


    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        array.remove(i);
        adapter.notifyDataSetChanged();
        return true;
    }
}

//Home task
//Create CustomListView with fields:
// English Name
// Chinese Name
// Age
//subject of study
// phone/WChat_number



