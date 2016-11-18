package com.mcxtzhang.databindinglib;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * 介绍：普通Adapter
 * 泛型D:是Bean类型，如果有就传。
 * 泛型B:是对应的xml Layout的Bingding类
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 16/09/25.
 */

public class BaseBindingAdapter<D, B extends ViewDataBinding> extends RecyclerView.Adapter<BaseBindingVH<B>> {
    protected Context mContext;
    protected int mLayoutId;
    protected List<D> mDatas;
    protected LayoutInflater mInfalter;

    public BaseBindingAdapter(Context mContext, int mLayoutId, List mDatas) {
        this.mContext = mContext;
        this.mLayoutId = mLayoutId;
        this.mDatas = mDatas;
        this.mInfalter = LayoutInflater.from(mContext);
    }

    public BaseBindingAdapter(Context mContext, List mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        this.mInfalter = LayoutInflater.from(mContext);
    }

    @Override
    public BaseBindingVH<B> onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseBindingVH<B> holder = new BaseBindingVH<B>((B) DataBindingUtil.inflate(mInfalter, mLayoutId, parent, false));
        onCreateViewHolder(holder);
        return holder;
    }

    /**
     * 如果需要给Vh设置监听器啥的 可以在这里
     *
     * @param holder
     */
    public void onCreateViewHolder(BaseBindingVH<B> holder) {

    }

    /**
     * 子类除了绑定数据，还要设置监听器等其他操作。
     * 可以重写这个方法，不要删掉super.onBindViewHolder(holder, position);
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(BaseBindingVH<B> holder, int position) {
        holder.getBinding().setVariable(com.mcxtzhang.databindinglib.BR.data, mDatas.get(position));
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return null != mDatas ? mDatas.size() : 0;
    }



    /**
     * 刷新数据，初始化数据
     *
     * @param list
     */
    public void setDatas(List<D> list) {
        if (this.mDatas != null) {
            if (null != list) {
                List<D> temp = new ArrayList<D>();
                temp.addAll(list);
                this.mDatas.clear();
                this.mDatas.addAll(temp);
            } else {
                this.mDatas.clear();
            }
        } else {
            this.mDatas = list;
        }
        notifyDataSetChanged();
    }

    /**
     * 删除数据
     *
     * @param i
     */
    public void remove(int i) {
        if (null != mDatas && mDatas.size() > i && i > -1) {
            mDatas.remove(i);
            notifyDataSetChanged();
        }
    }

    /**
     * 加载更多数据
     *
     * @param list
     */
    public void addDatas(List<D> list) {
        if (null != list) {
            List<D> temp = new ArrayList<D>();
            temp.addAll(list);
            if (this.mDatas != null) {
                this.mDatas.addAll(temp);
            } else {
                this.mDatas = temp;
            }
            notifyDataSetChanged();
        }

    }


    public List<D> getDatas() {
        return mDatas;
    }
}
