package myuplode.jiyun.com.kaiyuanzhongguo.adapter;

;

import android.content.Context;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;

import java.util.List;

import myuplode.jiyun.com.kaiyuanzhongguo.R;
import myuplode.jiyun.com.kaiyuanzhongguo.manager.SearchBean;

/**
 * Created by Administrator on 2017/4/6.
 */

public class SearchAdapter extends BaseAdapter<SearchBean.ResultBean> {
    public SearchAdapter(Context context, int layoutId, List<SearchBean.ResultBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void convert(ViewHolder holder, SearchBean.ResultBean resultBean) {
        holder.setText(R.id.search_title, resultBean.getTitle());
        holder.setText(R.id.search_description, resultBean.getDescription());
    }

}
