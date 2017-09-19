package com.jss.jssatenmythri2017_18.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jss.jssatenmythri2017_18.R;
import com.jss.jssatenmythri2017_18.util.Teamname_getter_setter;

import java.util.ArrayList;

/**
 * Created by user1 on 05-Oct-16.
 */
public class Teammember_Adapter extends RecyclerView.Adapter<Teammember_Adapter.Teamholder> {
    Context context;
    ArrayList<Teamname_getter_setter> Teamname=new ArrayList<>();

    public Teammember_Adapter(Context context, ArrayList<Teamname_getter_setter> name) {
        this.context = context;
        this.Teamname = name;
    }

    @Override
    public Teamholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.teammember_recylerview,parent,false);
        Teamholder teamholder=new Teamholder(view);
        return teamholder;
    }

    @Override
    public void onBindViewHolder(Teamholder holder, int position) {
        final Teamname_getter_setter teamname=Teamname.get(position);
         holder.teammember.setText(teamname.getTeamname());
        holder.teamid.setText(teamname.getMythri_id());
    }

    @Override
    public int getItemCount() {
        return Teamname.size();
    }
    public class Teamholder extends RecyclerView.ViewHolder{
        TextView teamid,teammember;
        public Teamholder(View itemView) {
            super(itemView);
            teamid= (TextView) itemView.findViewById(R.id.mythri_id);
            teammember= (TextView) itemView.findViewById(R.id.teamname_id);
        }
    }
}
