package com.wckj.gfsj.Activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.wckj.gfsj.Adapter.CommonAdapter;
import com.wckj.gfsj.Adapter.ViewHolder;
import com.wckj.gfsj.Bean.Commodity_level_two;
import com.wckj.gfsj.Bean.TimeEvent;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.CustomUi.StopViewPage;
import com.wckj.gfsj.Fragment.Commodity_level_two_fragment;
import com.wckj.gfsj.R;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

/**
 * 二级商品类型分类
 * acr
 */
public class CommodityLevelTwoActivity extends BaseNewActivity implements View.OnClickListener {

    private TextView tv_time;
    private View view;
    private ListView lv_item;
    private StopViewPage svp_special;
    private ArrayList<Commodity_level_two> mList;
    private CommonAdapter mlvAdapter;
    private FragmentAdapter mPageAdapter;
    private List<Fragment> pageList = new ArrayList<Fragment>();

    @Override
    protected void init() {
        EventBus.getDefault().register(this);

    }

    @Override
    protected View onCreateTitleView(LayoutInflater inflater) {
        View titleView = inflater.inflate(R.layout.layout_title_main_go_back, null);
        titleView. findViewById(R.id.tv_go_back).setOnClickListener(this);
        tv_time = (TextView) titleView.findViewById(R.id.tv_time);
        return titleView;
    }

    @Override
    protected View onCreateSuccessView() {
        view = inflater.inflate(R.layout.activity_commodity_category, null);
        lv_item = (ListView) view.findViewById(R.id.lv_item);
        svp_special = (StopViewPage) view.findViewById(R.id.svp_special);
        bindData();
        return view;
    }

    /**
     * 初始化不能滑动viewpage
     */
    private void initData() {
        if (mPageAdapter == null && pageList.isEmpty()) {
            for (int i = 0; i < mList.size(); i++) {
                // 添加子页
                Commodity_level_two_fragment fragment = new Commodity_level_two_fragment();
                Bundle bundle = new Bundle();
                //给一些参数
                fragment.setArguments(bundle);
                pageList.add(fragment);
            }
            mPageAdapter = new FragmentAdapter(getSupportFragmentManager());
        }

        svp_special.setAdapter(mPageAdapter);

    }
    private void bindData() {
        initData();
        if(mlvAdapter==null){
            mlvAdapter=  new CommonAdapter<Commodity_level_two>(this,mList,R.layout.item_lv_commodity_two) {
                @Override
                public void convert(ViewHolder helper, Commodity_level_two item, int position) {
                        helper.setText(R.id.tv_two_name,"凳子");


                }
            };
            lv_item.setAdapter(mlvAdapter);
        }else {
            mlvAdapter.notifyDataSetChanged();
        }

    }

    @Override
    protected void refreshOrLoadView() {

    }

    @Override
    protected void load() {
        mList = new ArrayList<>();
        for (int i = 0; i <8 ; i++) {
            mList.add(new Commodity_level_two());
        }
        showPageState(FrameLoadLayout.LoadResult.success);
    }

    @Subscribe(threadMode = ThreadMode.MainThread)
   public void  onMainTimeEvent(TimeEvent time){
        if(tv_time!=null){
            tv_time.setText(time.getTime());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_go_back:
                finish();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    class FragmentAdapter extends FragmentStatePagerAdapter {

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return pageList.get(position);
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // 得到缓存的fragment
            Fragment fragment = (Fragment) super.instantiateItem(container,
                    position);
            return fragment;
        }

        @Override
        public int getItemPosition(Object object) {
            return PagerAdapter.POSITION_NONE;
    }
}
}