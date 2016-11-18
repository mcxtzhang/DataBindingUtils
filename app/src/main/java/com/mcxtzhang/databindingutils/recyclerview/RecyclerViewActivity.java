package com.mcxtzhang.databindingutils.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.mcxtzhang.databindinglib.BaseBindingAdapter;
import com.mcxtzhang.databindinglib.mul.BaseMulTypeBindingAdapter;
import com.mcxtzhang.databindingutils.databinding.ActivityRecyclerViewBinding;
import com.mcxtzhang.databindingutils.recyclerview.m.FirstBindingBean;
import com.mcxtzhang.databindingutils.recyclerview.multype.MBean1;
import com.mcxtzhang.databindingutils.recyclerview.multype.MBean2;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends Activity {
    private ActivityRecyclerViewBinding mBinding;
    private BaseBindingAdapter mAdapter;
    private List mDatas;

    public class MulTypeItemPresenter {
        //用官方推荐的方法绑定Click
        public void onItem1Click(View item1) {
            Toast.makeText(item1.getContext(), "第一种类型被点击", Toast.LENGTH_SHORT).show();
        }

        //用lambda绑定Click
        public void showItem1TvText(String text) {
            Toast.makeText(RecyclerViewActivity.this, "第一种类型TextView被点击:" + text, Toast.LENGTH_SHORT).show();
        }


        //第二个ItemPresenter我故意没设置进xml里 程序一样可以运行
        public void onItem2Click(View item2) {
            Toast.makeText(item2.getContext(), "第二种类型被点击", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityRecyclerViewBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        //给Activity的xml设置点击事件
        mBinding.setPresenter(new FirstPresenter());
        initDatas();
        mBinding.rv.setLayoutManager(new LinearLayoutManager(this));

        //Base 多种Item，连bean都可以不一样，你觉得屌不屌
        //会自动 填充 data 和Item的Presenter进去
        mBinding.rv.setAdapter(mAdapter = new BaseMulTypeBindingAdapter(this, mDatas = initMulTypeDatas()).setItemPresenter(new MulTypeItemPresenter()));


        //就一种Item：新写法 代码更少了，但是总觉得有种约束感 ：
/*        mBinding.rv.setAdapter(new BaseBindingAdapter<FirstBindingBean, ItemMulType1Binding>(this, R.layout.item_mul_type_1, mLists) {
            @Override
            public void onBindViewHolder(final BaseBindingVH holder, final int position) {
                super.onBindViewHolder(holder, position);
                holder.getBinding().getRoot().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mLists.get(position).setName("变变变");
                        ViewDataBinding binding = holder.getBinding();
                    }
                });
            }
        });*/

        //2016 10 30 封装两个泛型
/*        mBinding.rv.setAdapter(new BaseBindingAdapter<FirstBindingBean, ItemMulType1Binding>(this, R.layout.item_mul_type_1, mLists) {
            @Override
            public void onBindViewHolder(BaseBindingVH<ItemMulType1Binding> holder, int position) {
                super.onBindViewHolder(holder, position);
                final ItemMulType1Binding binding = holder.getBinding();
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        binding.tv.setText("只是试一试 不要这么写");
                    }
                });
            }
        });*/


    }

    public List initMulTypeDatas() {
        List mulTypeDatas = new ArrayList<>();
        mulTypeDatas.add(new MBean1("http://imgs.ebrun.com/resources/2016_03/2016_03_25/201603259771458878793312_origin.jpg", "张"));


        mulTypeDatas.add(new MBean1("http://p14.go007.com/2014_11_02_05/a03541088cce31b8_1.jpg", "旭童"));
        mulTypeDatas.add(new MBean2("http://news.k618.cn/tech/201604/W020160407281077548026.jpg", "多种type"));
        mulTypeDatas.add(new MBean2("http://www.kejik.com/image/1460343965520.jpg", "多种type"));
        mulTypeDatas.add(new MBean2("http://cn.chinadaily.com.cn/img/attachement/jpg/site1/20160318/eca86bd77be61855f1b81c.jpg", "多种type"));
        mulTypeDatas.add(new MBean2("http://imgs.ebrun.com/resources/2016_04/2016_04_12/201604124411460430531500.jpg", "多种type"));
        mulTypeDatas.add(new MBean1("http://imgs.ebrun.com/resources/2016_04/2016_04_24/201604244971461460826484_origin.jpeg", "多种type"));
        mulTypeDatas.add(new MBean1("http://www.lnmoto.cn/bbs/data/attachment/forum/201408/12/074018gshshia3is1cw3sg.jpg", "多种type"));


        mulTypeDatas.add(new MBean1("http://p14.go007.com/2014_11_02_05/a03541088cce31b8_1.jpg", "旭童"));
        mulTypeDatas.add(new MBean2("http://news.k618.cn/tech/201604/W020160407281077548026.jpg", "多种type"));
        mulTypeDatas.add(new MBean2("http://www.kejik.com/image/1460343965520.jpg", "多种type"));
        mulTypeDatas.add(new MBean2("http://cn.chinadaily.com.cn/img/attachement/jpg/site1/20160318/eca86bd77be61855f1b81c.jpg", "多种type"));
        mulTypeDatas.add(new MBean2("http://imgs.ebrun.com/resources/2016_04/2016_04_12/201604124411460430531500.jpg", "多种type"));
        mulTypeDatas.add(new MBean1("http://imgs.ebrun.com/resources/2016_04/2016_04_24/201604244971461460826484_origin.jpeg", "多种type"));
        mulTypeDatas.add(new MBean1("http://www.lnmoto.cn/bbs/data/attachment/forum/201408/12/074018gshshia3is1cw3sg.jpg", "多种type"));


        mulTypeDatas.add(new MBean1("http://p14.go007.com/2014_11_02_05/a03541088cce31b8_1.jpg", "旭童"));
        mulTypeDatas.add(new MBean2("http://news.k618.cn/tech/201604/W020160407281077548026.jpg", "多种type"));
        mulTypeDatas.add(new MBean2("http://www.kejik.com/image/1460343965520.jpg", "多种type"));
        mulTypeDatas.add(new MBean2("http://cn.chinadaily.com.cn/img/attachement/jpg/site1/20160318/eca86bd77be61855f1b81c.jpg", "多种type"));
        mulTypeDatas.add(new MBean2("http://imgs.ebrun.com/resources/2016_04/2016_04_12/201604124411460430531500.jpg", "多种type"));
        mulTypeDatas.add(new MBean1("http://imgs.ebrun.com/resources/2016_04/2016_04_24/201604244971461460826484_origin.jpeg", "多种type"));
        mulTypeDatas.add(new MBean1("http://www.lnmoto.cn/bbs/data/attachment/forum/201408/12/074018gshshia3is1cw3sg.jpg", "多种type"));
        return mulTypeDatas;
    }


    private void initDatas() {
        mDatas = new ArrayList<>();
        ArrayList<FirstBindingBean> nestBeen = new ArrayList<>();
        mDatas.add(new FirstBindingBean("http://imgs.ebrun.com/resources/2016_03/2016_03_25/201603259771458878793312_origin.jpg", "张", 1));


        mDatas.add(new FirstBindingBean("http://p14.go007.com/2014_11_02_05/a03541088cce31b8_1.jpg", "旭童", 2));
        mDatas.add(new FirstBindingBean("http://news.k618.cn/tech/201604/W020160407281077548026.jpg", 3));
        mDatas.add(new FirstBindingBean("http://www.kejik.com/image/1460343965520.jpg", 1));
        mDatas.add(new FirstBindingBean("http://cn.chinadaily.com.cn/img/attachement/jpg/site1/20160318/eca86bd77be61855f1b81c.jpg", 2));
        mDatas.add(new FirstBindingBean("http://imgs.ebrun.com/resources/2016_04/2016_04_12/201604124411460430531500.jpg", 3));
        mDatas.add(new FirstBindingBean("http://imgs.ebrun.com/resources/2016_04/2016_04_24/201604244971461460826484_origin.jpeg", 1));
        mDatas.add(new FirstBindingBean("http://www.lnmoto.cn/bbs/data/attachment/forum/201408/12/074018gshshia3is1cw3sg.jpg", 2));
    }

    public class FirstPresenter {
        public void onAddClick() {
            mDatas.add(new FirstBindingBean("http://finance.gucheng.com/UploadFiles_7830/201603/2016032110220685.jpg", "add"));
            mAdapter.notifyItemInserted(mDatas.size());
        }

        public void onDelClick() {
            mDatas.remove(mDatas.size() - 1);
            mAdapter.notifyItemRemoved(mDatas.size());
        }
    }


}
