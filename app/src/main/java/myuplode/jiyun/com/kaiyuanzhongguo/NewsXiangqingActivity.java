package myuplode.jiyun.com.kaiyuanzhongguo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.thoughtworks.xstream.XStream;

import java.io.InputStream;

import myuplode.jiyun.com.kaiyuanzhongguo.connecter.Search_Interface;
import myuplode.jiyun.com.kaiyuanzhongguo.manager.News;
import myuplode.jiyun.com.kaiyuanzhongguo.manager.Oschina;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2017/4/6.
 */

public class NewsXiangqingActivity extends Activity {

    private WebView news_XiangQing_webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_xiangqing_view);
        news_XiangQing_webView = (WebView) findViewById(R.id.news_xiangQing_webView);
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);

        //设置WebView属性，能够执行Javascript脚本
        news_XiangQing_webView.getSettings().setJavaScriptEnabled(true);

        news_XiangQing_webView.loadUrl("http://www.oschina.net/action/api/news_detail?id=" + id);
        //设置Web视图
        news_XiangQing_webView.setWebViewClient(new HelloWebViewClient());
    }

    @Override
    //设置回退
    //覆盖Activity类的onKeyDown(int keyCoder,KeyEvent event)方法
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && news_XiangQing_webView.canGoBack()) {
            news_XiangQing_webView.goBack(); //goBack()表示返回WebView的上一页面
            return true;
        }
        return false;
    }

    //Web视图
    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    public void getUrl(InputStream inputStream){
        XStream xStream=new XStream();
        xStream.alias("oschina", Oschina.class);
        xStream.alias("news", News.class);
    }

    public void getRequest(int id){
        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://www.oschina.net/").build();
        Search_Interface search_interface = retrofit.create(Search_Interface.class);
        search_interface.getXiangQing(id+"").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                InputStream inputStream = response.body().byteStream();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
