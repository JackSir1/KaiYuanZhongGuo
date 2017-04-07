package myuplode.jiyun.com.kaiyuanzhongguo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/4/5.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragment_list;
    private List<String> title_list;
    public MyPagerAdapter(FragmentManager fm, List<Fragment> fragment_list,List<String> title_list) {
        super(fm);
        this.fragment_list=fragment_list;
        this.title_list=title_list;
    }

    @Override
    public Fragment getItem(int position) {
        return fragment_list.get(position);
    }

    @Override
    public int getCount() {
        return fragment_list.isEmpty()?0:fragment_list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title_list.get(position % title_list.size());
    }
}
