package androidlikeios.com.simplerecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SimpleRecyclerViewAdapter extends RecyclerView.Adapter<SimpleRecyclerViewAdapter.ViewHolder> {

    String[] simplesValues;
    Context context;
    View view;
    ViewHolder viewHolder;


    public SimpleRecyclerViewAdapter(Context context1, String[] values) {

        simplesValues = values;
        context = context1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public ViewHolder(View v){

            super(v);

            textView = (TextView)v.findViewById(R.id.text_view_title);
        }
    }

    @Override
    public SimpleRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        view = LayoutInflater.from(context).inflate(R.layout.simple_recyclerview_item,parent,false);

        viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){

        holder.textView.setText(simplesValues[position]);
    }

    @Override
    public int getItemCount(){

        return simplesValues.length;
    }
}