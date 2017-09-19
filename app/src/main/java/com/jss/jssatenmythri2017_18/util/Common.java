package com.jss.jssatenmythri2017_18.util;

/**
 * Created by NgocTri on 4/11/2016.
 */
public class Common {

	public static final String BASE_URL = "http://35.202.2.74:3000";

    public static final String SERVICE_API_URL = BASE_URL + "/login/";
    public static final String SERVICE_SIGN_UP_URL = BASE_URL +"/add/";
    public static final String SERVICE_ADDGAME_URL = BASE_URL +"/addgame/";
    public static final String SERVICE_COUNT_URL = BASE_URL +"/count/";
    public static final String SERVICE_CHECK_URL = BASE_URL +"/check/";
    public static final String SERVICE_CHECK_VERSION_URL = BASE_URL +"/version/";
    public static final String SERVICE_USERGAMES = BASE_URL +"/usergames/";
    public static final String SERVICE_GAMEUSERS = BASE_URL +"/gameusers/";
    public static final String SERVICE_SETMATCH = BASE_URL +"/fixmatch/";
    public static final String SERVICE_GETMATCH = BASE_URL +"/findfixedmatch/";
    public static final String SERVICE_ADDTSHIRT_URL = BASE_URL +"/tshirt/";
    public static final String SERVICE_UPDATE_WINNER = BASE_URL +"/updatewinner/";
    public static final String SERVICE_UPDATE_LOOSER = BASE_URL +"/updatelooser/";



    public static final int RESULT_SUCCESS = 0;
    public static final int RESULT_ERROR= 1;
    public static final int RESULT_USER_EXISTS = 2;
}
