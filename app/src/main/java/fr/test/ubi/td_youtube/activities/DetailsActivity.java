package fr.test.ubi.td_youtube.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import fr.test.ubi.td_youtube.Constants;
import fr.test.ubi.td_youtube.R;
import fr.test.ubi.td_youtube.models.ItemsDetails;
import fr.test.ubi.td_youtube.models.ItemsVideo;

public class DetailsActivity extends AppCompatActivity {

    private static final String SEARCH_URL = "https://www.googleapis.com/youtube/v3/videos?part=snippet&id=";
    private  static final String VIDEO = "VIDEO";
    private String videoId;
    private TextView description;

    public static void start(Context context, String videoId) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(VIDEO, videoId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        videoId= getIntent().getStringExtra(VIDEO);

        System.out.println(videoId);
        description = (TextView) findViewById(R.id.description);

        getDetails();
    }

    public void getDetails() {
        final StringRequest objectsRequest = new StringRequest(SEARCH_URL+ videoId + "&key=" + Constants.API_KEY, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //parse data from webservice to get Contracts as Java object

                ItemsDetails itemsdetails = new Gson().fromJson(response, ItemsDetails.class);

                System.out.println(itemsdetails.getItems().get(0).getSnippet().getDescription());
                description.setText(itemsdetails.getItems().get(0).getSnippet().getDescription());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Details", "Error");
            }
        });
        Volley.newRequestQueue(this).add(objectsRequest);
    }
}
