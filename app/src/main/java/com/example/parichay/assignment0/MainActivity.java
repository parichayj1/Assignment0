package com.example.parichay.assignment0;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.view.ViewGroupOverlay;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static final String url = "http://agni.iitd.ernet.in/cop290/assign0/register/";
    private Button submit;
    public static final String tn = "teamname";
    public static final String e1 = "entry1";
    public static final String n1 = "name1";
    public static final String e2 = "entry2";
    public static final String n2 = "name2";
    public static final String e3 = "entry3";
    public static final String n3 = "name3";

    private EditText text1, text2, text3, text4, text5, text6, text7;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = (Button) findViewById(R.id.button);

        EditText text1 = (EditText) findViewById(R.id.editText1);
        EditText text2 = (EditText) findViewById(R.id.editText2);
        EditText text3 = (EditText) findViewById(R.id.editText3);
        EditText text4 = (EditText) findViewById(R.id.editText4);
        EditText text5 = (EditText) findViewById(R.id.editText5);
        EditText text6 = (EditText) findViewById(R.id.editText6);
        EditText text7 = (EditText) findViewById(R.id.editText7);

        submit.setOnClickListener(this);
    }

    public Map<String, String> register(){

        final String team = text1.getText().toString();
        final String entry1 = text2.getText().toString();
        final String name1 = text3.getText().toString();
        final String entry2 = text4.getText().toString();
        final String name2 = text5.getText().toString();
        final String entry3 = text6.getText().toString();
        final String name3 = text7.getText().toString();

        StringRequest s1 = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                               @Override
                                public void onResponse(String response) {
                                Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();
                        }
                  },
                        new Response.ErrorListener() {
                             public void onErrorResponse(VolleyError error) {
                             Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                         }
                        }
        ){
            Map<String, String> getparams(){
                Map<String, String> params=new HashMap<String, String>();
                params.put(tn, team);
                params.put(e1, entry1);
                params.put(n1, name1);
                params.put(e2, entry2);
                params.put(n2, name2);
                params.put(e3, entry3);
                params.put(n3, name3);
                return params;
            }
        };

        RequestQueue rq = Volley.newRequestQueue(this);
        rq.add(s1);
    }

    public void click(View v){
        if(v == submit) {
            register();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
