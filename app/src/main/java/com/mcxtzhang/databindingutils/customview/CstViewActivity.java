package com.mcxtzhang.databindingutils.customview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mcxtzhang.databindingutils.R;
import com.mcxtzhang.databindingutils.databinding.ActivityCstViewBinding;

public class CstViewActivity extends AppCompatActivity {
    ActivityCstViewBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_cst_view);
        AddDelBean addDelBean = new AddDelBean(9, 6);
        mBinding.setBean(addDelBean);
    }
}
