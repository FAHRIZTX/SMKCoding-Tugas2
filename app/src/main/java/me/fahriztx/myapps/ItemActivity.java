package me.fahriztx.myapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemActivity extends AppCompatActivity {

    private ImageView image;
    private TextView title,description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        image = findViewById(R.id.imageItem);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);

        String judul = getIntent().getStringExtra("title");
        String descript = getIntent().getStringExtra("description");
        int images = getIntent().getIntExtra("image", R.mipmap.ic_launcher);

        image.setImageResource(images);
        title.setText(judul);
        description.setText(descript);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
