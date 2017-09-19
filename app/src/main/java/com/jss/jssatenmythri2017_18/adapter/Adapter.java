package com.jss.jssatenmythri2017_18.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jss.jssatenmythri2017_18.R;
import com.jss.jssatenmythri2017_18.activity.Athelics_Listview;
import com.jss.jssatenmythri2017_18.activity.GamedetailActivity;
import com.jss.jssatenmythri2017_18.util.Text_Getter_Setter;

import java.util.ArrayList;

/**
 * Created by Unnati on 9/21/2016.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder >{

    Context context;
     ArrayList<Text_Getter_Setter> Name=new ArrayList<Text_Getter_Setter>();

    public Adapter(ArrayList<Text_Getter_Setter> text_getter_setters, Context context){
        this.Name=text_getter_setters;
        this.context = context;
    }
    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        Viewholder viewholder=new Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(final Viewholder holder, int position) {
        final Text_Getter_Setter name=Name.get(position);
        holder.name.setText(name.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String vname= name.getName();
                switch (vname){
                    case "Badminton":{
                        
                        Intent i=new Intent(context,GamedetailActivity.class);
                        i.putExtra("title",vname);
                        context.startActivity(i);
                    }break;
                    case "Table Tennis":{
                        
                        Intent i=new Intent(context,GamedetailActivity.class);
                        i.putExtra("title",vname);
                        context.startActivity(i);

                    }break;
                    case "Chess":{
                        
                        Intent i=new Intent(context,GamedetailActivity.class);
                        i.putExtra("title",vname);
                        context.startActivity(i);
                    }break;
                    case "Carrom":{
                        
                        Intent i=new Intent(context,GamedetailActivity.class);
                        i.putExtra("title",vname);
                        context.startActivity(i);
                    }break;
                    case "Tug Of War":{
                        
                        Intent i=new Intent(context,GamedetailActivity.class);
                        i.putExtra("title",vname);
                        context.startActivity(i);
                    }break;
                    case "Cricket":{
                        
                        Intent i=new Intent(context,GamedetailActivity.class);
                        i.putExtra("title",vname);
                        context.startActivity(i);
                    }break;
                    case "Football":{
                        
                        Intent i=new Intent(context,GamedetailActivity.class);
                        i.putExtra("title",vname);
                        context.startActivity(i);
                    }break;
                    case "Volleyball":{
                        
                        Intent i=new Intent(context,GamedetailActivity.class);
                        i.putExtra("title",vname);
                        context.startActivity(i);
                    }break;
                    case "Basketball":{
                        
                        Intent i=new Intent(context,GamedetailActivity.class);
                        i.putExtra("title",vname);
                        context.startActivity(i);

                    }break;
                    case "Athelitics":{
                        Intent intent = new Intent(context, Athelics_Listview.class);
                        context.startActivity(intent);

                    }break;
                    case "Shot Put":{

                        
                        Intent i=new Intent(context,GamedetailActivity.class);
                        i.putExtra("title",vname);
                        context.startActivity(i);

                    }break;
                    case "Kabaddi":{

                        
                        Intent i=new Intent(context,GamedetailActivity.class);
                        i.putExtra("title",vname);
                        context.startActivity(i);

                    }break;
                    case "Fun Games":{

                        
                        Intent i=new Intent(context,GamedetailActivity.class);
                        i.putExtra("title",vname);
                        context.startActivity(i);

                    }break;
                }


                //set Intents here
            }
        });
    }

    @Override
    public int getItemCount() {
        return Name.size();
    }
    public static class Viewholder extends RecyclerView.ViewHolder{
       TextView name;
        public Viewholder(View itemView) {
            super(itemView);
            name= (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
