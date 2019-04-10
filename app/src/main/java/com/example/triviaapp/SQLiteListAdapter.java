package com.example.triviaapp;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class SQLiteListAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> created_at;
    ArrayList<String> userName;
    ArrayList<String> UserQu1ame;
    ArrayList<String> ans1;
    ArrayList<String> qu2 ;
    ArrayList<String> ans2;


    public SQLiteListAdapter(
            Context context2,
            ArrayList<String> created_at,
            ArrayList<String> userName,
            ArrayList<String> UserQu1ame,
            ArrayList<String> ans1,
            ArrayList<String> qu2,
            ArrayList<String> ans2

    )
    {

        this.context = context2;
        this.created_at = created_at;
        this.userName = userName;
        this.UserQu1ame = UserQu1ame;
        this.ans1 = ans1;
        this.qu2 = qu2;
        this.ans2 = ans2 ;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return userName.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public View getView(int position, View child, ViewGroup parent) {

        Holder holder;

        LayoutInflater layoutInflater;

        if (child == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            child = layoutInflater.inflate(R.layout.listviewdatalayout, null);

            holder = new Holder();
            holder.datetimetimetextView4 = child.findViewById(R.id.datetimetimetextView4);
            holder.textViewname = (TextView) child.findViewById(R.id.textViewname);
            holder.textViewqu1 = (TextView) child.findViewById(R.id.textViewqu1);
            holder.textViewan1 = (TextView) child.findViewById(R.id.textViewan1);
            holder.textView3qu2 = (TextView) child.findViewById(R.id.textView3qu2);
            holder.textViewans2 = (TextView) child.findViewById(R.id.textViewans2);

            child.setTag(holder);

        } else {

            holder = (Holder) child.getTag();
        }
        holder.datetimetimetextView4.setText(created_at.get(position));
        holder.textViewname.setText(userName.get(position));
        holder.textViewqu1.setText(UserQu1ame.get(position));
        holder.textViewan1.setText(ans1.get(position));
        holder.textView3qu2.setText(qu2.get(position));
        holder.textViewans2.setText(ans2.get(position));

        return child;
    }

    public class Holder {
        TextView datetimetimetextView4;
        TextView textViewname;
        TextView textViewqu1;
        TextView textViewan1;
        TextView textView3qu2;
        TextView textViewans2;
    }




}
