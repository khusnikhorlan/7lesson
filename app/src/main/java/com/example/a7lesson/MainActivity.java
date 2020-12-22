package com.example.a7lesson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    foodlistadapter FoodListAdapter;
    ArrayList<food> foodlist;
    private RecyclerView.LayoutManager linearLayoutManager,gridLayoutManager;

    Button btnchange;
    boolean layoutType = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        btnchange = findViewById(R.id.btnchange);
        foodlist= new ArrayList<>();

        foodlist.add(new food(R.drawable.cake,"Фрутовый торт1", "Tort1", 5000));
        foodlist.add(new food(R.drawable.cake,"Фрутовый торт2", "Tort2", 6000));
        foodlist.add(new food(R.drawable.cake,"Фрутовый торт3", "Tort3", 7000));

        FoodListAdapter = new foodlistadapter(this,foodlist);

        linearLayoutManager = new LinearLayoutManager(this);
        gridLayoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(FoodListAdapter);

        btnchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutType = !layoutType;

                if (layoutType) {
                    recyclerView.setLayoutManager(gridLayoutManager);
                    foodlist.remove(0);

                } else {
                    recyclerView.setLayoutManager(linearLayoutManager);

                }
                FoodListAdapter.notifyDataSetChanged();
            }

        });
    }

    public void initViews(){
        
    }
}
