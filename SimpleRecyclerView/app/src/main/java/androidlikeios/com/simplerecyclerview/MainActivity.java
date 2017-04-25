package androidlikeios.com.simplerecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager recylerViewLayoutManager;
    private String[] subjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subjects = new String[] {"Nougat", "Marshmallow", "Lollipop", "KitKat", "Jelly Bean", "Ice Cream Sandwich", "Gingerbread", "Cupcake", "dunut", "eclair", "Froyo", "Gingerbread", "Honeycomb"};

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        recylerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recylerViewLayoutManager);

        recyclerViewAdapter = new SimpleRecyclerViewAdapter(MainActivity.this, subjects);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}