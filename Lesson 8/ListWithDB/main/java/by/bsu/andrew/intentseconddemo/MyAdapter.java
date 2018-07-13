package by.bsu.andrew.intentseconddemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter {
    Context context;
    ArrayList<Product> array;

    public MyAdapter(@NonNull Context context, ArrayList<Product> array) {
        super(context, android.R.layout.simple_list_item_1);
        this.context=context;
        this.array=array;
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
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = (RelativeLayout) inflater.inflate(R.layout.item_layout,parent,false);
        }
        else{
            layout = (RelativeLayout) convertView;
        }
        TextView tProduct = layout.findViewById(R.id.textProduct);
        TextView tPrice = layout.findViewById(R.id.textPrice);
        TextView tDiscount = layout.findViewById(R.id.textDiscount);

        tProduct.setText(array.get(position).productName);
        tPrice.setText(String.valueOf(array.get(position).price));
        tDiscount.setText(String.valueOf(array.get(position).discount));

        return layout;
    }
}
