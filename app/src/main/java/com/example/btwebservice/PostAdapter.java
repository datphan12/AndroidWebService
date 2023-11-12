package com.example.btwebservice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class PostAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Post> postList;

    public PostAdapter(Context context, int layout, List<Post> postList) {
        this.context = context;
        this.layout = layout;
        this.postList = postList;
    }

    @Override
    public int getCount() {
        return postList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        TextView txtId, txtUserId, txtTitle, txtBody;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if(holder==null){
           holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txtId = (TextView)view.findViewById(R.id.post_id);
            holder.txtUserId = (TextView)view.findViewById(R.id.post_user_id);
            holder.txtTitle = (TextView)view.findViewById(R.id.post_title);
            holder.txtBody = (TextView)view.findViewById(R.id.post_body);
            view.setTag(holder);
        }else{
            holder= (ViewHolder) view.getTag();
        }

        Post post = postList.get(position);

        holder.txtId.setText("Bài đăng số: "+post.getId());
        holder.txtUserId.setText("Id người đăng: "+post.getUserId());
        holder.txtTitle.setText("Title: "+post.getTitle());
        holder.txtBody.setText("Content: "+post.getBody());
        return view;
    }
}
