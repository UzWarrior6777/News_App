package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        progressDialog = ProgressDialog.show(this, "Loading", "please wait", true);
        NewsAPI newsApi = RetrofitClientInstance.getRetrofit().create(NewsAPI.class);
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(newsApi.getNewsList()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(response ->{
            progressDialog.dismiss();
//            response.getArticles().get(0).getAuthor();
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            NewsAppAdapter newsAppAdapter = new NewsAppAdapter(this, response.getArticles(), new NewsAppAdapter.Clicklistener() {
                @Override
                public void OnClick(String url) {

                    Intent intent = new Intent(MainActivity.this, Url_Layout_Activity.class);
                    intent.putExtra("url", url);
                    startActivity(intent);

                }
            });
            recyclerView.setAdapter(newsAppAdapter);
        }));




    }
}