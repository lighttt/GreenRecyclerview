package com.example.greenrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private static final int NUM_LIST_ITEMS = 100;

    private RecyclerView mNumbersList;
    private GreenAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNumbersList = findViewById(R.id.rv_numbers);

        /*
         * A LinearLayoutManager is responsible for measuring and positioning item views within a
         * RecyclerView into a linear list.
           i.e Horizontal or Vertical
         */
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mNumbersList.setLayoutManager(layoutManager);

        // to improve performance of rv
        mNumbersList.setHasFixedSize(true);

        //create adapter for displaying each item in the list:
        mAdapter = new GreenAdapter(NUM_LIST_ITEMS);
        mNumbersList.setAdapter(mAdapter);
    }

    /*
        ----------------------- MENU ----------------------------
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        switch (itemId)
        {
            case R.id.action_refresh:
                mAdapter = new GreenAdapter(NUM_LIST_ITEMS);
                mNumbersList.setAdapter(mAdapter);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
