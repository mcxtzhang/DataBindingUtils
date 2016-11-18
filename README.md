# DataBindingUtils
Some utils about Data Binding.(More easier adapter to write multi type list.) | 一些DataBinding相关的工具类。（一句代码实现多类型列表的Adapter）

# Usage：
Step 1. Add the JitPack repository to your build file。
Add it in your root build.gradle at the end of repositories:
```
    allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```
Step 2. Add the dependency
```
    dependencies {
	        compile 'com.github.mcxtzhang:DataBindingUtils:V1.0.0'
	}
```

Step 3.
Activity/Fragment:
```
        //Base 多种Item，连bean都可以不一样，你觉得屌不屌
        //会自动 填充 data 和Item的Presenter进去
        mBinding.rv.setAdapter(mAdapter = new BaseMulTypeBindingAdapter(this, mDatas = initMulTypeDatas()).setItemPresenter(new MulTypeItemPresenter()));
        
        
```
ItemPresenter:
```
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
```
JavaBean:

```
public class MBean1 implements IBaseMulInterface {
    private String url;
    private String name;

    public MBean1(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public MBean1 setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getName() {
        return name;
    }

    public MBean1 setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.item_mul_1;
    }
}
```

```

public class MBean2 implements IBaseMulInterface {
    private String image;
    private String txt;

    public MBean2(String image, String txt) {
        this.image = image;
        this.txt = txt;
    }

    public String getImage() {
        return image;
    }

    public MBean2 setImage(String image) {
        this.image = image;
        return this;
    }

    public String getTxt() {
        return txt;
    }

    public MBean2 setTxt(String txt) {
        this.txt = txt;
        return this;
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.item_mul_2;
    }
}
```

xml:
```
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools">

    <data>

        <import type="com.mcxtzhang.databindingutils.recyclerview.multype.MBean1"/>

        <import type="com.mcxtzhang.databindingutils.recyclerview.RecyclerViewActivity.MulTypeItemPresenter"/>

        <variable
            name="data"
            type="MBean1"/>

        <variable
            name="itemP"
            type="MulTypeItemPresenter"/>
    </data>


    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="1dp"
        android:background="#123456"
        android:onClick="@{itemP::onItem1Click}"
        android:orientation="horizontal">

        <ImageView
            android:layout_width="200dp"
            android:layout_height="200dp"
            app:netUrl="@{data.url}"
            tools:src="@mipmap/ic_launcher"/>

        <TextView
            android:id="@+id/tv"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:onClick="@{()->itemP.showItem1TvText(data.name)}"
            android:text="@{data.name}"
            tools:text="测试多种"/>

        <CheckBox
            android:id="@+id/cb"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"/>

    </LinearLayout>
</layout>

```
