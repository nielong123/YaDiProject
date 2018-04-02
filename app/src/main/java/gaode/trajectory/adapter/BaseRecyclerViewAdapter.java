package gaode.trajectory.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by Sherlock on 2016/8/23.
 */
public class BaseRecyclerViewAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    protected LayoutInflater mInflater;
    protected int mCount = 0;
    protected Context mContext = null;


    public BaseRecyclerViewAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }


    @Override
    public void onBindViewHolder(VH holder, int position) {

    }

    public void setCount(int count) {
        mCount = count;
    }

    @Override
    public int getItemCount() {
        return mCount;
    }

    public Object getItem(int position) {
        return null;
    }
}
