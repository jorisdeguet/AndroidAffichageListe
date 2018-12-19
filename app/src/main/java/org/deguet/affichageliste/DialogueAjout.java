package org.deguet.affichageliste;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.deguet.affichageliste.evts.AjoutTruc;

public class DialogueAjout extends DialogFragment {

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        View view = inflater.inflate(R.layout.dialog_ajout, null);
        final EditText contenu = view.findViewById(R.id.contenu);
        

        builder.setView(view);
                // Add action buttons
        builder.setPositiveButton(R.string.ajout, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        AjoutTruc ajout = new AjoutTruc();
                        ajout.contenu = contenu.getText().toString();
                        MonBus.bus.post(ajout);
//                        Toast.makeText(getContext(), "Yo "+ contenu.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(R.string.annuler, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        DialogueAjout.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
}
