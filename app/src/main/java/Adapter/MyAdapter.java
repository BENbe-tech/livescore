package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.otondelivescore.DetailsActivity;
import com.example.otondelivescore.R;

import java.util.List;

import Model.ListItem;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private List<ListItem> listItems;


   public MyAdapter(Context context, List listitem){
       this.context = context;
       this.listItems = listitem;
   }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.list_row, parent, false);

       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {

       ListItem item = listItems.get(position);
        holder.name.setText(item.getName());
        if(item.getName() == "England")
        {
            holder.imageView.setImageResource(R.drawable.england);
        }

        if(item.getName() == "Spain")
        {
            holder.imageView.setImageResource(R.drawable.spain);
        }

        if(item.getName() == "Italy")
        {
            holder.imageView.setImageResource(R.drawable.italy);
        }

        if(item.getName() == "Tanzania")
        {
            holder.imageView.setImageResource(R.drawable.tanzania);
        }

        if(item.getName() == "France")
        {
            holder.imageView.setImageResource(R.drawable.france);
        }

        if(item.getName() == "Germany")
        {
            holder.imageView.setImageResource(R.drawable.germany);
        }


        holder.description.setText(item.getDescription());
    }



    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
      public TextView name;
      public TextView description;
      public ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            name = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            imageView = (ImageView)  itemView.findViewById(R.id.imagev);
        }

        @Override
        public void onClick(View v) {
           //Get position of the row clicked
            int position = getAdapterPosition();
            ListItem item =listItems.get(position);
            Intent i = new Intent(context, DetailsActivity.class);
           i.putExtra("name",item.getName());
           i.putExtra("description",item.getDescription());

           context.startActivity(i);

//            Toast.makeText(context, item.getName(),Toast.LENGTH_LONG).show();
        }
    }
}
