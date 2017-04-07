package myuplode.jiyun.com.kaiyuanzhongguo.connecter;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/4/6.
 */

public interface Search_Interface {

    @GET("action/api/search_list")
    Call<ResponseBody> getContent(@Query("catalog") String catalog, @Query("content") String content, @Query("pageIndex") String pageIndex, @Query("pageSize") String pageSize);

    @GET("action/api/news_detail")
    Call<ResponseBody> getXiangQing(@Query("id") String id);
}
