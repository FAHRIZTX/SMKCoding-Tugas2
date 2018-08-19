package me.fahriztx.myapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private List<ItemModel> itemModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        itemModelList = new ArrayList<>();

        itemModelList.add(new ItemModel("Android Debug", "Dndroid Debug adalah suatu proses dimana android anda akan debug", R.mipmap.image_1));
        itemModelList.add(new ItemModel("Play Protect", "Play Protect adalah suatu keamanan yang dibuat oleh google yang di implementasikan didalam aplikasi Play Store", R.mipmap.image_2));
        itemModelList.add(new ItemModel("Fingerprint", "Fingerprint adalah apalaha gatau.", R.mipmap.image_3));
        itemModelList.add(new ItemModel("Lorem Ipsum 1", "Lorem Ipsum 1 adalah Lorem Ipsum dolor sit amit", R.mipmap.image_2));
        itemModelList.add(new ItemModel("Lorem Ipsum 2", "Lorem Ipsum 2 adalah Lorem Ipsum dolor sit amit", R.mipmap.image_3));
        itemModelList.add(new ItemModel("Lorem Ipsum 3", "Lorem Ipsum 3 adalah Lorem Ipsum dolor sit amit", R.mipmap.image_1));
        itemModelList.add(new ItemModel("Lorem Ipsum 4", "Lorem Ipsum 4 adalah Lorem Ipsum dolor sit amit", R.mipmap.image_2));
        itemModelList.add(new ItemModel("Lorem Ipsum 5", "Lorem Ipsum 5 adalah Lorem Ipsum dolor sit amit", R.mipmap.image_3));
        itemModelList.add(new ItemModel("Lorem Ipsum 6", "Lorem Ipsum 6 adalah Lorem Ipsum dolor sit amit", R.mipmap.image_1));
        itemModelList.add(new ItemModel("Lorem Ipsum 7", "Lorem Ipsum 7 adalah Lorem Ipsum dolor sit amit", R.mipmap.image_3));

        recyclerAdapter = new RecyclerAdapter(itemModelList, new RecyclerAdapter.OnImageClickListener() {
            @Override
            public void onClickImage(ItemModel model) {
                Intent intent = new Intent(MainActivity.this, ItemActivity.class);
                intent.putExtra("image", model.getImage());
                intent.putExtra("title", model.getTitle());
                intent.putExtra("description", model.getDescription());
                startActivity(intent);
            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);
    }
}