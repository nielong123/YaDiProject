package gaode.trajectory.widget;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nielong123 on 2018/3/27.
 */

public class TabFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mlist = new ArrayList<>();

    public TabFragmentPagerAdapter(FragmentManager fm, List<Fragment> mlist) {
        super(fm);
        this.mlist = mlist;
    }

    @Override
    public Fragment getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public int getCount() {
        return mlist.size();
    }
}
