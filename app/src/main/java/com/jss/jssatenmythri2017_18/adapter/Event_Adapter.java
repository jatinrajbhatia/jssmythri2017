package com.jss.jssatenmythri2017_18.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.jss.jssatenmythri2017_18.R;
import com.jss.jssatenmythri2017_18.activity.Team_member_reclyerview;
import com.jss.jssatenmythri2017_18.activity.UserGames;
import com.jss.jssatenmythri2017_18.util.Text_Getter_Setter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user1 on 29-Sep-16.
 */
public class Event_Adapter extends RecyclerView.Adapter <Event_Adapter.Myholder>{
    ArrayList<Text_Getter_Setter> Name=new ArrayList<Text_Getter_Setter>();
    UserGames userGames;
 public static ArrayList<String> teammember;
    public static ArrayList<String> teammemberid;
    String URL="http://35.202.2.74:3000/teammembers";
    JSONObject jsonObject;
    JSONArray jsonArray;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    Intent intent;
    Context context;
    public Event_Adapter(ArrayList<Text_Getter_Setter> text_getter_setters,Context context) {
        this.context=context;
        this.Name=text_getter_setters;
    }
    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        Myholder viewholder=new Myholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {
        final Text_Getter_Setter name=Name.get(position);
        holder.name.setText(name.getName());
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teammember = new ArrayList<String>();
                teammemberid = new ArrayList<String>();
                userGames = new UserGames();
                String gamename = name.getName().trim();
                final String n = userGames.checker(gamename);
                final RequestQueue requestQueue=Volley.newRequestQueue(context);
                requestQueue.start();

                StringRequest stringRequest = new StringRequest(Request.Method.POST,URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray=jsonObject.getJSONArray("users");
                            for(int i=0;i<jsonArray.length();i++){
                                //Teamname_getter_setter teamname_getter_setter=new Teamname_getter_setter(jsonArray.getJSONObject(i).getString("name"),jsonArray.getJSONObject(i).getString("mythri_id"));
                                String teammember1=jsonArray.getJSONObject(i).getString("name");
                                String memberid=jsonArray.getJSONObject(i).getString("mythri_id");
                                teammember.add(teammember1);
                                teammemberid.add(memberid);

                            }
                            intent=new Intent(context, Team_member_reclyerview.class);
                            intent.putExtra("teammember",teammember);
                            intent.putExtra("memberid",teammemberid);
                            intent.putExtra("title",n);
                            context.startActivity(intent);

                            Toast.makeText(context,teammember.get(0)+" "+teammemberid.get(0),Toast.LENGTH_LONG).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Override
                    public String getBodyContentType() {
                        return "application/x-www-form-urlencoded";
                    }
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> map=new HashMap<String,String>();
                        map.put("tname",n);
                        return map;
                    }
                };


                /*JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, URL,(JSONObject) null, new Response.Listener<JSONObject>() {
                   @Override
                   public void onResponse(JSONObject response) {

                       try {
                           JSONArray jsonArray=response.getJSONArray("users");
                           for(int i=0;i<jsonArray.length();i++){
                           teammember.add(jsonArray.getJSONObject(i).getString("name"));
                               teammemberid.add(jsonArray.getJSONObject(i).getString("mythri_id"));
                               Toast.makeText(context,teammember.get(i)+teammemberid.get(i),Toast.LENGTH_LONG).show();
                           }
                       } catch (JSONException e) {
                           e.printStackTrace();
                       }
                   }
               }, new Response.ErrorListener() {
                   @Override
                   public void onErrorResponse(VolleyError error) {
                     requestQueue.stop();
                   }
               });*/

               requestQueue.add(stringRequest);
            }

        });

    }

    @Override
    public int getItemCount() {
        return Name.size();
    }
    public static class Myholder extends RecyclerView.ViewHolder{
        TextView name;
        public Myholder(View itemView) {
            super(itemView);
            name= (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
