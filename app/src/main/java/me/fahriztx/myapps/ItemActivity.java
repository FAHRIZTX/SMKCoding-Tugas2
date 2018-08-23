package me.fahriztx.myapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.r0adkll.slidr.Slidr;

public class ItemActivity extends AppCompatActivity {

    private ImageView image;
    private TextView title,lyric;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        Slidr.attach(this);

        image = findViewById(R.id.imageItem);
        title = findViewById(R.id.title);
        lyric = findViewById(R.id.lyric);


        String judul = getIntent().getStringExtra("title");
        String lirik = getIntent().getStringExtra("lyric");
        int images = getIntent().getIntExtra("image", R.mipmap.ic_launcher);

        getSupportActionBar().setTitle(judul);

        image.setImageResource(images);
        title.setText(judul);
        lyric.setText(lirik);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
