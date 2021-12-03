package com.example.newsapp;

import com.google.gson.annotations.SerializedName;

public class Source {


    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;


    public void setId (String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;

    }

    public String getName() {
        return this.name;
    }

}

