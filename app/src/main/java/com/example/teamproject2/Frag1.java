package com.example.teamproject2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Frag1 extends Fragment {

    ArrayList<MyData> myData;
    ListView mList;
    private static MyAdapter myAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.frag_1, container, false);

        myData = new ArrayList<>();
        myData.add(new MyData(R.drawable.ic_arrow, "대피소"));
        myData.add(new MyData(R.drawable.ic_arrow, "대피소"));
        myData.add(new MyData(R.drawable.ic_arrow, "대피소"));

        mList = (ListView) rootView.findViewById(R.id.list);
        myAdapter = new MyAdapter(getContext(), myData);
        mList.setAdapter(myAdapter);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                //각 아이템을 분간 할 수 있는 position과 뷰
                String selectedItem = (String) view.findViewById(R.id.list_name).getTag().toString();
                Toast.makeText(getContext(), "Clicked: " + position +" " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }
}