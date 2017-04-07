package myuplode.jiyun.com.kaiyuanzhongguo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import myuplode.jiyun.com.kaiyuanzhongguo.R;

/**
 * Created by Administrator on 2017/4/5.
 */

public class DongTanFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.dongtan_view, null);
        return inflate;
    }
}
