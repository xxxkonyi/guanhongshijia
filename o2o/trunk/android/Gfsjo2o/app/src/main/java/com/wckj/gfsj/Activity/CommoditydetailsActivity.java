package com.wckj.gfsj.Activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.wckj.gfsj.Adapter.CommoditydetailsAdapter;
import com.wckj.gfsj.Bean.AddCartRequest;
import com.wckj.gfsj.Bean.AddFavoritesRequest;
import com.wckj.gfsj.Bean.Commodity_level_details;
import com.wckj.gfsj.Bean.GoodsDetailRequest;
import com.wckj.gfsj.Bean.GoodsDetailResult;
import com.wckj.gfsj.CustomUi.FrameLoadLayout;
import com.wckj.gfsj.CustomUi.TitleRelativeLayout;
import com.wckj.gfsj.GlobalUtils;
import com.wckj.gfsj.R;
import com.wckj.gfsj.Utils.HttpUtils;
import com.wckj.gfsj.Utils.IImpl.ICallBack;
import com.wckj.gfsj.Utils.OwerToastShow;

import java.util.ArrayList;

import okhttp3.Call;

/**
 * 商品详情信息展示付款
 */
public class CommoditydetailsActivity extends BaseNewActivity implements View.OnClickListener{
    private Button bt_buy;
    private ViewPager vp_commodity_pic;
    private ArrayList<Commodity_level_details> mList=new ArrayList<>();
    private TitleRelativeLayout title_rl;
    private TextView tv_add_cart,tv_title_name,tv_title_desc,tv_prices,tv_type,tv_color,tv_specification;
    private ImageView iv_collect;
    private GoodsDetailResult result;

    private String goodsId;

    @Override
    protected void init() {
        goodsId =  getIntent().getStringExtra("goodsId");
        if( goodsId==null){
            finish();
        }
    }

    @Override
    protected View onCreateTitleView(LayoutInflater inflater) {
        View titleView = inflater.inflate(R.layout.layout_public_title_main, null);
        title_rl = (TitleRelativeLayout) titleView.findViewById(R.id.title_rl);
        title_rl.childView. findViewById(R.id.tv_go_back).setOnClickListener(this);
        title_rl.childView . findViewById(R.id.tv_content_desc).setVisibility(View.GONE);

        return titleView;
    }

    @Override
    protected View onCreateSuccessView() {
        View view = inflater.inflate(R.layout.activity_commodity_details, null);
        bt_buy = (Button) view.findViewById(R.id.bt_buy);
        tv_add_cart = (TextView) view.findViewById(R.id.tv_add_cart);
        iv_collect = (ImageView) view.findViewById(R.id.iv_collect);
        tv_title_name = (TextView) view.findViewById(R.id.tv_title_name);
        tv_title_desc = (TextView) view.findViewById(R.id.tv_title_desc);
        tv_prices = (TextView) view.findViewById(R.id.tv_prices);
        tv_type = (TextView) view.findViewById(R.id.tv_type);
        tv_color = (TextView) view.findViewById(R.id.tv_color);
        tv_specification = (TextView) view.findViewById(R.id.tv_specification);

        initSuccessView();

        bt_buy.setOnClickListener(this);
        tv_add_cart.setOnClickListener(this);
        iv_collect.setOnClickListener(this);

        vp_commodity_pic = (ViewPager) view.findViewById(R.id.vp_commodity_pic);
        bindViewPage();//绑定viewpage
        return view;
    }


    private void bindViewPage() {
        for (int i = 0; i <5 ; i++) {
            mList.add(new Commodity_level_details());
        }
        vp_commodity_pic.setAdapter(new CommoditydetailsAdapter(mList,this));
    }

    @Override
    protected void refreshOrLoadView() {

    }

    @Override
    protected void load() {
        getGoodsDetail();

    }

    //成功之后初始化界面数据
    private void initSuccessView() {
        tv_title_name.setText(result.getDetail().getName());
        tv_title_desc.setText(result.getDetail().getShortDesc());
        tv_prices.setText("￥ "+result.getDetail().getPrice());
//        tv_type.setText(result.getDetail().get);
//        tv_color.setText();
//        tv_specification
    }

    /**
     * 商品详情命令
     */
    private void getGoodsDetail() {
        GoodsDetailRequest request = new GoodsDetailRequest();
        request.setId(goodsId+"");
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.GOODS_DETAIL_URL, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
                showPageState(FrameLoadLayout.LoadResult.error);
            }

            @Override
            public void onSuccess(String response) {
                 result =  JSON.parseObject(response, GoodsDetailResult.class);
                showPageState(FrameLoadLayout.LoadResult.success);
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_go_back:
                finish();
                break;
            case R.id.bt_buy:
                startActivity(new Intent(this,ShoppingCartActivity.class));
                break;
            case R.id.tv_add_cart://加入购物车
                addCart();
                break;
            case R.id.iv_collect://收藏夹
                addCollect();
                iv_collect.setImageResource(R.drawable.icon_collect_press);
                break;
        }
    }
    /**
     * 加入收藏夹
     */
    private void addCollect() {


        AddFavoritesRequest request = new AddFavoritesRequest();
        request.setGoodsId(goodsId+"");
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.FAVORITES_ADD_URL, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
            }

            @Override
            public void onSuccess(String response) {
//                AddCartResult json = JSON.parseObject(response, AddCartResult.class);
//                OwerToastShow.show("收藏夹加入成功");
            }
        });

    }

    /**
     * 加入购物车
     */
    private void addCart() {
        AddCartRequest request = new AddCartRequest();
        request.setCount(1);
        request.setGoodsId(goodsId+"");
        HttpUtils.getInstance().asyncPost(request, GlobalUtils.CART_ADD_URL, new ICallBack() {
            @Override
            public void onError(Call call, Exception e) {
                OwerToastShow.show("购物车加入失败");
            }

            @Override
            public void onSuccess(String response) {
//                AddCartResult json = JSON.parseObject(response, AddCartResult.class);
                OwerToastShow.show("购物车加入成功");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        title_rl. clearRegister();
    }
}
