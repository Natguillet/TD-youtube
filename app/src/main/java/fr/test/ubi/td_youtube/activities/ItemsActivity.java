package fr.test.ubi.td_youtube.activities;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import fr.test.ubi.td_youtube.Constants;
import fr.test.ubi.td_youtube.R;
import fr.test.ubi.td_youtube.adapters.ItemsRecyclerAdapter;
import fr.test.ubi.td_youtube.interfaces.OnVideoSelectedListener;
import fr.test.ubi.td_youtube.models.ItemsVideo;
import fr.test.ubi.td_youtube.models.Video;

public class ItemsActivity extends AppCompatActivity implements OnVideoSelectedListener {

    private static final String SEARCH_URL = "https://www.googleapis.com/youtube/v3/search?part=snippet&type=video&maxResults=14&q=";
    private RecyclerView recyclerView;
    private Button searchButton;
    private String keyWord;
    private SharedPreferences sharedPref;
    private AutoCompleteTextView autoText;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        searchButton = (Button) findViewById(R.id.buttonSearch);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        autoText = (AutoCompleteTextView) findViewById(R.id.search);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        autoText.setAdapter(adapter);
        sharedPref = this.getPreferences(this.MODE_PRIVATE);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LoadPreferences();
        searchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                keyWord = autoText.getText().toString();
                keyWord = keyWord.replaceAll(" ","+");

                adapter.add(keyWord);
                adapter.notifyDataSetChanged();
                SavePreferences("LISTS",keyWord);

                getVideos();
            }
        });
    }

    private void getVideos(){
        final StringRequest objectsRequest = new StringRequest(SEARCH_URL+ keyWord + "&key=" + Constants.API_KEY, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //parse data from webservice to get Contracts as Java object

                ItemsVideo itemsVideo = new Gson().fromJson(response, ItemsVideo.class);

                setAdapter(itemsVideo);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Objects", "Error");
            }
        });
        Volley.newRequestQueue(this).add(objectsRequest);
    }
    private void setAdapter(ItemsVideo itemsVideo){
        ItemsRecyclerAdapter adapter = new ItemsRecyclerAdapter(itemsVideo);
        adapter.setOnVideoSelectedListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onVideoSelected(Video video) {
        System.out.println(video.getId().getVideoId());
        DetailsActivity.start(this, video.getId().getVideoId());
    }

    protected void SavePreferences(String key, String value) {
        SharedPreferences data = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = data.edit();
        editor.putString(key, value);
        editor.commit();


    }
    protected void LoadPreferences(){
        SharedPreferences data = PreferenceManager.getDefaultSharedPreferences(this);
        String dataSet = data.getString("LISTS", "None Available");

        adapter.add(dataSet);
        adapter.notifyDataSetChanged();
    }

}
