package com.jss.jssatenmythri2017_18.activity.registeration;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.jss.jssatenmythri2017_18.R;
import com.jss.jssatenmythri2017_18.activity.LoginActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class RegistrationActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    final String LOGIN_KEY = "logged_in";
    final String PREF_NAME = "mythri-2016";

    Button btnnext;

    Spinner spinner_games, spinner_types, spinner_gender;
    ArrayAdapter gamesAdapter, typesAdapter, genderAdapter;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);

        btnnext = (Button) findViewById(R.id.btnnext);
        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        spinner_gender = (Spinner) findViewById(R.id.spinner_gender);
        genderAdapter = new ArrayAdapter(this, R.layout.spinner_item, gender);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_gender.setAdapter(genderAdapter);

        spinner_games = (Spinner) findViewById(R.id.spinner_games);
        gamesAdapter = new ArrayAdapter(this, R.layout.spinner_item, games);
        gamesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_games.setAdapter(gamesAdapter);

        spinner_types = (Spinner) findViewById(R.id.spinner_types);
        typesAdapter = new ArrayAdapter(this, R.layout.spinner_item, badminton_types);
        typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_types.setAdapter(typesAdapter);

        spinner_games.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        typesAdapter = new ArrayAdapter(RegistrationActivity.this, R.layout.spinner_item, badminton_types); //just to show none in the beginning
                        typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner_types.setAdapter(typesAdapter);
                        break;
                    case 1:
                        typesAdapter = new ArrayAdapter(RegistrationActivity.this, R.layout.spinner_item, table_tennis_types); //just to show none in the beginning
                        typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner_types.setAdapter(typesAdapter);
                        break;
                    case 2:
                        typesAdapter = new ArrayAdapter(RegistrationActivity.this, R.layout.spinner_item, carrom_types); //just to show none in the beginning
                        typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner_types.setAdapter(typesAdapter);
                        break;
                    case 3:
                        typesAdapter = new ArrayAdapter(RegistrationActivity.this, R.layout.spinner_item, tugofwar_types); //just to show none in the beginning
                        typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner_types.setAdapter(typesAdapter);
                        break;
                    case 4:
                        typesAdapter = new ArrayAdapter(RegistrationActivity.this, R.layout.spinner_item, cricket_types); //just to show none in the beginning
                        typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner_types.setAdapter(typesAdapter);
                        break;
                    case 5:
                        typesAdapter = new ArrayAdapter(RegistrationActivity.this, R.layout.spinner_item, football_types); //just to show none in the beginning
                        typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner_types.setAdapter(typesAdapter);
                        break;
                    case 6:
                        typesAdapter = new ArrayAdapter(RegistrationActivity.this, R.layout.spinner_item, volleyball_types); //just to show none in the beginning
                        typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner_types.setAdapter(typesAdapter);
                        break;
                    case 7:
                        typesAdapter = new ArrayAdapter(RegistrationActivity.this, R.layout.spinner_item, chess_types); //just to show none in the beginning
                        typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner_types.setAdapter(typesAdapter);
                        break;
                    case 8:
                        typesAdapter = new ArrayAdapter(RegistrationActivity.this, R.layout.spinner_item, basketball_types); //just to show none in the beginning
                        typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner_types.setAdapter(typesAdapter);
                        break;
                    case 9:
                        typesAdapter = new ArrayAdapter(RegistrationActivity.this, R.layout.spinner_item, shotput_types); //just to show none in the beginning
                        typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner_types.setAdapter(typesAdapter);
                        break;
                    case 10:
                        typesAdapter = new ArrayAdapter(RegistrationActivity.this, R.layout.spinner_item, athelitics_types); //just to show none in the beginning
                        typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner_types.setAdapter(typesAdapter);
                        break;
                    case 11:
                        typesAdapter = new ArrayAdapter(RegistrationActivity.this, R.layout.spinner_item, kabaddi_types); //just to show none in the beginning
                        typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner_types.setAdapter(typesAdapter);
                        break;
                    case 12:
                        typesAdapter = new ArrayAdapter(RegistrationActivity.this, R.layout.spinner_item, fungames_types); //just to show none in the beginning
                        typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner_types.setAdapter(typesAdapter);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        spinner_types.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String type = String.valueOf(spinner_types.getSelectedItem());

                if (type.contains("Single") || type.equals("Doubles") || String.valueOf(spinner_games.getSelectedItem()).contains("Athelitics")) {
                    genderAdapter = new ArrayAdapter(RegistrationActivity.this, R.layout.spinner_item, gender_singles);
                    genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_gender.setAdapter(genderAdapter);
                } else if (type.contains("none") && (String.valueOf(spinner_games.getSelectedItem()).contains("Tug") ||
                        String.valueOf(spinner_games.getSelectedItem()).contains("Cricket"))) {
                    genderAdapter = new ArrayAdapter(RegistrationActivity.this, R.layout.spinner_item, gender_mixed);
                    genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_gender.setAdapter(genderAdapter);
                } else if (type.contains("none") && (String.valueOf(spinner_games.getSelectedItem()).contains("Football") ||
                        String.valueOf(spinner_games.getSelectedItem()).contains("Volleyball") ||
                        String.valueOf(spinner_games.getSelectedItem()).contains("Basketball") ||
                        String.valueOf(spinner_games.getSelectedItem()).contains("Chess") ||
                        String.valueOf(spinner_games.getSelectedItem()).contains("Shot Put"))) {
                    genderAdapter = new ArrayAdapter(RegistrationActivity.this, R.layout.spinner_item, gender_singles);
                    genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_gender.setAdapter(genderAdapter);
                } else if (type.contains("5 On 5") || type.contains("3 On 3")) {
                    genderAdapter = new ArrayAdapter(RegistrationActivity.this, R.layout.spinner_item, gender_singles);
                    genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_gender.setAdapter(genderAdapter);
                } else if (type.contains("none")) {
                    genderAdapter = new ArrayAdapter(RegistrationActivity.this, R.layout.spinner_item, gender);
                    genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_gender.setAdapter(genderAdapter);
                } else {
                    genderAdapter = new ArrayAdapter(RegistrationActivity.this, R.layout.spinner_item, gender_mixed);
                    genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_gender.setAdapter(genderAdapter);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                seleccted_games = String.valueOf(spinner_games.getSelectedItem());
                selected_gender = String.valueOf(spinner_gender.getSelectedItem());
                selected_types = String.valueOf(spinner_types.getSelectedItem());

                //just as karan says.. ;)
                if(selected_gender.contains("Boy(s) & Girl(s)")) {
                    selected_gender = "none";
                }

                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("gname", seleccted_games);
                    jsonObject.put("gtype", selected_types);
                    jsonObject.put("ggen", selected_gender);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if ((seleccted_games.equals("Badminton") && selected_types.equals("Singles")) ||
                        (seleccted_games.equals("Table Tennis") && selected_types.equals("Singles")) ||
                        (seleccted_games.equals("Chess")) ||
                        (seleccted_games.equals("Carrom") && selected_types.equals("Singles")) ||
                        (seleccted_games.equals("Athelitics") && selected_types.equals("100mts")) ||
                        (seleccted_games.equals("Athelitics") && selected_types.equals("200mts")) ||
                        (seleccted_games.equals("Shot Put") && selected_types.equals("none")) ||
                        (seleccted_games.equals("Fun Games"))
                        ) {

                    Intent i = new Intent(RegistrationActivity.this, F8Activity.class);
                    i.putExtra("game", seleccted_games);
                    i.putExtra("type", selected_types);
                    i.putExtra("gender", selected_gender);
                    i.putExtra("nos", 1);
                    startActivity(i);
                } else if ((seleccted_games.equals("Badminton") && selected_types.equals("Doubles")) ||
                        (seleccted_games.equals("Badminton") && selected_types.contains("Mixed")) ||
                        (seleccted_games.equals("Table Tennis") && selected_types.equals("Doubles")) ||
                        (seleccted_games.equals("Table Tennis") && selected_types.contains("Mixed")) ||
                        (seleccted_games.equals("Carrom") && selected_types.equals("Doubles")) ||
                        (seleccted_games.equals("Carrom") && selected_types.contains("Mixed")) ||
                        (seleccted_games.equals("Athelitics") && selected_types.equals("100mts Three Legged Race"))
                        )

                {
                    Intent i = new Intent(RegistrationActivity.this, F8Activity.class);
                    i.putExtra("game", seleccted_games);
                    i.putExtra("type", selected_types);
                    i.putExtra("gender", selected_gender);
                    i.putExtra("nos", 2);
                    startActivity(i);
                } else if (
                        (seleccted_games.equals("Athelitics") && selected_types.contains("4 x 100mts"))
                        ) {
                    Intent i = new Intent(RegistrationActivity.this, F8Activity.class);
                    i.putExtra("game", seleccted_games);
                    i.putExtra("type", selected_types);
                    i.putExtra("gender", selected_gender);
                    i.putExtra("nos", 4);
                    startActivity(i);
                } else if (seleccted_games.equals("Cricket") || seleccted_games.equals("Volleyball") ||
                        (seleccted_games.equals("Basketball") && selected_types.equals("3 On 3"))
                        || (seleccted_games.equals("Football"))) {
                    Intent i = new Intent(RegistrationActivity.this, F8Activity.class);
                    i.putExtra("game", seleccted_games);
                    i.putExtra("type", selected_types);
                    i.putExtra("gender", selected_gender);
                    i.putExtra("nos", 6);
                    startActivity(i);
                } else if (seleccted_games.equals("Kabaddi") ||
                        (seleccted_games.equals("Basketball") && selected_types.equals("5 On 5"))) {
                    Intent i = new Intent(RegistrationActivity.this, F8Activity.class);
                    i.putExtra("game", seleccted_games);
                    i.putExtra("type", selected_types);
                    i.putExtra("gender",selected_gender);
                    i.putExtra("nos", 7);
                    startActivity(i);
                } else if (seleccted_games.equals("Tug Of War") || (seleccted_games.equals("Football") && selected_gender.equals("Boy(s)"))) {
                    Intent i = new Intent(RegistrationActivity.this, F8Activity.class);
                    i.putExtra("game", seleccted_games);
                    i.putExtra("type", selected_types);
                    i.putExtra("gender",selected_gender);
                    i.putExtra("nos", 8);
                    startActivity(i);
                }

            }


        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //noinspection SimplifiableIfStatement


        if (item.getItemId() == R.id.logout) {
            logout();
        }else if(item.getItemId() == R.id.calladmin){
            onCall("9958099621");
        }
        return super.onOptionsItemSelected(item);
    }

    public void onCall(String number) {

        if(Build.VERSION.SDK_INT >= 23) {
            int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                        this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        123);
            } else {
                startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:"+number)));
            }
        }else{
            startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:"+number)));
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {

            case 123:
                if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                } else {
                    Log.d("TAG", "Call Permission Not Granted");
                }
                break;

            default:
                break;
        }
    }

    private void logout() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(LOGIN_KEY, false);
        editor.apply();
        startActivity(new Intent(RegistrationActivity.this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
        finish();
    }
}
