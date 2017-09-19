package com.jss.jssatenmythri2017_18.activity.coordinator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.jss.jssatenmythri2017_18.R;

/**
 * Created by Ansh on 10/6/2016.
 */
public class Your_Events extends Fragment {

    SharedPreferences sharedPreferences;
    final String LOGIN_KEY = "logged_in";
    final String PREF_NAME = "mythri-2016";
    String USERNAME = "useername";
    String MYTHRI_ID = "mythri_id";
    Spinner spinner_types, spinner_gender, spinner_round;
    ArrayAdapter gamesAdapter, typesAdapter, genderAdapter, roundsadapter;

    String seleccted_games, selected_types, selected_gender;

    String[] gender = new String[]{
            "Boys"
    };

    String[] gender_singles = new String[]{
            "Boys",
            "Girls"
    };

    String[] gender_mixed = new String[]{
            "Boy(s) & Girl(s)"
    };


    String[] games = new String[]{
            "Badminton",
            "Table Tennis",
            "Carrom",
            "Tug Of War",
            "Cricket",
            "Football",
            "Volleyball",
            "Chess",
            "Basketball",
            "Shot Put",
            "Athelitics",
            "Kabaddi",
            "Fun Games"
    };


    String[] badminton_types = new String[]{
            "Singles",
            "Doubles",
            "Mixed Doubles",
            "Team Event"
    };

    String[] table_tennis_types = new String[]{
            "Singles",
            "Doubles",
            "Mixed Doubles"
    };

    String[] carrom_types = new String[]{
            "Singles",
            "Doubles",
            "Mixed Doubles"
    };

    String[] basketball_types = new String[]{
            "5 On 5",
            "3 On 3"
    };
    String[] football_types = new String[]{
            "none"
    };
    String[] volleyball_types = new String[]{
            "none"
    };
    String[] chess_types = new String[]{
            "none"
    };
    String[] tugofwar_types = new String[]{
            "none"
    };
    String[] cricket_types = new String[]{
            "none"
    };
    String[] shotput_types = new String[]{
            "none"
    };
    String[] athelitics_types = new String[]{
            "100mts",
            "200mts",
            "4 x 100mts relay",
            "100mts Three Legged Race",
    };
    String[] kabaddi_types = new String[]{
            "none"
    };
    String[] fungames_types = new String[]{
            "Blind Shoot",
            "Dart",
            "3 Shots",
            "Basket Shoot",
            "Ball Bounce"
    };

    String[] rounds = new String[]{
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
    };

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    Button set, get;
    String gname;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_controller, container, false);
        sharedPreferences = getContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        gname = sharedPreferences.getString(USERNAME, "");
        set = (Button) view.findViewById(R.id.setfixtures);
        get = (Button) view.findViewById(R.id.getfixtures);

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String g = String.valueOf(spinner_gender.getSelectedItem());
                if(g.contains("Boy(s) & Girl(s)")){
                    g = "none";
                }

                Intent intent = new Intent(getContext(), SetFixtures.class);
                intent.putExtra("gname", gname);
                intent.putExtra("gtype", String.valueOf(spinner_types.getSelectedItem()));

                intent.putExtra("ggen",g);
                intent.putExtra("round", String.valueOf(spinner_round.getSelectedItem()));
                startActivity(intent);
            }
        });

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String g = String.valueOf(spinner_gender.getSelectedItem());
                if(g.contains("Boy(s) & Girl(s)")){
                    g = "none";
                }
                Intent intent = new Intent(getContext(), ViewFixtures.class);
                intent.putExtra("gname", gname);
                intent.putExtra("type","normal");
                intent.putExtra("gtype", String.valueOf(spinner_types.getSelectedItem()));
                intent.putExtra("ggen",g);
                intent.putExtra("round", String.valueOf(spinner_round.getSelectedItem()));
                startActivity(intent);
            }
        });
        // Inflate the layout for getContext() 

        spinner_round = (Spinner) view.findViewById(R.id.spinner_round);
        roundsadapter = new ArrayAdapter(getContext(), R.layout.spinner_item, rounds);
        roundsadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_round.setAdapter(roundsadapter);

        spinner_gender = (Spinner) view.findViewById(R.id.spinner_gender);
        genderAdapter = new ArrayAdapter(getContext(), R.layout.spinner_item, gender);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_gender.setAdapter(genderAdapter);

        spinner_types = (Spinner) view.findViewById(R.id.spinner_types);
        typesAdapter = new ArrayAdapter(getContext(), R.layout.spinner_item, badminton_types);
        typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_types.setAdapter(typesAdapter);

        switch (gname) {
            case "Badminton":
                typesAdapter = new ArrayAdapter(getContext(), R.layout.spinner_item, badminton_types); //just to show none in the beginning
                typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_types.setAdapter(typesAdapter);
                break;
            case "Table Tennis":
                typesAdapter = new ArrayAdapter(getContext(), R.layout.spinner_item, table_tennis_types); //just to show none in the beginning
                typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_types.setAdapter(typesAdapter);
                break;
            case "Carrom":
                typesAdapter = new ArrayAdapter(getContext(), R.layout.spinner_item, carrom_types); //just to show none in the beginning
                typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_types.setAdapter(typesAdapter);
                break;
            case "Tug Of War":
                typesAdapter = new ArrayAdapter(getContext(), R.layout.spinner_item, tugofwar_types); //just to show none in the beginning
                typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_types.setAdapter(typesAdapter);
                break;
            case "Cricket":
                typesAdapter = new ArrayAdapter(getContext(), R.layout.spinner_item, cricket_types); //just to show none in the beginning
                typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_types.setAdapter(typesAdapter);
                break;
            case "Football":
                typesAdapter = new ArrayAdapter(getContext(), R.layout.spinner_item, football_types); //just to show none in the beginning
                typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_types.setAdapter(typesAdapter);
                break;
            case "Volleyball":
                typesAdapter = new ArrayAdapter(getContext(), R.layout.spinner_item, volleyball_types); //just to show none in the beginning
                typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_types.setAdapter(typesAdapter);
                break;
            case "Chess":
                typesAdapter = new ArrayAdapter(getContext(), R.layout.spinner_item, chess_types); //just to show none in the beginning
                typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_types.setAdapter(typesAdapter);
                break;
            case "Basketball":
                typesAdapter = new ArrayAdapter(getContext(), R.layout.spinner_item, basketball_types); //just to show none in the beginning
                typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_types.setAdapter(typesAdapter);
                break;
            case "Shot Put":
                typesAdapter = new ArrayAdapter(getContext(), R.layout.spinner_item, shotput_types); //just to show none in the beginning
                typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_types.setAdapter(typesAdapter);
                break;
            case "Athelitics":
                typesAdapter = new ArrayAdapter(getContext(), R.layout.spinner_item, athelitics_types); //just to show none in the beginning
                typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_types.setAdapter(typesAdapter);
                break;
            case "Kabaddi":
                typesAdapter = new ArrayAdapter(getContext(), R.layout.spinner_item, kabaddi_types); //just to show none in the beginning
                typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_types.setAdapter(typesAdapter);
                break;
            case "Fun Games":
                typesAdapter = new ArrayAdapter(getContext(), R.layout.spinner_item, fungames_types); //just to show none in the beginning
                typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_types.setAdapter(typesAdapter);
                break;
        }
           

        spinner_types.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String type = String.valueOf(spinner_types.getSelectedItem());

                if (type.contains("Single") || type.equals("Doubles") || gname.contains("Athelitics")) {
                    genderAdapter = new ArrayAdapter(getContext(), R.layout.spinner_item, gender_singles);
                    genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_gender.setAdapter(genderAdapter);
                } else if (type.contains("none") && gname.contains("Tug") ||
                        gname.contains("Cricket")) {
                    genderAdapter = new ArrayAdapter(getContext(), R.layout.spinner_item, gender_mixed);
                    genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_gender.setAdapter(genderAdapter);
                } else if (type.contains("none") && gname.contains("Football") ||
                        gname.contains("Volleyball") ||
                        gname.contains("Basketball") ||
                        gname.contains("Chess") ||
                        gname.contains("Shot Put")) {
                    genderAdapter = new ArrayAdapter(getContext(), R.layout.spinner_item, gender_singles);
                    genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_gender.setAdapter(genderAdapter);
                } else if (type.contains("5 On 5") || type.contains("3 On 3")) {
                    genderAdapter = new ArrayAdapter(getContext(), R.layout.spinner_item, gender_singles);
                    genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_gender.setAdapter(genderAdapter);
                } else if (type.contains("none")) {
                    genderAdapter = new ArrayAdapter(getContext(), R.layout.spinner_item, gender);
                    genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_gender.setAdapter(genderAdapter);
                } else {
                    genderAdapter = new ArrayAdapter(getContext(), R.layout.spinner_item, gender_mixed);
                    genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_gender.setAdapter(genderAdapter);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        return view;
    }


}

