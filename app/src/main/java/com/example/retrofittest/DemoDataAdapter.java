package com.example.retrofittest;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DemoDataAdapter extends RecyclerView.Adapter<DemoDataAdapter.ViewHolder> {
    private Context context;
    private List<DemoDataModel.DataList> listData;

    public DemoDataAdapter(Context context, List<DemoDataModel.DataList> listData) {
        this.context = context;
        this.listData = listData;
    }

    @NonNull
    @Override
    public DemoDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.demo_data_child, null);
        DemoDataAdapter.ViewHolder viewHolder = new DemoDataAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txt_id.setText(listData.get(position).getId());
        holder.name.setText(listData.get(position).getName());
        holder.email.setText(listData.get(position).getEmail());
    }


    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_id, name, email;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_id = itemView.findViewById(R.id.txt_id);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
        }
    }
}
