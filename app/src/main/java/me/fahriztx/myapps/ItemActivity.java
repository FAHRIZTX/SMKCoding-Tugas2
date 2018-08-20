package me.fahriztx.myapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

public class ItemActivity extends AppCompatActivity {

    private ImageView image;
    private TextView title,description;
    private SlidrInterface slidr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        slidr = Slidr.attach(this);

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
