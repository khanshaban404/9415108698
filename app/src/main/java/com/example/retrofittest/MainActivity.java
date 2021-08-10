package com.example.retrofittest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_data;
    List<DemoDataModel.DataList> list;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_data = findViewById(R.id.rv_data);
        data();


    }

    private void bindData() {
         manager = new LinearLayoutManager(MainActivity.this);
        adapter = new DemoDataAdapter(this, list);
        rv_data.setLayoutManager(manager);
        rv_data.setAdapter(adapter);

    }

    private void data() {

        Map<String, String> header = new HashMap<>();
        header.put("access-token", "4cc09295beda56a8f0888a2ef4b74a198f9d5739eaf1c59fbead86ac9223c365");
        header.put("Accept", "application/json");
        header.put("Content-Type", "application/json");

        WebApi webApi = RetrofitRequest.getClient().create(WebApi.class);

        Call<DemoDataModel> call = webApi.getDemoData(header);
        call.enqueue(new Callback<DemoDataModel>() {
            @Override
            public void onResponse(Call<DemoDataModel> call, Response<DemoDataModel> response) {
                if (response.code() == 200 && response.body()!= null){
                    list = response.body().getData();
                    bindData();
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<DemoDataModel> call, Throwable t) {

            }
        });
    }
}