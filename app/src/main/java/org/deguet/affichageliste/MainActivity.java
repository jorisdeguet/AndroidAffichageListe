package org.deguet.affichageliste;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CoordinatorLayout coordinatorLayout = findViewById(R.id.coordinator);
        FloatingActionButton fab = findViewById(R.id.superduperbutton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar mySnackbar = Snackbar.make(coordinatorLayout,
                        "coucou", Snackbar.LENGTH_SHORT);
                // mySnackbar.setAction(R.string.undo_string, new MyUndoListener());
                mySnackbar.show();
            }
        });

        recycler = findViewById(R.id.superduperrecycler);
        recycler.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        //layoutManager = new GridLayoutManager(this, 3);
        recycler.setLayoutManager(layoutManager);

        Truc[] elements = new Truc[]{
                new Truc("coucou"),
                new Truc("joris"),
                new Truc("coucou"),
                new Truc("joris"),
                new Truc("coucou"),
                new Truc("joris"),
                new Truc("coucou"),
                new Truc("joris"),
                new Truc("coucou"),
                new Truc("joris"),
                new Truc("coucou"),
                new Truc("joris"),
                new Truc("coucou"),
                new Truc("joris"),
                new Truc("coucou"),
                new Truc("joris"),
                new Truc("coucou"),
                new Truc("joris"),
                new Truc("coucou"),
                new Truc("joris"),
                new Truc("coucou"),
                new Truc("joris"),
                new Truc("coucou"),
                new Truc("joris"),
                new Truc("coucou"),
                new Truc("joris"),
                new Truc("coucou"),
                new Truc("joris"),
                new Truc("coucou"),
                new Truc("joris"),
                new Truc("coucou"),
                new Truc("joris"),
                new Truc("coucou"),
                new Truc("joris")

        };

        // specify an adapter (see also next example)
        adapter = new MonAdapteur(elements, getApplicationContext());
        recycler.setAdapter(adapter);
    }
}
