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

import com.squareup.otto.Subscribe;

import org.deguet.affichageliste.evts.SuppressionTruc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private Random random = new Random();
    public List<Truc> elements = new ArrayList<>();

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
                //mySnackbar.show();
                String contenu = "truc " + random.nextInt(100);
                Truc nouveauTruc = new Truc(contenu);
                elements.add(nouveauTruc);
                adapter.notifyDataSetChanged();
            }
        });

        recycler = findViewById(R.id.superduperrecycler);
        recycler.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        //layoutManager = new GridLayoutManager(this, 3);
        recycler.setLayoutManager(layoutManager);

        elements.add(new Truc("coucou"));
        elements.add(new Truc("salut"));

        // specify an adapter (see also next example)
        adapter = new MonAdapteur(elements, getApplicationContext());
        recycler.setAdapter(adapter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MonBus.bus.unregister(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MonBus.bus.register(this);
    }

    @Subscribe
    public void superduper(SuppressionTruc suppr) {
        //Toast.makeText(this, "Suppression " + suppr.elementSupprime.contenu, Toast.LENGTH_SHORT).show();
        elements.remove(suppr.elementSupprime);
        adapter.notifyDataSetChanged();
    }

}
