package myuplode.jiyun.com.kaiyuanzhongguo.manager;

/**
 * Created by Administrator on 2017/4/5.
 */

public class News {
    private int id;
    private String title;
    private String body;
    private int commentCount;
    private String author;
    private int authorid;
    private String pubDate;
    private String url;

    public int getAuthorid() {
        return authorid;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getBody() {
        return body;
    }

    public String getPubDate() {
        return pubDate;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
