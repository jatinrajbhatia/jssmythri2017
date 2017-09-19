package com.jss.jssatenmythri2017_18.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jss.jssatenmythri2017_18.adapter.Event_Adapter;
import com.jss.jssatenmythri2017_18.helper.AccessServiceAPI;
import com.jss.jssatenmythri2017_18.util.Common;
import com.jss.jssatenmythri2017_18.R;
import com.jss.jssatenmythri2017_18.util.Team_Getter_Setter;
import com.jss.jssatenmythri2017_18.util.Text_Getter_Setter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sushant on 26-09-2016.
 */
public class UserGames extends Fragment {
public static Map<String,String> teamchecker=new HashMap<String,String>();
    SharedPreferences sharedPreferences;
    final String PREF_NAME = "mythri-2016";
    String MYTHRI_ID = "mythri_id";
    private AccessServiceAPI m_ServiceAccess;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    String[] name;
    ArrayList<Team_Getter_Setter> teamlist=new ArrayList<Team_Getter_Setter>();
    ArrayList<Text_Getter_Setter> list = new ArrayList<Text_Getter_Setter>();
    Event_Adapter event_adapter;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //    new TaskLogin().execute(sharedPreferences.getString(MYTHRI_ID,""));

//for testing remove it before launching app
        //TODO
        new TaskLogin().execute(sharedPreferences.getString(MYTHRI_ID, "1"));
    }

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        sharedPreferences = getActivity().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        view = inflater.inflate(R.layout.fragment_games, container, false);
        m_ServiceAccess = new AccessServiceAPI();
        // Inflate the layout for this fragment
        return view;
    }

    JSONObject jsonObject;

    public class TaskLogin extends AsyncTask<String, Void, Integer> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Open progress dialog during login
        }

        @Override
        protected Integer doInBackground(String... params) {
            Map<String, String> param = new HashMap<>();

            param.put("myth", params[0]);

            try {
                jsonObject = m_ServiceAccess.convertJSONString2Obj(m_ServiceAccess.getJSONStringWithParam_POST(Common.SERVICE_USERGAMES, param));
                return jsonObject.getInt("result");
            } catch (Exception e) {
                return Common.RESULT_ERROR;
            }

        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);
            if (Common.RESULT_SUCCESS == result) {

                //get names array

                try {
                    JSONObject jsonObject1 = jsonObject.getJSONArray("userArray").getJSONObject(0);

                    try {
                        if (jsonObject1 != null) {
                            if (jsonObject1.getJSONArray("games").length() > 0) {
                                for (int i = 0; i < jsonObject1.getJSONArray("games").length(); i++) {
                                    Text_Getter_Setter text_getter_setter = new Text_Getter_Setter(jsonObject1.getJSONArray("games").getString(i));
                                    Team_Getter_Setter team_getter_setter=new Team_Getter_Setter(jsonObject1.getJSONArray("teams").getString(i));
                                    teamlist.add(team_getter_setter);
                                    list.add(text_getter_setter);
                                    teamchecker.put(list.get(i).getName(),teamlist.get(i).getTeam());
                                }
                                recyclerView = (RecyclerView) view.findViewById(R.id.Recylerviewid);
                                layoutManager = new LinearLayoutManager(getActivity());
                                recyclerView.setLayoutManager(layoutManager);
                                recyclerView.setHasFixedSize(true);
                                event_adapter=new Event_Adapter(list,getContext());
                                //adapter = new Adapter(list,getContext());
                                recyclerView.setAdapter(event_adapter);
                            } else {
                                Text_Getter_Setter text_getter_setter = new Text_Getter_Setter("You Are Not Registered in any of the games.\n " +
                                        "What are you waiting for...Hurry Up!! Go And Get Registered.");
                                list.add(text_getter_setter);
                                recyclerView = (RecyclerView) view.findViewById(R.id.Recylerviewid);
                                layoutManager = new LinearLayoutManager(getActivity());
                                recyclerView.setLayoutManager(layoutManager);
                                recyclerView.setHasFixedSize(true);
                                event_adapter=new Event_Adapter(list,getContext());
                                //adapter = new Adapter(list,getContext());
                                recyclerView.setAdapter(event_adapter);
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Text_Getter_Setter text_getter_setter = new Text_Getter_Setter("..Network issue..");
                list.add(text_getter_setter);
                recyclerView = (RecyclerView) view.findViewById(R.id.Recylerviewid);
                layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setHasFixedSize(true);
                event_adapter=new Event_Adapter(list,getContext());
                //adapter = new Adapter(combinedlist,getContext());
                recyclerView.setAdapter(event_adapter);
            }
        }
    }
     public String checker(String game){
            String check=teamchecker.get(game);
         return check;
     // return "hello";
     }
}
