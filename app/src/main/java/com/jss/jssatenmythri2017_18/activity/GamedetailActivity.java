package com.jss.jssatenmythri2017_18.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jss.jssatenmythri2017_18.R;

public class GamedetailActivity extends AppCompatActivity {
    String data;

    LinearLayout studentCoordinatorOne,studentCoordinatorTwo,studentCoordinatorThree,facualtyCoordinatorOne,facualtyCoordinatorTwo;

    TextView studentOneName,studentTwoName,studentThreeName,facultyName,facultyName2;
    TextView studentOneContact,studentTwoContact,studentThreeContact,type,venue,title;
    WebView rules;
    WebSettings webSettings;
    ImageView studentOneImage,studentTwoImage,studentThreeImage,facultyImage,facultyImage2;

    int numberOfCoordinators;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dummylayout);
        data=getIntent().getExtras().getString("title");
        numberOfCoordinators = getIntent().getExtras().getInt("Nos");
        //linking components
        studentOneContact = (TextView)findViewById(R.id.studentnumber1);
        studentTwoContact = (TextView)findViewById(R.id.studentnumber2);
        studentThreeContact = (TextView)findViewById(R.id.studentnumber3);
        facultyName= (TextView) findViewById(R.id.name1);
        facultyName2= (TextView) findViewById(R.id.name2);
        type= (TextView) findViewById(R.id.type_detail);
        rules= (WebView) findViewById(R.id.detail_rules);
        venue= (TextView) findViewById(R.id.detail_v_d);
        title= (TextView) findViewById(R.id.item_title);


        studentOneName = (TextView)findViewById(R.id.studentname1);
        studentTwoName = (TextView)findViewById(R.id.studentname2);
        studentThreeName = (TextView)findViewById(R.id.studentname3);

        studentOneImage = (ImageView)findViewById(R.id.imagestudent1);
        studentTwoImage = (ImageView)findViewById(R.id.imagestudent2);
        studentThreeImage = (ImageView)findViewById(R.id.imagestudent3);
        facultyImage = (ImageView)findViewById(R.id.facultyimage);
        facultyImage2= (ImageView)findViewById(R.id.facultyimage2);

        studentCoordinatorOne =  (LinearLayout)findViewById(R.id.studentcoordinator0ne);
        studentCoordinatorTwo =  (LinearLayout)findViewById(R.id.studentcoordinatortwo);
        studentCoordinatorThree =  (LinearLayout)findViewById(R.id.studentcoordinatorthree);
        facualtyCoordinatorOne= (LinearLayout) findViewById(R.id.facultycoordinator0ne);
        facualtyCoordinatorTwo = (LinearLayout) findViewById(R.id.facultycoordinatorTwo);



        switch (data) {
            case "Badminton": {
                title.setText(data);
                studentOneName.setText("Shubham Dubey\nEC/4th yr");
                studentTwoName.setText("Kuldeep Yadav \nEC/4th yr");
                studentThreeName.setText("Shivam Deshwal\nIT/4th yr");
                facultyName.setText("Mr. Sadashiva T\nAP-MBA");
                facultyImage.setImageResource(R.drawable.sadashiv);
                facualtyCoordinatorTwo.setVisibility(View.GONE);
                studentOneImage.setImageResource(R.drawable.shubham_badminton);
                studentTwoImage.setImageResource(R.drawable.kuldeep_badminton);
                studentThreeImage.setImageResource(R.drawable.shivam_badminton);
                studentOneContact.setText("888219934");
                studentTwoContact.setText("9560963592");
                studentThreeContact.setText("7017496091");
                type.setText("Singles , Doubles , Mixed, Team event");
                venue.setText("MPH BADMINTON HALL");

                final StringBuffer rule = new StringBuffer();
                rule.append("<HTML>\n" +
                        "<BODY>" +

                        "<h3><b>SCORING SYSTEM</b></h3>\n" +

                        "\n" +
                        "<p><b>o</b> A match consists of the best of 3 games of 21 points.\n" +
                        "<br>" +
                        "<b>o</b> Every time there is a serve .There is a point scored. \n" +
                        "<br>" +
                        "<b>o</b> The side winning a rally adds a point to its score.\n" +
                        "<br>" +
                        "<b>o</b> At 20 all, the side which gains a 2-point lead first, wins that game.\n" +
                        "<br>" +
                        "<b>o</b> At 29 all, the side scoring the 30th point, wins that game.\n" +
                        "<br>" +
                        "<b>o</b> The side winning a game serves first in the next game.</P>\n" +
                        "<br>" +
                        "<h3><b>SINGLES</b></h3>\n" +
                        "<br>" +
                        "<p><b>o</b> At the beginning of the game (0-0) and when the server score is even, the server serves from the right service court. When the server score is odd, the server serves from the left service court.\n" +
                        "<br>" +
                        "<b>o</b> If the server wins a rally, the server scores a point and then serves again from the alternate service court.\n" +
                        "<br>" +
                        "<b>o</b> If the receiver wins a rally, the receiver scores a point and becomes the new server. They serve from the appropriate service court left if their score is odd, and right if it is even.\n" +
                        "<br></p>" +
                        "<h3>" +
                        "<b>DOUBLES</b></h3>" +
                        "<br>" +
                        "<p>" +
                        "<b>o</b> A side has only one service.\n" +
                        "<br>" +
                        "<b>o</b> The service passes consecutively to the players as shown in the diagram.At the beginning of the game and when the score is even, the server serves from the right service court. When it is odd, the server serves from the left court.\n" +
                        "<br>" +
                        "<b>o</b> If the serving side wins a rally, the serving side scores a point and the same server serves again from the alternate service court.\n" +
                        "<br>" +
                        "<b>o</b> If the receiving side wins a rally, the receiving side scores a point. The receiving side becomes the new serving side.\n" +
                        "<br>" +
                        "<b>o</b> The players do not change their respective service courts until they win a point when their side is serving.\n" +
                        "</p>" +
                        "</BODY></HTML>");
                rules.loadDataWithBaseURL("", rule.toString(), "text/html", "utf-8", "");

            }
            break;
            case "Table Tennis": {
                title.setText(data);
                studentOneName.setText("Shikhar Yadav\nME/4th yr");
                studentCoordinatorTwo.setVisibility(View.GONE);
                studentCoordinatorThree.setVisibility(View.GONE);
                facualtyCoordinatorTwo.setVisibility(View.GONE);
                facultyName.setText("Mr. Shashi Kumar.R\nAP-EC");
                studentOneContact.setText("9410600559");
                facultyImage.setImageResource(R.drawable.shashi_kumar);
                studentOneImage.setImageResource(R.drawable.shikhar_tt);
                String tt_rules="<HTML>\n" +
                        "<BODY>\n" +
                        "<p><b>Scoring</b><br><br>\n" +
                        "\n" +
                        "A set is when one of the players or pairs first score 11 points. In the event that both\n" +
                        "\n" +
                        "players/pairs score 10 points, a set is be won by the first player/pair to gain a 2-point\n" +
                        "\n" +
                        "lead. A full match is won when a player or pair wins the best of any odd number of\n" +
                        "\n" +
                        "sets (3,5,7).<br><br>\n" +
                        "\n" +
                        "<b>A point is scored when:</b><br><br>\n" +
                        "\n" +
                        "<b>1.</b> an opponent fails to make a correct service,<br>\n" +
                        "\n" +
                        "<b>2.</b> an opponent fails to make a return,<br>\n" +
                        "\n" +
                        "<b>3.</b> the ball touches any part of an opponent’s body,<br>\n" +
                        "\n" +
                        "<b>4.</b> an opponent strikes the ball twice in succession,<br>\n" +
                        "\n" +
                        "<b>5.</b> if an opponent, or anything an opponent wears, touches the playing surface or net\n" +
                        "\n" +
                        "during play,<br>\n" +
                        "\n" +
                        "<b>6.</b> if a doubles opponent strikes the ball out of the sequence established by the first\n" +
                        "\n" +
                        "server and first receiver.<br></p>\n" +
                        "</BODY></HTML>";
                rules.loadData(tt_rules, "text/html", "UTF-8");
                type.setText("Singles , Doubles , Mixed");
                venue.setText("MPH Table Tennis HALL");

            }
            break;
            case "Chess": {
                title.setText(data);
                studentCoordinatorTwo.setVisibility(View.GONE);
                studentCoordinatorThree.setVisibility(View.GONE);
                facualtyCoordinatorTwo.setVisibility(View.GONE);
                studentOneName.setText("Abhishek Tripathi\nEE/4th yr");
                facultyName.setText("Mr. Harish Kumar\nAP-ENG");
                studentOneContact.setText("9560239749");
                String chess_rules="<HTML>\n" +
                        "<BODY>\n" +
                        "<p><b>General chess rules:</b><br><br>\n" +
                        "\n" +
                        "<b>1.</b>  All FIDE rules apply as on 1st January 2016 unless otherwise mentioned.<br>\n" +
                        "\n" +
                        "<b>2.</b> Touch to move<br>\n" +
                        "\n" +
                        "<b>3.</b> Clock rules<br>\n" +
                        "\n" +
                        "<b>4.</b> Illegal move<br>\n" +
                        "\n" +
                        "<b>5.</b> Winning on time<br>\n" +
                        "\n" +
                        "<b>6. Rules of draw:</b><br><br>\n" +
                        "\n" +
                        "<b>o</b>Draw by offer<br>\n" +
                        "<b>o</b>Draw by threefold repetition<br>\n" +
                        "<b>o</b>50-move rule<br>\n" +
                        "<b>o</b>Stalemate<br>\n" +
                        "<b>o</b>Impossibility of checkmate<br>\n" +
                        "\n" +
                        "Players do not need to point out a &#39;check&#39; to the opponent.\n" +
                        "\n" +
                        "Rules are same for every category.<br><br>\n" +
                        "\n" +
                        "<b>Tournament rules and information:</b><br><br>\n" +
                        "\n" +
                        "<b>1.</b>The board order of players should be given beforehand to the committee.<br>\n" +
                        "\n" +
                        "<b>2.</b>No argument allowed (Even if violation of any rule is noticed by spectators).<br>\n" +
                        "\n" +
                        "<b>3.</b>Walkover will be given to the player if his/her opponent does not turn up in 10 minutes after the\n" +
                        "\n" +
                        "round has started.<br>\n" +
                        "\n" +
                        "<b>4.Winning prize:</b>\n" +
                        "\n" +
                        "Trophy for winner and runner up(for each category)<br>\n" +
                        "\n" +
                        "<b>5.</b>time control will be decided after registrations.</p><br>\n" +
                        "</BODY></HTML>";
                rules.loadData(chess_rules, "text/html", "UTF-8");
                studentOneImage.setImageResource(R.drawable.abhishek_chess);
                facultyImage.setImageResource(R.drawable.harish_chess);
                type.setText("None");
                venue.setText("MPH Chess Room");

            }
            break;
            case "Carrom": {
                title.setText(data);

                studentOneName.setText("Pratiksha\nEE/4th yr");
                studentTwoName.setText("Vivek Sharma\nIT/4th yr");
                facultyName.setText("Mr. Nirmal Kumar Agarwal\nAP-EE");
                facualtyCoordinatorTwo.setVisibility(View.GONE);

                studentOneContact.setText("8174890719");
                studentTwoContact.setText("9643014226");
                studentOneImage.setImageResource(R.drawable.pratiksha_carrom);
                studentTwoImage.setImageResource(R.drawable.vivek_carrom);
                facultyImage.setImageResource(R.drawable.nirmal);

                studentCoordinatorThree.setVisibility(View.GONE);
                String carrom_rules ="<HTML>\n" +
                        "<BODY>\n" +
                        "<p><b><o/b> If the striker goes into the pocket, the player loses a chance and one of his\n" +
                        "\n" +
                        "pocketed pieces.<br>\n" +
                        "\n" +
                        "<b>o</b> If a coin and the striker goes into the pocket at the same time, then player\n" +
                        "\n" +
                        "loses that particular pocketed coin and does not get a chance for pocketing it.<br>\n" +
                        "\n" +
                        "<b>o</b> The player is not allowed to move or get up from his chair while shooting.<br>\n" +
                        "\n" +
                        "<b>o</b> If a piece falls off from the carrom board, it should be placed in the centre.<br>\n" +
                        "\n" +
                        "<b>o</b> Only the players&#39; wrist is allowed to touch the carrom board and not any other\n" +
                        "\n" +
                        "part of the body or hand.<br>\n" +
                        "\n" +
                        "<b>o</b> Players are not allowed to change sides once the game has begun.<br>\n" +
                        "\n" +
                        "<b>o</b> If the striker fails to leave both the lines, i.e. does not move in a single strike,\n" +
                        "\n" +
                        "the player gets 3 chances before he loses his turn.<br>\n" +
                        "<b>o</b> The thumb can be used for backward shots \n"+
                        "</p>\n" +
                        "</BODY></HTML>";
                rules.loadData(carrom_rules, "text/html", "UTF-8");
                type.setText("Singles , Doubles , Mixed");
                venue.setText("MPH Carrom Room");

            }
            break;
            case "Tug Of War": {
                title.setText(data);
                studentOneName.setText("Gaurav Kumar\nMCA/3rd yr");
                studentTwoName.setText("Rishabh Gupta\nIT/4th yr");
                studentCoordinatorThree.setVisibility(View.GONE);

                facultyName.setText("Mr. Ankur Garg\nAP-Hum");
                facultyImage.setImageResource(R.drawable.ankur_tug);
                studentOneImage.setImageResource(R.drawable.gaurav_kumar);
                studentTwoImage.setImageResource(R.drawable.rishabh_tug);

                studentOneContact.setText("8081077326");
                studentTwoContact.setText("7017132991");


                String tugofwarrules = "<HTML><BODY>" +
                        "<b>1.</b>No. of players will be 8 (4 boys and 3 girls).\n<br>" +
                        "<b>2.</b>The rope is marked with a \"centre line\" and two markings 4 metres (13 ft) either side of the centre line.\n<br>" +
                        "<b>3.</b>The teams start with the rope's centre line directly above a line marked on the ground, and once the contest has started,pull the other team such that the marking on the rope closest to their opponent crosses the centre line, or the opponents commit a foul (such as a team member sitting or falling down).\n<br>" +
                        "<b>4.</b>Lowering one's elbow below the knee during a 'pull' - known as 'Locking' - is a foul, as is touching the ground for extended periods of time.\n<br>" +
                        "<b>5.</b>The rope must go under the arms; actions such as pulling the rope over the shoulders may be considered a foul.<br>" +
                        "</BODY></HTML>";
                rules.loadData(tugofwarrules, "text/html", "UTF-8");
                facualtyCoordinatorTwo.setVisibility(View.GONE);
                type.setText("None");
                venue.setText("Outdoor-NEAR VOLLEY BALL COURT");

            }
            break;
            case "Cricket": {
                title.setText(data);
                studentOneName.setText("Amardeep Singh\nCE/4th yr");
                studentTwoName.setText("Birendra Yadav\nCE/4th yr");
                studentThreeName.setText("Abhishek Tiwari\nEEE/4th yr");
                facultyName.setText("Mr. Vikas Kumar Singla\nAP-ME");
                studentOneContact.setText("7291084488");
                studentTwoContact.setText("9871505703");
                studentThreeContact.setText("7042279702");
                studentOneImage.setImageResource(R.drawable.amardeep_cricket);
                studentTwoImage.setImageResource(R.drawable.birendra_cricket);
                studentThreeImage.setImageResource(R.drawable.abhishek_cricket);
                facultyImage.setImageResource(R.drawable.vikas_kumar_singla);

                String cricketrules = "<HTML><BODY>" +
                        "<b>1.Rules for student matches.\n\n</b><br><br>" +
                        "<b>a-</b> will be of 3 overs per side.\n<br>" +
                        "<b>b-</b>There will be 6 players per side which includes 4 boys and 2 girls.\n<br>" +
                        "<b>c-</b> 1 over shall be declared as power play by batting side,there should be atleast 1 girl in power play at any of the end.\n<br>" +
                        "<b>d-</b> Boys can hit 6 runs only in power play over,in other overs it shall declared as out.\n<br>" +
                        "<b>e-</b> Final and semi-finals will be of 4 over(1 power play)\n<br>" +
                        "<b>f-</b> There is no restrictions for girls in non power play overs\n<br>" +
                        "<b>g-</b> Bowling should be underarm for girls and ball bowled above waist height shall be given as no ball followed by free hit.\n<br>" +
                        "<b>h-</b> 2 tip ball is allowed for girl 3 tip ball will be declared as dead ball.\n<br>" +
                        "<b>i-</b> Eight runs rule will be explained during starting of match.\n<br>" +
                        "<b>j-</b> Only a girl bowler can ball overarm ball to girl.\n<br>" +
                        "<b>k-</b> Team if not arrived within 10 minutes after scheduled match time will be disqualified.\n<br>" +
                        "<b>l-</b> Umpire's decision is final.\n<br>" +
                        "<b>m-</b> All other international rules are applicable.\n<br>" +
                        "\n<br>" +
                        "\n<br>" +

                        "<b>2- Faculty matches\n</b><br><br>" +
                        "\n" +
                        "<b>a-</b> 11 players per side.\n<br>" +
                        "<b>b-</b> 6 over inning per side.\n<br>" +
                        "<b>c-</b> There will be no power play.\n<br>" +
                        "<b>d-</b> All international common rules are applicable(leg before wicket is not included).\n<br>" +
                        "<b>e-</b>Final will be of 8 overs.<br>" +
                        "</BODY></HTML>";
                rules.loadData(cricketrules, "text/html", "UTF-8");
                type.setText("None");
                venue.setText("Outdoor-CRICKET GROUND");

                facualtyCoordinatorTwo.setVisibility(View.GONE);

            }
            break;
            case "Football": {
                title.setText(data);
                studentOneName.setText("Sanket Tripathi\nEE/4th yr");
                facultyName.setText("Mr.Bhupesh Aneja\nAP-IC");
                studentOneContact.setText("8826122623");
                studentOneImage.setImageResource(R.drawable.sanket_football);
                facultyImage.setImageResource(R.drawable.bhu_foot);
                type.setText("None");
                venue.setText("Outdoor-FOOTBALL GROUND");
                String football_rules ="<HTML>\n" +
                        "<BODY>\n" +
                        "<p>\n" +
                        "o Each Team Consist Of 7 Players (Boys) And 5 Players (Girls).<br>\n" +
                        "\n" +
                        "                       <b>o</b> For Boys Game 6 Players Will Be Playing With One Subsitute On Bench.<br>\n" +
                        "\n" +
                        "                       <b>o</b> For Girls Game 5 Players Will Be Playing.<br>\n" +
                        "                        \n" +
                        "                        <b>o</b> Hockey Size Goal Post Will Be there.<br>\n" +
                        "\n" +
                        "                       <b>o</b> The Entire Team Member Must Be In Proper Kit With Shin Pads.<br>\n" +
                        "\n" +
                        "                       <b>o</b> All The Team Member Must Has Same Colour Jersey And The Colour Must Be Specified To Officials Prior To Match.<br>\n" +
                        "\n" +
                        "                        <b>o</b> Match Will Be Played In Two Half With 15 Minutes Each For Boys And 10 Minutes Each For Girls .duration Can Be Altered If Situation Demands By Management And Officials.<br>\n" +
                        "                        \n" +
                        "                       <b>o</b> In Case Of Draw No Extra Time Will Be There And Winners Will Be Decided By Penalty Shootouts.<br>\n" +
                        "                        <b>o</b> Team Has To Report On The Field 20 Minutes Prior To There Match.<br>\n" +
                        "\n" +
                        "                        <b>o</b> Any Misconduct On The Field Will Lead To Disqualification Of The Team.<br>\n" +
                        "                        \n" +
                        "                        <b>o</b> No Player Can Play From Two Teams, If Found Both The Teams will Be Disqualified.<br>\n" +
                        "\n" +
                        "                        <b>o</b> Refree Decision Is Final .<br>\n" +
                        "\n" +
                        "                        <b>o</b> All Other Rules According To Fifa.<br>\n" +
                        "</p>\n" +
                        "</BODY></HTML>";
                rules.loadData(football_rules, "text/html", "UTF-8");

                studentCoordinatorThree.setVisibility(View.GONE);
                studentCoordinatorTwo.setVisibility(View.GONE);
                facualtyCoordinatorTwo.setVisibility(View.GONE);
            }
            break;
            case "Volleyball": {
                title.setText(data);
                studentOneName.setText("ARPIT GUPTA\nME/4th yr");
                studentTwoName.setText("Sakshi Gupta\nCS/4th yr");
                studentThreeName.setText("Shreya Singh\nEC/4th yr");
                facultyName.setText("Mr. Sukhendra Singh\nAP-IT");
                studentOneContact.setText("9818798956");
                studentTwoContact.setText("9868150252");
                studentThreeContact.setText("8287013429");
                facultyImage.setImageResource(R.drawable.sukh);
                studentOneImage.setImageResource(R.drawable.arpit_volleyball);
                studentTwoImage.setImageResource(R.drawable.sakshi_volleyball);
                studentThreeImage.setImageResource(R.drawable.shreya_volleyball);

                String volleyball_rule="<HTML>\n" +
                        "<BODY>\n" +
                        "<p>\n" +
                        "<b>o</b> Team has 6 players on the court.<br>\n" +
                        "<b>o</b> 3 players are front row players and 3 of them are back row players.<br>\n" +
                        "\n" +
                        "<b>Contacts:</b><br>\n" +
                        "<b>o</b> Each team is allowed to have maximum of three touches before hitting the ball over the net.<br>\n" +
                        "<b>o</b> Same player can not hit the ball twice in a row.<br>\n" +
                        "\n" +
                        "<b>Antennas:</b><br>\n" +
                        "<b>o</b> It is ALLOWED to play the ball off the net. It is a fault, if the ball contacts net outside antennas.<br>\n" +
                        "<b>o</b> The ball has to travel between the antennas when flying to the other side of the net.<br>\n" +
                        "\n" +
                        "<b>In or Out?</b><br>\n" +
                        "<b>o</b> Referee calls the ball “IN”, if any part of it hits the lines. (Imagine the ball is painted. If the ball left a mark that touches the lines, the ball is judged IN).<br>\n" +
                        "<b>o</b> Referee calls the ball in if any part of it hits the lines.<br>\n" +
                        "<b>o</b> Ball is ruled OUT, if the ball lands outside the boundary lines (without touching the opponent)<br>\n" +
                        "<b>o</b> The ball hits the antenna any of the net or cables outside the antennas.<br>\n" +
                        "\n" +
                        "<b>Contacting the Ball:</b><br>\n" +
                        "<b>o</b> Players are NOT allowed to catch, hold or throw the ball.<br>\n" +
                        "<b>o</b> Players are NOT allowed to hit or block the opponents serve.<br>\n" +
                        "<b>o</b> Attacking ball which is coming over the net is ILLEGAL, if it has NOT broken the plane of the net.<br>\n" +
                        "<b>o</b> In other words the player is ALLOWED to swing the ball when it breaks the plane of the net.<br>\n" +
                        "</p>\n" +
                        "</BODY></HTML>";
                rules.loadData(volleyball_rule, "text/html", "UTF-8");

                //facultyImage.setImageResource(R.drawable.);
                 type.setText("None");
                venue.setText("Outdoor- Volleyball Court");

                facualtyCoordinatorTwo.setVisibility(View.GONE);

            }
            break;

            case "Basketball": {
                title.setText(data);
                studentOneName.setText("Vaibhav Dwivedi\nME/4th yr");
                studentTwoName.setText("Anamika\nEEE/4th yr");
                facultyName.setText("Mr. Chidambara\nAP-Maths");

               studentOneImage.setImageResource(R.drawable.vibhav_basketball);
                studentTwoImage.setImageResource(R.drawable.anamika_basket);
                facultyImage.setImageResource(R.drawable.chidambara);
                //facultyImage2.setImageResource(R.drawable.nikunj_agarwal);
                String basketball_rule="<HTML>\n" +
                        "<BODY>\n" +
                        "<p>\n" +
                        "<b>Event 1 - Full court Match (Boys/Girls)</b><br>\n" +
                        "<b>1.</b> Team can Have 5 playing members and 2 substitutes. (Total 7 Members)<br>\n" +
                        "<b>2.</b> Match will be on full court.<br>\n" +
                        "<b>3.</b> Match will be divided into 4 quarters.<br>\n" +
                        "<b>4.</b> Each quarter will be of 7 minutes.<br>\n" +
                        "<b>5.</b> Standard Basketball Rules apply.<br>\n" +
                        "<b>6.</b> All the members of the team should be present during the match.<br>\n" +
                        "<b>7.</b> If the team fails to report on time, the other team will be declared as winner.<br>\n" +
                        "<b>Event 2 , 3 on 3 basketball (only for boys)</b><br>\n" +
                        "<b>1.</b> Team can have 3 playing members and 1 substitute (Total 4 members).<br>\n" +
                        "<b>2.</b> Match will be on Half Court.<br>\n" +
                        "<b>3.</b> Match will be divided into 2 halves.<br>\n" +
                        "<b>4.</b> Each half will be of mins.<br>\n" +
                        "<b>5.</b> Half-court rules will be applied.<br>\n" +
                        "<b>6.</b> All the members of the team should be present during the match.<br>\n" +
                        "<b>7.</b> If the team fails to report on time, the other team will be declared as winner.<br>\n" +
                        "</p>\n" +
                        "</BODY></HTML>";
                rules.loadData(basketball_rule, "text/html", "UTF-8");


                studentOneContact.setText("9411671910");
                studentTwoContact.setText("9711293662");
                type.setText("None");
                venue.setText("Outdoor-BASKETBALL COURT");
                studentCoordinatorThree.setVisibility(View.GONE);
                facualtyCoordinatorTwo.setVisibility(View.GONE);


            }
            break;
            case "Athelitics": {



            }
            break;


            case "Shot Put": {
                title.setText(data);
                studentOneName.setText("Arnold Lui\nEE/4th yr");
                studentTwoName.setText("Manish Kesharwani\nCS/4th yr");
                facultyName.setText("Mr.Virendara Kumar Verma\nAP-MT");
                facultyName2.setText("Mrs. Sapna Mathur\nAP-Hum");
                studentOneContact.setText("9643023485");
                studentTwoContact.setText("7503942814");
                studentOneImage.setImageResource(R.drawable.arnold_ath);
                studentTwoImage.setImageResource(R.drawable.manish_atheletics);
                facultyImage.setImageResource(R.drawable.virendra_verma);
                facultyImage2.setImageResource(R.drawable.sapna_hum);

                String shotput_rules="<HTML>\n" +
                        "<BODY>\n" +
                        "<p>Competitors take their throw from inside a (7 feet) in diameter, with a toe\n" +
                        "\n" +
                        "board approximately 4&quot; high at the front of the circle. The shot must land\n" +
                        "\n" +
                        "within an angle of approximately 30 degrees. The athlete must rest the\n" +
                        "\n" +
                        "shot in between the neck and shoulder and keep it tight to the neck\n" +
                        "\n" +
                        "while throwing. At the end of the throw, the thrower must push the\n" +
                        "\n" +
                        "throwing arm straight with the thumb pointing down.<br><br>\n" +
                        "\n" +
                        "<b>Fouls:</b><br><br>\n" +
                        "\n" +
                        "<b>1.</b>The shot putters must enter and leave the circle from the rear half of\n" +
                        "\n" +
                        "the circle, or a foul is called.<br>\n" +
                        "\n" +
                        "<b>2.</b>Letting some article of clothing touch the top of the toeboard or\n" +
                        "\n" +
                        "outside the circle, and/or the shot falling outside of the borders to the\n" +
                        "\n" +
                        "left and the right.<br>\n" +
                        "\n" +
                        "<b>3.</b>The distance thrown is measured from the front of the circle to where\n" +
                        "\n" +
                        "the shot lands at its nearest disturbance of the soil.</p><br>\n" +
                        "</BODY></HTML>";
                rules.loadData(shotput_rules,"text/html", "UTF-8");


                type.setText("None");
                studentCoordinatorThree.setVisibility(View.GONE);
                venue.setText("Outdoor-FOOTBALL COURT");

            }
            break;


            case "Kabaddi": {
                title.setText(data);
                studentOneName.setText("Aditya Srivastava\nCS/4th yr");
                studentTwoName.setText("Anshul Singh\nCE/4th yr");
                facultyName.setText("Mr.Yogesh.K.S\nAP-Civil");
                facultyName2.setText("Mr.Bharath Kumar\nAP-Civil");
                studentOneContact.setText("8505982105");
                studentTwoContact.setText("8588898351");
                studentOneImage.setImageResource(R.drawable.aditya_kabaddi);
                studentTwoImage.setImageResource(R.drawable.anshul_kabaddi);
                facultyImage.setImageResource(R.drawable.yogesh);
                facultyImage2.setImageResource(R.drawable.bharat);
                type.setText("None");
                venue.setText("Outdoor-NEAR VOLLEYBALL COURT");
               String kabaddi_rules="<HTML>\n" +
                       "<BODY>\n" +
                       "<p>\n" +
                       "<b>1.</b> Play in a flat, rectangular arena 13 meters (42.7 ft) wide x 10 meters (32.8 ft) long.<br>\n" +
                       "<b>2.</b> Use lines and markings to divide the court appropriately. The following are the\n" +
                       "official court markings as specified for professional Kabaddi; again, if you&#39;re playing\n" +
                       "casually with friends, your markings don&#39;t need to be exact.<br>\n" +
                       "<b>3.</b> Boundary lines: The lines at the edge of the 13 meter x 10 meter court.<br>\n" +
                       "<b>4.</b> Play area lines: These lines mark a 13 meter x 8 meter rectangular area inside the\n" +
                       "court — one meter of space separates each side from the 10 meter boundary lines\n" +
                       "above.<br>\n" +
                       "<b>5.</b> Mid line: This line divides the court into two 6.5 meters (21.3 ft) x 8 meter halves.\n" +
                       "Each team&#39;s &quot;territory&quot; is the play area on its side of the mid line.<br>\n" +
                       "<b>6.</b> Baulk lines: These lines run parallel to the mid line and are 3.75 meters (12.3 ft)\n" +
                       "from it on either side.<br>\n" +
                       "<b>7.</b> Bonus lines: These lines run parallel to the baulk lines and are 1 meter (3.3 ft) from\n" +
                       "them on the side opposite the mid line.<br>\n" +
                       "<b>8.</b> Divide into two teams of seven players each. Traditionally, four players from each team\n" +
                       "take each side of the field, leaving each team with three players held in reserve. However,\n" +
                       "some variations of Kabaddi call for all seven players to take the field at once.<br>\n" +
                       "<b>9.</b> Flip a coin to decide which team will go first.<br>\n" +
                       "<b>10.</b> Send players out when they are tagged, captured, or break a rule. In\n" +
                       "Kabaddi, players can be temporarily sent &quot;out&quot; of play for a variety of reasons. If this\n" +
                       "happens, they may not be replaced by players in reserve — substitutions are only\n" +
                       "made for players who are not out. Below are a list of circumstances in which a player\n" +
                       "may be sent out.<br>\n" +
                       "<b>11.</b> If the raider tags any defending players and makes it back to his side, the players he\n" +
                       "tagged are out.<br>\n" +
                       "<b>12.</b> If a raider is captured and cannot pass back over the midline before he runs out of\n" +
                       "breath, he is out.<br>\n" +
                       "<b>13.</b> If any player (raiding or defending) steps outside the boundary lines, he is out\n" +
                       "(unless he was deliberately pulled or shoved, in which case, the offending player is\n" +
                       "out.)<br>\n" +
                       "<b>14.</b> If a team has three unproductive raids in a row, the third raider is out. An\n" +
                       "unproductive raid occurs when a raider cannot score any points (or loses points)\n" +
                       "during a raid. However, if a raider can cross the baulk line and return to his side of\n" +
                       "the court, the raid counts as a successful one even if he doesn&#39;t tag anyone.<br>\n" +
                       "</p>\n" +
                       "<b>15.</b> If a defending team member enters the raider&#39;s side of the court before his team is\n" +
                       "officially given the chance to raid, he is out.<br>\n" +
                       "<b>16.</b> Score a &quot;Lona&quot; by getting the entire other team out. If you can get the entire\n" +
                       "other team out at once for any combination of reasons and none of their players are\n" +
                       "eligible for revival, your team scores a &quot;Lona&quot; (two extra points for that play.)<br>\n" +

                       "</BODY></HTML>";
                rules.loadData(kabaddi_rules, "text/html", "UTF-8");


                studentCoordinatorThree.setVisibility(View.GONE);

            }
            break;

            case "Fun Games": {
                title.setText(data);
                studentOneName.setText("Shivam Gadgey\nCivil/4th yr");
                studentTwoName.setText("Yamini Saurabh\nECE/4th yr");
                facultyName.setText("Mr.Mehboob Alam\nAP-CS");
                facultyName2.setText("Mr.Ajith\nAP-EEE");
                studentOneContact.setText("9643086941");
                studentTwoContact.setText("8505836816");
                studentOneImage.setImageResource(R.drawable.shivamg_fungames);
                studentTwoImage.setImageResource(R.drawable.yamini_fungames);
                facultyImage.setImageResource(R.drawable.mahboob_alam);
                facultyImage2.setImageResource(R.drawable.ajith);
                String fun_games_rule="<HTML>\n" +
                        "<BODY>\n" +
                        "<p><b>General rules to play fun games:</b><br><br>\n" +
                        "\n" +
                        "<b>o</b>DART -- EACH PARTICIPANT IS ALLOWED TO THROW 5 DARTS ON THE DARTBOARD\n" +
                        "AND THE ONE WITH THE HIGHEST SCORE WILL WIN THE GAME.<br>\n" +
                        "\n" +
                        "<b>o</b>3 SHOTS -- EACH PARTICIPANT IS ALLOWED TO TAKE 3 SHOTS ON THE CASTLE OF CUPS\n" +
                        "FROM THEIR OPPOSITE HANDS.\n" +
                        "THE PARTICIPANT WITH THE HIGHER NUMBER OF DOWN CUPS WILL WIN\n" +
                        "THE GAME.<br>\n" +
                        "\n" +
                        "<b>o</b>BEAT THE TIME -- EACH PARTICIPANT HAS TO SHUFFLE A PACK OF 20 CUPS IN A QUEUE\n" +
                        "ORDER IN SUCH A WAY THAT THE ODD COLOUR CUP COMES BACK TO ITS\n" +
                        "ORIGINAL PLACE.\n" +
                        "THE PARTICIPANT WITH THE LOWEST TIME, WILL BE DECLARED AS A\n" +
                        "WINNER.<br>\n" +
                        "\n" +
                        "<b>o</b>RING TOSS -- EACH PARTICPANT IS ALLOWED TO THROW 3 RINGS ON THE CONES OF\n" +
                        "TWO DIFFERENT COLOURS.\n" +
                        "AFTER PICKING UP THE COLOUR THEY HAVE TO AIM FOR THE CONES OF\n" +
                        "THE SAME COLOUR AND THE POINTS WILL BE AWARDED ACCORDING TO\n" +
                        "THAT." +
                        "</BODY></HTML>";
                rules.loadData(fun_games_rule,"text/html","UTF-8");
                type.setText("Blind Shoot,Dart ,3 Shots ,Basket Shoot ,Ball Bounce");
                venue.setText("Next To Canteen");
                studentCoordinatorThree.setVisibility(View.GONE);

            }
            break;
            case "100m Running": {
                title.setText(data);
                studentOneName.setText("Arnold Lui\nEE/4th yr");
                studentTwoName.setText("Manish Kesharwani\nCS/4th yr");
                facultyName.setText("Mr.Virendara Kumar Verma\nAP-MT");
                facultyName2.setText("Mrs. Sapna Mathur\nAP-Hum");
                studentOneContact.setText("9643023485");
                studentTwoContact.setText("7503942814");
                studentOneImage.setImageResource(R.drawable.arnold_ath);
                studentTwoImage.setImageResource(R.drawable.manish_atheletics);
                facultyImage.setImageResource(R.drawable.virendra_verma);
                facultyImage2.setImageResource(R.drawable.sapna_hum);
                type.setText("None");
                String running_100="<HTML>\n" +
                        "<BODY>\n" +
                        "<p>\n" +
                        "Every 100 meter sprinter must begin the race with his feet in the starting blocks. The\n" +
                        "\n" +
                        "official race starter will call the sprinters to their blocks and on command the runners\n" +
                        "\n" +
                        "will adopt a set position. The set position requires the runners to have both feet in\n" +
                        "\n" +
                        "the blocks and adopt a position with the body weight on their hands.<br><br>\n" +
                        "\n" +
                        "\n" +
                        "<b>False Start</b><br>\n" +
                        "\n" +
                        "A false start is called when the feet of a runner leave the starting blocks before the starter’s\n" +
                        "\n" +
                        "gun. <br><br>\n" +
                        "\n" +
                        "<b>Lanes</b><br>\n" +
                        "\n" +
                        "Any 100 meter sprinter who leaves her lane or obstructs the path of another sprinter will be\n" +
                        "\n" +
                        "automatically disqualified from the race. Stepping on the white lines is ruled as having left\n" +
                        "\n" +
                        "your lane during the race.<br>\n" +
                        "</p>\n" +
                        "</BODY></HTML>";
                rules.loadData(running_100, "text/html", "UTF-8");
                studentCoordinatorThree.setVisibility(View.GONE);
                venue.setText("Outdoor-Football ground");
            }
            break;
            case "200m Running": {
                title.setText(data);
                studentOneName.setText("Arnold Lui\nEE/4th yr");
                studentTwoName.setText("Manish Kesharwani\nCS/4th yr");
                facultyName.setText("Mr.Virendara Kumar Verma\nAP-MT");
                facultyName2.setText("Mrs. Sapna Mathur\nAP-Hum");

                facultyImage.setImageResource(R.drawable.virendra_verma);
                facultyImage2.setImageResource(R.drawable.sapna_hum);
                studentOneImage.setImageResource(R.drawable.arnold_ath);
                studentTwoImage.setImageResource(R.drawable.manish_atheletics);
                studentOneContact.setText("9643023485");
                studentTwoContact.setText("7503942814");
                String running_200="<HTML>\n" +
                        "<BODY>\n" +
                        "<p>\n" +
                        "Every 200 meter sprinter must begin the race with his feet in the starting blocks. The\n" +
                        "\n" +
                        "official race starter will call the sprinters to their blocks and on command the runners\n" +
                        "\n" +
                        "will adopt a set position. The set position requires the runners to have both feet in\n" +
                        "\n" +
                        "the blocks and adopt a position with the body weight on their hands.<br><br>\n" +
                        "\n" +
                        "\n" +
                        "<b>False Start</b><br>\n" +
                        "\n" +
                        "A false start is called when the feet of a runner leave the starting blocks before the starter’s\n" +
                        "\n" +
                        "gun. <br><br>\n" +
                        "\n" +
                        "<b>Lanes</b><br>\n" +
                        "\n" +
                        "Any 200 meter sprinter who leaves her lane or obstructs the path of another sprinter will be\n" +
                        "\n" +
                        "automatically disqualified from the race. Stepping on the white lines is ruled as having left\n" +
                        "\n" +
                        "your lane during the race.<br>\n" +
                        "</p>\n" +
                        "</BODY></HTML>";
                rules.loadData(running_200, "text/html", "UTF-8");
                type.setText("None");
                studentCoordinatorThree.setVisibility(View.GONE);
                venue.setText("Outdoor-Football ground");
            }
            break;
            case "4x100m Relay": {
                title.setText(data);
                studentOneName.setText("Arnold Lui\nEE/4th yr");
                studentTwoName.setText("Manish Kesharwani\nCS/4th yr");
                facultyName.setText("Mr.Virendara Kumar Verma\nAP-MT");
                facultyName2.setText("Mrs. Sapna Mathur\nAP-Hum");
                studentOneContact.setText("9643023485");
                studentTwoContact.setText("7503942814");
                studentOneImage.setImageResource(R.drawable.arnold_ath);
                studentTwoImage.setImageResource(R.drawable.manish_atheletics);
                type.setText("None");
                facultyImage.setImageResource(R.drawable.virendra_verma);
                facultyImage2.setImageResource(R.drawable.sapna_hum);
                studentCoordinatorThree.setVisibility(View.GONE);
                String relay_rules="<HTML>\n" +
                        "<BODY>\n" +
                        "<p>\n" +
                        "Athletes are required to cover a distance of 400m as a team of 4 athletes. Placed equidistantly(100m) apart. The team that touches the Finish Line first will be the winner.\n" +
                        "(Changing of Lanes during the race is not allowed)</p><br>\n" +
                        "</BODY></HTML>";
                venue.setText("Outdoor-Football-ground");
                rules.loadData(relay_rules,"text/html","UTF-8");
            }
            break;
//            case "100m Three Legged Race": {
//                title.setText(data);
//                studentOneName.setText("Sudhanshu Rai (EE/4th yr)");
//
//                facultyName.setText("Dr. Kushalendraprathap Singh\nAP-PHYSICS");
//                studentOneContact.setText("9643461248");
//
//                type.setText("None");
//                studentOneImage.setImageResource(R.drawable.sudhanshu_three_legged);
//                //studentTwoImage.setImageResource(R.drawable.bulusu);
//               /* rules.setText("");*/
//                String legrace_rules="<HTML>\n" +
//                        "<BODY>\n" +
//                        "<p>\n" +
//                        "<b>No. Of players:</b> 2 per team<br>\n" +
//                        "<b>No. Of round:</b> Heats, semifinals and final<br>\n" +
//                        "<b>Track length:</b> 100m<br>\n" +
//                        " <b>Winning positions:</b> 1 st , 2 nd &amp; 3 rd<br>\n" +
//                        "<b>Rules:</b><br>\n" +
//                        "<b>1.</b> The players will stand next to each other, then the partners&#39; inside legs (the right leg of the partner on the left and the left leg of the partner on the right) will be tied together.<br>" +
//                        "\n" +
//                        "<b>2.</b> The teams are not allowed to change tracks at any point of time during the race, This will lead to disqualification.<br>" +
//                        "\n" +
//                        "<b>3.</b> No disqualification in case the players fall during the race, they can resume from the same point.<br>" +
//                        "\n" +
//                        "<b>4.</b> The team mates should preferably be of same height and built.<br>" +
//                        "\n" +
//                        "<b>5.</b> The first three teams to cross the finishing line will qualify for the next round.<br>"+                        "</p>\n" +
//                        "</BODY></HTML>";
//                rules.loadData(legrace_rules, "text/html", "UTF-8");
//
//                //facultyImage.setImageResource(R.drawable.kaushlendra_pratap_singh);
//                //studentOneImage.setImageResource(R.drawable.sudhanshu_three_legged);
//                facualtyCoordinatorTwo.setVisibility(View.GONE);
//                studentCoordinatorThree.setVisibility(View.GONE);
//                venue.setText("Outdoor-Football ground");
//            }
//            break;
        }
    }
}


