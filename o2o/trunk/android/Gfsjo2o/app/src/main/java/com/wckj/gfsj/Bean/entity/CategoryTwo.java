package com.wckj.gfsj.Bean.entity;


import com.wckj.gfsj.Bean.entity.common.BaseEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class CategoryTwo extends BaseEntity {

    //分类图片，主分类页面直接显示
    private String imageUrl="";
    //分类名称，二级分类页面显示在左边的文字
    private String title="";
    //子类别，二级分类页面使用，显示在右侧的图片列表
    private List<CategoryThree> childrenList;
    //排序
    private int sortOrder;
    private boolean colorSelector;//默认false

    public boolean isColorSelector() {
        return colorSelector;
    }

    public void setColorSelector(boolean colorSelector) {
        this.colorSelector = colorSelector;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<CategoryThree> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<CategoryThree> childrenList) {
        this.childrenList = childrenList;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public String toString() {
        return "Category{" +
                "imageUrl='" + imageUrl + '\'' +
                ", title='" + title + '\'' +
                ", childrenList=" + childrenList +
                ", sortOrder=" + sortOrder +
                '}';
    }
}
