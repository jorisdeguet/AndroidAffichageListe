package org.deguet.affichageliste;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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
    }
}
