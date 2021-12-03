package com.example.newsapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.zip.Inflater;

public class NewsAppAdapter extends RecyclerView.Adapter<NewsAppAdapter.Viewholder> {

    List<Articles> articles;
    Context context;
    private Clicklistener clicklistener;
    private LayoutInflater inflater;

    public NewsAppAdapter(Context context,
                          List<Articles> articles, Clicklistener clicklistener) {

        this.articles = articles;
        this.context = context;
        this.clicklistener = clicklistener;
        inflater = LayoutInflater.from(context);

    }


    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View veiw = inflater.inflate(R.layout.activity_news_app, parent, false);
        return new Viewholder(veiw);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, @SuppressLint("RecyclerView") int position) {
        String newsLocaltime = articles.get(position).getPublishedAt();
        String newstitle = articles.get(position).getTitle();
        String newsAuthor = articles.get(position).getAuthor();
        String descriptionNews = articles.get(position).getDescription();

        Glide
                .with(context)
                .load(articles.get(position).getUrlImage())
                .centerCrop()
                .placeholder(R.drawable.daryo)
                .into(holder.newsPhoto);

        holder.news_time.setText(newsLocaltime);
        holder.details_news.setText(descriptionNews);
        holder.title_news.setText(newstitle);
        holder.author_news.setText(newsAuthor);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicklistener.OnClick(articles.get(position).getUrl());
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ImageView newsPhoto;
        TextView title_news;
        TextView news_time;
        TextView author_news;
        TextView details_news;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            newsPhoto = (ImageView) itemView.findViewById(R.id.newsPhoto);
            news_time = itemView.findViewById(R.id.news_time);
            title_news = itemView.findViewById(R.id.title_news);
            author_news = itemView.findViewById(R.id.author_news);
            details_news = itemView.findViewById(R.id.details_news);
        }
    }

    public interface Clicklistener {
        void OnClick(String url);

    }
}
