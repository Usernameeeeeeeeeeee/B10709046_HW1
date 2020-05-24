package com.example.b10709046_hw1;

import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyAdapterViewHolder> {

    private static String[] optionsData = {"品客", "高麗元", "謙恆食堂", "上品排骨", "炸多多", "宏福鐵板牛排", "巖茶", "福客亭早餐店", "丼太郎", "食味溫州大餛飩", "賽門鄧普拉", "地中海私房料理", "7-11",
                                           "摩斯漢堡", "帝一味自助餐", "藝素佳", "茶覺", "京都日式", "天津蔥抓餅", "雞同丫講", "豪享來", "稻村麵包", "活力讚", "八方雲集", "突厥廚房", "全家"};
    private static boolean[] isOptionChecked;

    public MyAdapter() {
        isOptionChecked = new boolean[optionsData.length];
        initIsOptionChecked(false);
    }

    public class MyAdapterViewHolder extends RecyclerView.ViewHolder {

        public TextView optionsTextView;
        public CheckBox optionsCheckBox;

        public MyAdapterViewHolder(View view) {
            super(view);
            optionsTextView = (TextView) view.findViewById(R.id.textview_options);
            optionsCheckBox = (CheckBox) view.findViewById(R.id.cb);
        }
    }

    @Override
    public MyAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.options_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        return new MyAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyAdapterViewHolder myAdapterViewHolder, final int position) {
        String option = optionsData[position];
        myAdapterViewHolder.optionsTextView.setText(option);

        if (MainActivity.isOptionChecked != null) {
            isOptionChecked = MainActivity.isOptionChecked;
        }

        myAdapterViewHolder.optionsCheckBox.setText(option);
        //System.out.println(myAdapterViewHolder.optionsCheckBox.getText());
        myAdapterViewHolder.optionsCheckBox.setOnCheckedChangeListener(null);//先設定一次CheckBox的選中監聽器，傳入引數null
        myAdapterViewHolder.optionsCheckBox.setChecked(isOptionChecked[position]);//用陣列中的值設定CheckBox的選中狀態
        //再設定一次CheckBox的選中監聽器，當CheckBox的選中狀態發生改變時，把改變後的狀態儲存在陣列中
        myAdapterViewHolder.optionsCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isOptionChecked[position] = b;
            }
        });
        //System.out.println("onBindViewHolder");
    }

    @Override
    public int getItemCount() {
        if (optionsData == null) return 0;
        return optionsData.length;
    }

    public static String[] getOptionsData() {
        return optionsData;
    }

    public static boolean[] getIsOptionChecked() {
        return isOptionChecked;
    }

    private void initIsOptionChecked(boolean isChecked) {
        for (int i = 0; i < isOptionChecked.length; i++) {
            isOptionChecked[i] = isChecked;
        }
    }

}
