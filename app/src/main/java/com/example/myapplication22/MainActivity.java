package com.example.myapplication22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private ArrayList<wthrdata> data;
    ListView listView;
    wthrdata mydata = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dummydata();
        //data.add(new wthrdata(mydata.getMax(),mydata.getMin()));
        //Log.i("maxxxxx",mydata.getMax());
        /*listView=findViewById(R.id.Listview);
        adapter myadapter=new adapter(this,R.layout.singleitem,data);
        listView.setAdapter(myadapter);*/



        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, selectedItem, Toast.LENGTH_SHORT).show();

            }
        });*/

        // button.setOnClickListener(new View.OnClickListener() {
         //   @Override
         //   public void onClick(View v) {
          //      openactivity2();
         //   }
       // });
    }
    //public void openactivity2(){
      //  Intent intent = new Intent(this, MainActivity2.class);
     //   startActivity(intent);
    //}
    public void dummydata()
    {
       data = new ArrayList<>();
        //data.add(new wthrdata("56","54"));
        String apikey="d4e61bdbeda57de0cdacf422af84b8dc";
        String url="https://api.openweathermap.org/data/2.5/weather?q=karachi&appid=d4e61bdbeda57de0cdacf422af84b8dc";
        RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest request= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject object=response.getJSONObject("main");
                    String max=object.getString("temp_max");
                    String min=object.getString("temp_min");

                    data.add(new wthrdata(max,min));

                    listView=findViewById(R.id.Listview);
                    adapter myadapter=new adapter(getApplicationContext(),R.layout.singleitem,data);
                    listView.setAdapter(myadapter);



                    System.out.println(max);
                } catch (JSONException e) {
                    Toast.makeText(MainActivity.this, "in catch", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(request);
    }
}