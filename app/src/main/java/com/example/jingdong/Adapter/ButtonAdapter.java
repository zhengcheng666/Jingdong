package com.example.jingdong.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.jingdong.R;

/**
 * @创建时间 2020/12/25 16:09
 */
public class ButtonAdapter extends DelegateAdapter.Adapter<ButtonAdapter.ViewHolder> {
    private SingleLayoutHelper singleLayoutHelper;
    private Context context;
    private Button buttonOne;
    private Button buttonTwo;
    private Button buttonThree;
    private Button buttonFour;
    private Button buttonFive;

    public ButtonAdapter(SingleLayoutHelper singleLayoutHelper, Context context) {
        this.singleLayoutHelper = singleLayoutHelper;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.buttonitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    private void initView() {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            buttonOne = (Button) itemView.findViewById(R.id.button_one);
            buttonTwo = (Button) itemView.findViewById(R.id.button_two);
            buttonThree = (Button) itemView.findViewById(R.id.button_three);
            buttonFour = (Button) itemView.findViewById(R.id.button_four);
            buttonFive = (Button) itemView.findViewById(R.id.button_five);
        }
    }
}
