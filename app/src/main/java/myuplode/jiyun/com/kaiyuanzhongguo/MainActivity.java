package myuplode.jiyun.com.kaiyuanzhongguo;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import myuplode.jiyun.com.kaiyuanzhongguo.adapter.MyPagerAdapter;
import myuplode.jiyun.com.kaiyuanzhongguo.fragment.DongTanFragment;
import myuplode.jiyun.com.kaiyuanzhongguo.fragment.FaXianFragment;
import myuplode.jiyun.com.kaiyuanzhongguo.fragment.WoDeFragment;
import myuplode.jiyun.com.kaiyuanzhongguo.fragment.ZongHeFragment;

public class MainActivity extends FragmentActivity {

    private TabLayout tabLayout;
    private List<String> title_list;
    private ViewPager viewPager;
    private MyPagerAdapter adapter;
    private List<Fragment> fragment_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    //初始化数据
    public void init() {

        tabLayout = (TabLayout) findViewById(R.id.myTabLayout);
        viewPager = (ViewPager) findViewById(R.id.Main_viewpager);
        fragment_list = new ArrayList<>();
        title_list = new ArrayList<>();
        add_pager();
        adapter = new MyPagerAdapter(getSupportFragmentManager(), fragment_list, title_list);
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

    }

    //添加Fragment布局
    public void add_pager() {
        ZongHeFragment zongHeFragment = new ZongHeFragment();
        DongTanFragment dongTanFragment = new DongTanFragment();
        FaXianFragment faXianFragment = new FaXianFragment();
        WoDeFragment woDeFragment = new WoDeFragment();

        fragment_list.add(zongHeFragment);
        fragment_list.add(dongTanFragment);
        fragment_list.add(faXianFragment);
        fragment_list.add(woDeFragment);

        title_list.add("综合");
        title_list.add("动弹");
        title_list.add("发现");
        title_list.add("我的");

        tabLayout.addTab(tabLayout.newTab().setText(title_list.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(title_list.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(title_list.get(2)));
        tabLayout.addTab(tabLayout.newTab().setText(title_list.get(3)));
    }


}
