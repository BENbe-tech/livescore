package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.otondelivescore.MatchDetails;
import com.example.otondelivescore.R;

import java.util.List;

import Model.ListItem2;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.ViewHolder> {

    private Context context;
    private List<ListItem2> listItems;


    public DetailAdapter(Context context, List listitem){
        this.context = context;
        this.listItems = listitem;
    }


    @NonNull

    @Override
    public DetailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row2, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailAdapter.ViewHolder holder, int position) {
        ListItem2 item = listItems.get(position);
        holder.time.setText(item.getTime());
        holder.team1.setText(item.getTeam1());
        holder.team2.setText(item.getTeam2());
         holder.score1.setText(item.getScore1());
        holder.score2.setText(item.getScore2());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }
        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

            public TextView time;
            public TextView team1;
            public TextView team2;
            public TextView score1;
            public TextView score2;


            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                itemView.setOnClickListener(this);
                time = (TextView) itemView.findViewById(R.id.time);
                team1 = (TextView) itemView.findViewById(R.id.team1);
                team2 = (TextView)  itemView.findViewById(R.id.team2);
                score1 = (TextView)  itemView.findViewById(R.id.score2);
                score2 = (TextView)  itemView.findViewById(R.id.score1);

            }
            @Override
            public void onClick(View v) {

                //Get position of the row clicked
                int position = getAdapterPosition();
                ListItem2 item =listItems.get(position);
                Intent i = new Intent(context, MatchDetails.class);
                i.putExtra("team1",item.getTeam1());
                i.putExtra("team2",item.getTeam2());


                context.startActivity(i);

//            Toast.makeText(context, item.getName(),Toast.LENGTH_LONG).show();


            }
        }
    }

