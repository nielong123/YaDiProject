package gaodedemo.nl.org.gaodedemoapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import app.BaseRecyclerViewAdapter;
import gaode.trajectory.MapActivity;
import gaode.trajectory.TrajectoryActivity;

public class MainActivity extends AppCompatActivity {

    HashMap<Integer, String> list = new HashMap<>();
    private RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    void initData() {
        list.put(0, "轨迹重放");
        list.put(1, "轨迹规划");
        list.put(2, "3d导航");
        list.put(3, "车辆集合");
    }

    void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayout.VERTICAL);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(list, this);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerview.setAdapter(recyclerViewAdapter);
    }


    private class RecyclerViewAdapter extends BaseRecyclerViewAdapter<RecyclerViewAdapter.ViewHolder> {

        private HashMap<Integer, String> list = new HashMap<>();
        private LayoutInflater inflaterView = null;
        private Context context;

        public RecyclerViewAdapter(HashMap<Integer, String> list, Context context) {
            super(context);
            this.list = list;
            this.context = context;
            this.inflaterView = LayoutInflater.from(context);
        }

        public int getItemCount() {
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return super.getItem(position);
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflaterView.inflate(R.layout.mainactivity_item, null);
            return new ViewHolder(view);
        }


        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            super.onBindViewHolder(holder, position);
            holder.name.setText(list.get(position));
            holder.rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (position) {
                        case 0:
                            startActivity(new Intent(MainActivity.this, TrajectoryActivity.class));
                            break;
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            startActivity(new Intent(MainActivity.this, MapActivity.class));
                            break;
                    }
                }
            });
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public View rootView;
            public TextView name;

            public ViewHolder(View rootView) {
                super(rootView);
                this.rootView = rootView;
                this.name = (TextView) rootView.findViewById(R.id.name);
            }

        }
    }
}
