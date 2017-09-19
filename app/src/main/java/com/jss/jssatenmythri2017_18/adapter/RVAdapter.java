package com.jss.jssatenmythri2017_18.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.jss.jssatenmythri2017_18.R;
import com.jss.jssatenmythri2017_18.activity.coordinator.WinnerUpdate;
import com.jss.jssatenmythri2017_18.helper.Team_Info;

import java.util.List;

/**
 * Created by Ansh on 10/6/2016.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.FixturesViewHolder> {


    public List<Team_Info> teamInfos;
    Context context;

    public RVAdapter(List<Team_Info> teamsInfos, Context context){
        this.teamInfos = teamsInfos;
        this.context = context;
    }

    @Override
    public FixturesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_card_view,parent,false);
        FixturesViewHolder fixturesViewHolder = new FixturesViewHolder(v);
        return  fixturesViewHolder;
    }

    @Override
    public void onBindViewHolder(FixturesViewHolder holder, final int position) {

        holder.team_one.setText(teamInfos.get(position).team_one_name);
        holder.team_two.setText(teamInfos.get(position).team_two_name);

        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WinnerUpdate.class);
                intent.putExtra("team1",teamInfos.get(position).team_one_name);
                intent.putExtra("team2",teamInfos.get(position).team_two_name);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return teamInfos.size();
    }

    public static class FixturesViewHolder extends  RecyclerView.ViewHolder{

        CardView cv;
        TextView team_one;
        TextView team_two;

        FixturesViewHolder(View itemView){
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            team_one = (TextView)itemView.findViewById(R.id.team1);
            team_two = (TextView)itemView.findViewById(R.id.team2);


        }

    }

}
