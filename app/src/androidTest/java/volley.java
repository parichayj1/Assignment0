import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.parichay.assignment0.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Parichay on 1/17/2016.
 */
public class volley extends Activity {
    Button submit;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = (Button) findViewById(R.id.button);

        submit.setOnClickListener(new View.OnClickListener()){
            public void onclick(View v){

            }
        }


        EditText text1 = (EditText) findViewById(R.id.editText1);
        String team = text1.getText().toString();

        EditText text2 = (EditText) findViewById(R.id.editText2);
        String entry1 = text2.getText().toString();

        EditText text3 = (EditText) findViewById(R.id.editText3);
        String name1 = text3.getText().toString();

        EditText text4 = (EditText) findViewById(R.id.editText4);
        String entry2 = text4.getText().toString();

        EditText text5 = (EditText) findViewById(R.id.editText5);
        String name2 = text5.getText().toString();

        EditText text6 = (EditText) findViewById(R.id.editText6);
        String entry3 = text6.getText().toString();

        EditText text7 = (EditText) findViewById(R.id.editText7);
        String name3 = text7.getText().toString();
}

    public static class parse {
        public static String[] team;
    public static String[] entry1;
    public static String[] name1;
    public static String[] entry2;
    public static String[] name2;
    public static String[] entry3;
    public static String[] name3;

    private JSONArray teams = null;

    public static final String jsonarray = "output";
    public static final String tn = "team";
    public static final String e1 = "entry1";
    public static final String n1 = "name1";
    public static final String e2 = "entry2";
    public static final String n2 = "name2";
    public static final String e3 = "entry3";
    public static final String n3 = "name3";

    private String jsn;

    public parse(String jsn){
        this.jsn = jsn;
    }

        protected void parsing(){
            JSONObject entries = null;
            try {
                entries = new entries(jsn);
                teams = entries.getJSONArray(jsonarray);
                team = new String[teams.length()];
                entry1 = new String[teams.length()];
                name1 = new String[teams.length()];
                entry2 = new String[teams.length()];
                name2 = new String[teams.length()];
                entry3 = new String[teams.length()];
                name3 = new String[teams.length()];

                for(int i=0; i<teams.length(); i++){
                    JSONObject j = teams.getJSONObject(i);
                    teams[i] = j.getString(tn);
                    entry1[i] = j.getString(e1);
                    name1[i] = j.getString(n1);
                    entry2[i] = j.getString(e2);
                    name2[i] = j.getString(n2);
                    entry3[i] = j.getString(e3);
                    name3[i] = j.getString(n3);
                }
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
        }
}
}