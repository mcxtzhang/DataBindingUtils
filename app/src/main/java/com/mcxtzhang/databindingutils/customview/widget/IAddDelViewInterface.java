package com.mcxtzhang.databindingutils.customview.widget;

/**
 * 介绍：加减View的接口
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 2016/11/22.
 */

public interface IAddDelViewInterface {
    interface onAddDelListener {
        public enum FailType {
            COUNT_MAX, COUNT_MIN
        }

        void onAddSuccess(int count);

        void onAddFailed(int count, FailType failType);

        void onDelSuccess(int count);

        void onDelFaild(int count, FailType failType);
    }
}
