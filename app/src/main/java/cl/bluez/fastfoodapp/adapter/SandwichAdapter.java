package cl.bluez.fastfoodapp.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import cl.bluez.fastfoodapp.Activity.SandwichDetailActivity;
import cl.bluez.fastfoodapp.R;
import cl.bluez.fastfoodapp.model.Sandwich;

public class SandwichAdapter extends RecyclerView.Adapter<SandwichAdapter.SandwichViewHolder> {

    private ArrayList<Sandwich> data;
    private Activity mActivity;

    public SandwichAdapter(ArrayList<Sandwich> data, Activity mActivity){
        this.data = data;
        this.mActivity = mActivity;
    }

    @Override
    public SandwichViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SandwichViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sandwich, parent, false));
    }

    @Override
    public void onBindViewHolder(SandwichAdapter.SandwichViewHolder holder, int position) {
        Sandwich sandwich = data.get(position);

        holder.image.setImageResource(sandwich.getImage());
        holder.tv_name.setText(sandwich.getName());
        holder.tv_cost.setText(sandwich.getCost()+"$");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class SandwichViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView tv_name;
        TextView tv_cost;
        CardView cardView;


        public SandwichViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.iv_sandwich);
            tv_name = (TextView) itemView.findViewById(R.id.tv_sandwich_title);
            tv_cost = (TextView) itemView.findViewById(R.id.tv_cost);
            cardView = (CardView) itemView.findViewById(R.id.cv_sandwich);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // get position
                    int pos = getAdapterPosition();

                    // check if item still exists
                    if(pos != RecyclerView.NO_POSITION){
                        Sandwich sandwich = data.get(pos);
                        Intent i = new Intent(v.getContext(), SandwichDetailActivity.class);
                        Bundle b = new Bundle();
                        b.putSerializable("sandwich", (Serializable) sandwich);
                        i.putExtras(b);

                        v.getContext().startActivity(i);
                        mActivity.overridePendingTransition(R.anim.slide_in_down,R.anim.quiet);

                    }
                }
            });

        }
    }
}
