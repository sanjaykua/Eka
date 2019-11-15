package com.sanjaykua.eka;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.sanjaykua.eka.databinding.CustomBinding;

import java.util.List;

import static androidx.core.content.ContextCompat.getCodeCacheDir;

public class Recadp extends RecyclerView.Adapter<Recadp.MyViewHolder> {
    List<items> adpitemsList;
    Context context;
    CustomBinding binding;
    public Recadp(MainActivity mainActivity, List<items> itemsList) {
        context=mainActivity;
        adpitemsList=itemsList;
    }

    @NonNull
    @Override
    public Recadp.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        binding= DataBindingUtil.inflate(layoutInflater,R.layout.custom,null,false);
        return new MyViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull final Recadp.MyViewHolder holder, final int position) {
        holder.binding.textView.setText(adpitemsList.get(position).getName());
        holder.binding.fork.setText(adpitemsList.get(position).getForks());
        holder.binding.watch.setText(adpitemsList.get(position).getWatchers());
        holder.binding.issue.setText(adpitemsList.get(position).getOpen_issues());
        holder.binding.score.setText(adpitemsList.get(position).getScore());
        holder.binding.language.setText(adpitemsList.get(position).getLanguage());

        binding.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position<=getItemCount()){
                    Intent intent=new Intent(context,detail.class);
                    int n=position;
                    intent.putExtra("position",n);
//                    intent.putExtra("name",);
                    context.startActivity(intent);
                }
            }
        });

    }

       @Override
    public int getItemCount() {
        return adpitemsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CustomBinding binding;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=DataBindingUtil.getBinding(itemView);
        }
    }
}
