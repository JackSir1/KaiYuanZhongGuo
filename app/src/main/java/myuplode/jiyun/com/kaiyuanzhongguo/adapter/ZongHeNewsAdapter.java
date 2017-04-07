package myuplode.jiyun.com.kaiyuanzhongguo.adapter;

import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;

import java.util.List;

import myuplode.jiyun.com.kaiyuanzhongguo.NewsXiangqingActivity;
import myuplode.jiyun.com.kaiyuanzhongguo.R;
import myuplode.jiyun.com.kaiyuanzhongguo.manager.News;

/**
 * Created by Administrator on 2017/4/5.
 */

public class ZongHeNewsAdapter extends BaseAdapter<News> {

    private Context context;

    public ZongHeNewsAdapter(Context context, int layoutId, List<News> datas) {
        super(context, layoutId, datas);
        this.context = context;
    }

    @Override
    public void convert(ViewHolder holder, final News news) {
        holder.setText(R.id.news_title, news.getTitle());
        holder.setText(R.id.news_body, news.getBody());
        holder.setText(R.id.news_author, "@" + news.getAuthor());
        holder.setText(R.id.news_commentCount, "赞 " + news.getCommentCount() + "");


        holder.setOnclickListener(R.id.shabi, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = news.getId();
                Intent intent = new Intent(context, NewsXiangqingActivity.class);
                intent.putExtra("id", id);
                context.startActivity(intent);
            }
        });
    }


}
