package cn.com.dyninfo.o2o.entity;

import cn.com.dyninfo.o2o.entity.common.BaseEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class GoodsSpec extends BaseEntity {

    private String name;

    private List<GoodsSpecValue> specValueList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GoodsSpecValue> getSpecValueList() {
        return specValueList;
    }

    public void setSpecValueList(List<GoodsSpecValue> specValueList) {
        this.specValueList = specValueList;
    }
}