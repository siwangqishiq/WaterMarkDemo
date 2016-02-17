package com.xinlan.watermarkdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.list);
        mListView.setAdapter(new HomeItemAdapter());//设置Adapter 关联数据
    }


    /**
     * Listview适配器
     */
    private final class HomeItemAdapter extends BaseAdapter {
        private LayoutInflater mInflater;

        public HomeItemAdapter() {
            mInflater = LayoutInflater.from(MainActivity.this);
        }

        @Override
        public int getCount() {
            return 100;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.byx_manage_home_item, null);
                ItemViewHolder holder = new ItemViewHolder();
                holder.text = (TextView) convertView.findViewById(R.id.title);
                holder.arrow = (ImageView) convertView.findViewById(R.id.arrow);
                holder.lineView = convertView.findViewById(R.id.line);
                holder.bottomLineView = convertView.findViewById(R.id.bottom_line);
                convertView.setTag(holder);
            }
            ItemViewHolder holder = (ItemViewHolder) convertView.getTag();

            //set View Data
            holder.text.setText("你好 世界 hahhaha");
            holder.bottomLineView.setVisibility(View.VISIBLE);

            return convertView;
        }
    }//end inner class

    static class ItemViewHolder {
        TextView text;//名称
        ImageView arrow;//箭头图标
        View lineView;
        View bottomLineView;
    }//end inner class
}//end class
