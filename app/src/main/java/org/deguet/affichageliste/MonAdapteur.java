package org.deguet.affichageliste;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MonAdapteur extends RecyclerView.Adapter<MonAdapteur.MyViewHolder> {
    private Truc[] mDataset;
    private Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tvAA;
        public TextView tvBB;
        public Button btnDelete;

        public MyViewHolder(LinearLayout ll) {
            super(ll);
            tvAA = ll.findViewById(R.id.tvAA);
            tvBB = ll.findViewById(R.id.tvBB);
            btnDelete = ll.findViewById(R.id.btnDelete);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MonAdapteur(Truc[] myDataset, Context ctx) {
        this.mDataset = myDataset;
        this.context = ctx;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MonAdapteur.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        LinearLayout ll = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        MyViewHolder vh = new MyViewHolder(ll);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Truc truc = mDataset[position];
        holder.tvAA.setText(truc.contenu);
        holder.tvBB.setText(truc.date.toString());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Element " + truc.contenu , Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}