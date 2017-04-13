package com.example.kaan.appcent.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.kaan.appcent.Adapter.VenueAdapter;
import com.example.kaan.appcent.Model.SearchResponse;
import com.example.kaan.appcent.Model.Venue;
import com.example.kaan.appcent.R;
import com.example.kaan.appcent.Services.RetroClient;
import com.example.kaan.appcent.Services.RetroInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity extends AppCompatActivity {

    ProgressDialog pd;
    ListView lvPlaces;
    VenueAdapter venueAdapter;
    String client_id = "QO5DI5MP3IMBQNNWDDD0CLPZOEJYIBJWOTLYTBBPBCKV210P";
    String client_secret = "SQGCN3OB3CYNKYSIGKV2NAFR1BX3MFISGWE4WSLDGSUBZKNV";
    String api_version ="20161016";
    String ll;
    SearchResponse searchResponse;
    List<Venue> venue;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        lvPlaces = (ListView) findViewById(R.id.lvPlaces);
        double lat = getIntent().getExtras().getDouble("lat");
        double lng = getIntent().getExtras().getDouble("lng");
        ll = String.valueOf(lat)+","+lng;

        Log.i("INFO", "HAZIR = "+ll);

        pd = new ProgressDialog(ListActivity.this);
        pd.setMessage("Lütfen bekleyin.");
        pd.show();

        RetroInterface retroInterface = RetroClient.getClient().create(RetroInterface.class);
        Call<SearchResponse> call = retroInterface.getVenueJson(client_id,client_secret,api_version,ll);
        call.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                searchResponse = response.body();
                venue = searchResponse.getResponse().getVenues();
                venueAdapter = new VenueAdapter(getApplicationContext(),venue);
                lvPlaces.setAdapter(venueAdapter);
                pd.dismiss();


            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                pd.dismiss();
                Toast.makeText(getApplicationContext(), "BAĞLANTI KURULAMADI", Toast.LENGTH_SHORT).show();
            }
        });

        lvPlaces.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String name = venue.get(position).getName();
                double lat = venue.get(position).getLocation().getLat();
                double lng = venue.get(position).getLocation().getLng();



                Intent goToMaps = new Intent(ListActivity.this, MapsActivity.class);
                goToMaps.putExtra("name", name);
                goToMaps.putExtra("lat",lat);
                goToMaps.putExtra("lng", lng);
                startActivity(goToMaps);
            }
        });



    }
}
