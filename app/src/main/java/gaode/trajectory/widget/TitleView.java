package gaode.trajectory.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import gaodedemo.nl.org.gaodedemoapplication.R;


/**
 * Created by nielong123 on 2018/3/27.
 */

public class TitleView extends RelativeLayout {

    private Context context;
    TextView title;
    RelativeLayout other;
    ImageView othersrc;

    public TitleView(Context context) {
        super(context);
        this.context = context;
        makeLayout();
    }

    public TitleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        makeLayout();
    }

    public TitleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        makeLayout();
    }

    private void makeLayout() {
        LayoutInflater.from(context).inflate(R.layout.titleview_layout, this);title = (TextView) findViewById(R.id.tv_title);
        other = (RelativeLayout) findViewById(R.id.other);

        findViewById(R.id.back).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity) context).finish();
            }
        });
    }

    public void setTitle(String title) {
        ((TextView) findViewById(R.id.tv_title)).setText(title);
    }

    public void setOtherClickListener(OnClickListener listener) {
        other.setOnClickListener(listener);
    }

    public void setOtherSrc(Bitmap bitmap) {
        othersrc.setVisibility(VISIBLE);
        othersrc.setImageBitmap(bitmap);
    }

}
