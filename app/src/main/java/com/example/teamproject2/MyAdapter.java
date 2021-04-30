package com.example.teamproject2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ArrayAdapter implements AdapterView.OnItemClickListener {

    private Context ctx;
    private List list;

    class ViewHolder {
        public TextView txt_name;
        public ImageView img_shelter;
    }

    public MyAdapter(Context context, ArrayList list){
        super(context, 0, list);
        this.ctx = context;
        this.list = list;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(ctx, "clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;

        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
            view = layoutInflater.inflate(R.layout.shelter_list, viewGroup, false);
        }

        viewHolder = new ViewHolder();
        viewHolder.txt_name = (TextView) view.findViewById(R.id.list_name);
        viewHolder.img_shelter = (ImageView) view.findViewById(R.id.list_icon);

        final MyData myData = (MyData) list.get(position);
        viewHolder.txt_name.setText(myData.getName());
        viewHolder.img_shelter.setImageResource(myData.getIcon());
        Glide
                .with(ctx)
                .load(myData.getIcon())
                .centerCrop()
                .apply(new RequestOptions().override(24, 24))
                .into(viewHolder.img_shelter);
        viewHolder.txt_name.setTag(myData.getName());

        return view;
    }
}
