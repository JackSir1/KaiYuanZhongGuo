package myuplode.jiyun.com.kaiyuanzhongguo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.thoughtworks.xstream.XStream;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import myuplode.jiyun.com.kaiyuanzhongguo.R;
import myuplode.jiyun.com.kaiyuanzhongguo.adapter.SearchAdapter;
import myuplode.jiyun.com.kaiyuanzhongguo.connecter.Search_Interface;
import myuplode.jiyun.com.kaiyuanzhongguo.connecter.Xml2Json;
import myuplode.jiyun.com.kaiyuanzhongguo.manager.SearchBean;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2017/4/6.
 */

public class SearchBlog_ContentFragment extends Fragment implements Xml2Json {
    private PullToRefreshRecyclerView recyclerView;
    private List<SearchBean.ResultBean> list;
    private SearchAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.searche_fragment_view, null);
        recyclerView = (PullToRefreshRecyclerView) inflate.findViewById(R.id.search_View);
        list = new ArrayList<>();
        adapter = new SearchAdapter(getContext(), R.layout.search_adapter_view, list);

        recyclerView.setLoadingMoreEnabled(true);
        recyclerView.setPullRefreshEnabled(true);
        return inflate;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {
                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setRefreshComplete();
                    }
                }, 3000);
            }

            @Override
            public void onLoadMore() {
                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setLoadMoreComplete();
                        //模拟加载数据的情况

                        //news_adapter.notifyDataSetChanged();
                    }
                }, 3000);
            }
        });
    }

    @Override
    public void getBean(InputStream inputStream) {
        SearchBean searchBean = new SearchBean();
        XStream xStream = new XStream();
        xStream.alias("oschina", SearchBean.class);
        xStream.alias("result", SearchBean.ResultBean.class);
        searchBean = (SearchBean) xStream.fromXML(inputStream);
        List<SearchBean.ResultBean> results = searchBean.getResults();
        if (!results.isEmpty()) {
            list.addAll(results);
            adapter.notifyDataSetChanged();
        }

    }

    @Override
    public String getInpuStream(String url, String content, String pageIndex, String pageSize) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(url).build();
        Search_Interface search_interface = retrofit.create(Search_Interface.class);
        search_interface.getContent("blog", content, pageIndex, pageSize).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                InputStream inputStream = response.body().byteStream();
                getBean(inputStream);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
        return null;
    }
}
