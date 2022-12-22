package com.uguremrearikan.LordOfQuiz;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    Context context;
    int images[];
    String[] names;
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, int[] flags, String[] names) {
        this.context = applicationContext;
        this.images = flags;
        this.names = names;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int i) {return null;}

    @Override
    public long getItemId(int i) {return 0;}

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.spinner_custom_layout,null);
        ImageView icon = view.findViewById(R.id.imageView);
        TextView name = view.findViewById(R.id.textView);
        icon.setImageResource(images[i]);
        name.setText(names[i]);
        return view;
    }
}
