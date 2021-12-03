package com.example.newsapp;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsAPI {

    @GET("v2/everything?q=tesla&from=2021-12-3&sortBy=publishedAt&apiKey=574ac20270b9406599aea32eec05ff46")
    Observable <NewsApp> getNewsList();
    @GET("v2/everything?from=2021-12-3&sortBy=publishedAt&apiKey=574ac20270b9406599aea32eec05ff46")
    Observable <NewsApp> getNewsByKeyWord (@Query("q") String keyWord);


}
