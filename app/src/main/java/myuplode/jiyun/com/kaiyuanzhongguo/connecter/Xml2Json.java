package myuplode.jiyun.com.kaiyuanzhongguo.connecter;

import java.io.InputStream;

/**
 * Created by Administrator on 2017/4/6.
 */

public interface Xml2Json {
    void getBean(InputStream inputStream);

    String getInpuStream(String url, String content, String pageIndex, String pageSize);
}
