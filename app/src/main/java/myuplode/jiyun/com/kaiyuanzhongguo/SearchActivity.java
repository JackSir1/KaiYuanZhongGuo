package myuplode.jiyun.com.kaiyuanzhongguo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import myuplode.jiyun.com.kaiyuanzhongguo.adapter.MyPagerAdapter;
import myuplode.jiyun.com.kaiyuanzhongguo.fragment.SearchBlog_ContentFragment;
import myuplode.jiyun.com.kaiyuanzhongguo.fragment.SearchNews_ContentFragment;
import myuplode.jiyun.com.kaiyuanzhongguo.fragment.SearchPost_ContentFragment;
import myuplode.jiyun.com.kaiyuanzhongguo.fragment.SearchSoftware_ContentFragment;


/**
 * Created by Administrator on 2017/4/6.
 */

public class SearchActivity extends FragmentActivity implements View.OnClickListener {

    private EditText search_et;
    private Button search_btn;
    private TabLayout search_fragment;
    private List<Fragment> fragments;
    private List<String> class_names;
    private MyPagerAdapter adapter;
    private ViewPager viewPager;
    String contentText = null;
    private SearchSoftware_ContentFragment software;
    private SearchPost_ContentFragment post;
    private SearchNews_ContentFragment news;
    private SearchBlog_ContentFragment blog;
    private boolean add_fragment_is = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_view);
        init();
    }

    public void init() {
        viewPager = (ViewPager) findViewById(R.id.search_pager);
        search_et = (EditText) findViewById(R.id.search_connector);
        search_btn = (Button) findViewById(R.id.search_btn);
        search_fragment = (TabLayout) findViewById(R.id.search_fragment);

        fragments = new ArrayList<>();
        class_names = new ArrayList<>();
        adapter = new MyPagerAdapter(getSupportFragmentManager(), fragments, class_names);

        search_btn.setOnClickListener(this);

        viewPager.setAdapter(adapter);
        search_fragment.setupWithViewPager(viewPager);
    }

    public void add_pager() {
        software = new SearchSoftware_ContentFragment();
        post = new SearchPost_ContentFragment();
        news = new SearchNews_ContentFragment();
        blog = new SearchBlog_ContentFragment();

        fragments.add(software);
        fragments.add(post);
        fragments.add(news);
        fragments.add(blog);

        class_names.add("软件");
        class_names.add("问答");
        class_names.add("博客");
        class_names.add("资讯");

        search_fragment.addTab(search_fragment.newTab().setText(class_names.get(0)));
        search_fragment.addTab(search_fragment.newTab().setText(class_names.get(1)));
        search_fragment.addTab(search_fragment.newTab().setText(class_names.get(2)));
        search_fragment.addTab(search_fragment.newTab().setText(class_names.get(3)));
    }

    @Override
    public void onClick(View v) {
        contentText = search_et.getText().toString();
        if (!contentText.isEmpty()) {
            if (add_fragment_is) {
                add_pager();
                add_fragment_is = false;
            }
            adapter.notifyDataSetChanged();
            software.getInpuStream("http://www.oschina.net/", contentText, "1", "20");

        } else {
            Toast.makeText(SearchActivity.this, "输入内容不能为空", Toast.LENGTH_SHORT).show();
        }

    }
}
