package com.example.otondelivescore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyAdapter;
import Model.ListItem;

import static com.example.otondelivescore.R.id.reciclerViewID;

public class MainActivity extends AppCompatActivity {

     private RecyclerView recyclerView;
     private RecyclerView.Adapter adapter;
     private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       recyclerView = (RecyclerView) findViewById(reciclerViewID);
       recyclerView.setHasFixedSize(true);
       recyclerView.setLayoutManager(new LinearLayoutManager(this));

       listItems = new ArrayList<>();
       ListItem item1 = new ListItem("England","Premier League");
       ListItem item2 = new ListItem("Spain","La Liga");
       ListItem item3 = new ListItem("Italy","Seria A");
       ListItem item4 = new ListItem("Germany","Bundesliga");
       ListItem item5 = new ListItem("France","Ligue1");
       ListItem item6 = new ListItem("Champions League","UEFA");
       ListItem item7 = new ListItem("Europa League", "EUROPA");
       ListItem item8 = new ListItem("UEFA Nations League","2021/2022");
       ListItem item9 = new ListItem("Euro","2021");
       ListItem item10 = new ListItem("World Cup", "2022");
       ListItem item11 = new ListItem("Tanzania", "VPL");

//       for(int i = 0; i< 10; i++){
//           ListItem item = new ListItem(
//               "Item" + (i+1),
//               "Description"
//           );
        listItems.add(item1);
        listItems.add(item2);
        listItems.add(item3);
        listItems.add(item4);
        listItems.add(item5);
        listItems.add(item6);
        listItems.add(item7);
        listItems.add(item8);
        listItems.add(item9);
        listItems.add(item10);
        listItems.add(item11);

//       }
       adapter = new MyAdapter(this, listItems);
       recyclerView.setAdapter(adapter);
    }
}