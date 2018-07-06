package by.bsu.andrew.customlistdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter {
    Context context;
    ArrayList<Person> array;

    public MyAdapter(@NonNull Context context, ArrayList<Person> array)

    {
        super(context, android.R.layout.simple_list_item_1);
        this.array=array;
        this.context=context;
    }


    @Override
    public int getCount() {
        return array.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        RelativeLayout layout;
        if(convertView==null){
               LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
               layout = (RelativeLayout) inflater.inflate(R.layout.item_layout,null);

            TextView enName = (TextView) layout.findViewById(R.id.textEnglishName);
            TextView cnName = (TextView) layout.findViewById(R.id.textChineseName);
            TextView job = (TextView) layout.findViewById(R.id.textJob);
            ImageView iw = (ImageView) layout.findViewById(R.id.imageView);

            enName.setText(array.get(position).eName);
            cnName.setText(array.get(position).cName);
            job.setText(array.get(position).job);
            iw.setImageResource(array.get(position).imgID);

        }
        else {
            layout = (RelativeLayout) convertView;
        }

        return layout;
    }
}
