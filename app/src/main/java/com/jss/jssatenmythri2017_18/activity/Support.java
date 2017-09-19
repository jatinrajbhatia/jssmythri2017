package com.jss.jssatenmythri2017_18.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jss.jssatenmythri2017_18.R;

public class Support extends Fragment {

    LinearLayout jatincontact,saurabhcontact,shwetacontact, gauravcontact;
    TextView jatinnumber,saurabhnumber,shwetanumber, gauravnumber;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_support, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        jatincontact = (LinearLayout)view.findViewById(R.id.callJatin);
        saurabhcontact = (LinearLayout)view.findViewById(R.id.callSaurabh);
        shwetacontact = (LinearLayout)view.findViewById(R.id.callShweta);
        gauravcontact = (LinearLayout)view.findViewById(R.id.callGaurav);

        jatinnumber = (TextView)view.findViewById(R.id.jatinnumber);
        saurabhnumber = (TextView)view.findViewById(R.id.saurabhnumber);
        shwetanumber = (TextView)view.findViewById(R.id.shwetanumber);
        gauravnumber = (TextView)view.findViewById(R.id.gauravnumber);

        jatincontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCall(jatinnumber.getText().toString());
            }
        });
        saurabhcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCall(saurabhnumber.getText().toString());
            }
        });
        shwetacontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCall(shwetanumber.getText().toString());
            }
        });
        gauravcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCall(gauravnumber.getText().toString());
            }
        });





    }

    public void onCall(String number) {

        if(Build.VERSION.SDK_INT >= 23) {
            int permissionCheck = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE);

            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                        getActivity(),
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


}
