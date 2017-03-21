package fr.test.ubi.td_youtube.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import fr.test.ubi.td_youtube.Constants;
import fr.test.ubi.td_youtube.R;
import fr.test.ubi.td_youtube.models.Items;

public class MainActivity extends AppCompatActivity {

    private static final String SEARCH_URL = "https://www.googleapis.com/youtube/v3/search?part=snippet&type=video&q=";
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getVideos();
    }

    private void getVideos(){
        final StringRequest objectsRequest = new StringRequest(SEARCH_URL+ "hello" + "&key=" + Constants.API_KEY, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //parse data from webservice to get Contracts as Java object

                Items items = new Gson().fromJson(response, Items.class);

                setAdapter(items);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Objects", "Error");
            }
        });
        Volley.newRequestQueue(this).add(objectsRequest);
    }
    private void setAdapter(Items items){
        ObjectRecyclerAdapter adapter = new ObjectRecyclerAdapter(objects); //Mettre la liste des objets
        adapter.setOnContractSelectedListener(this);
        recyclerView.setAdapter(adapter);
    }
}
