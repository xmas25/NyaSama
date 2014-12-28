package com.nyasama.fragment;

import android.os.Bundle;
import android.text.Html;

import com.android.volley.toolbox.NetworkImageView;
import com.nyasama.R;
import com.nyasama.ThisApp;
import com.nyasama.util.CommonListAdapter;
import com.nyasama.util.Discuz;
import com.nyasama.util.Discuz.Thread;

/**
 * Created by oxyflour on 2014/12/21.
 *
 */
public class DiscuzComicListFragment extends DiscuzThreadListFragment {

    public static DiscuzComicListFragment getNewFragment() {
        DiscuzComicListFragment fragment = new DiscuzComicListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_LIST_LAYOUT, R.layout.fragment_simple_grid);
        bundle.putInt(ARG_ITEM_LAYOUT, R.layout.fragment_thread_grid);
        bundle.putInt("fid", 3);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public CommonListAdapter getListViewAdaptor(CommonListFragment fragment) {
        return new CommonListAdapter<Thread>() {
            @Override
            public void convertView(ViewHolder viewHolder, final Thread item) {
                viewHolder.setText(R.id.title, Html.fromHtml(item.title));
                final NetworkImageView imageView = (NetworkImageView) viewHolder.getView(R.id.image_view);
                imageView.setDefaultImageResId(R.drawable.ic_launcher);
                imageView.setImageUrl(
                        item.attachments > 0 ? Discuz.getThreadCoverThumb(item.id) : null,
                        ThisApp.imageLoader);
            }
        };
    }
}