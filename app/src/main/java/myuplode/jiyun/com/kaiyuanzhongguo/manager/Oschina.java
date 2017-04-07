package myuplode.jiyun.com.kaiyuanzhongguo.manager;

import java.util.List;

/**
 * Created by Administrator on 2017/4/5.
 */

public class Oschina {
    private int catalog;
    private int newsCount;
    private int pagesize;
    private List<News> newlist;

    public int getCatalog() {
        return catalog;
    }

    public void setCatalog(int catalog) {
        this.catalog = catalog;
    }

    public int getNewsCount() {
        return newsCount;
    }

    public void setNewsCount(int newsCount) {
        this.newsCount = newsCount;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }
}
