package com.example.toandm.viewpagertutorial.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.toandm.viewpagertutorial.R;
import com.example.toandm.viewpagertutorial.models.ShopItem;

import java.util.List;

/**
 * Created by toandm on 11/9/17.
 */

public class LikeShopAdapter extends RecyclerView.Adapter<LikeShopAdapter.LikeViewHolder> {

    private Context context;
    private List<ShopItem> listLikeItem;
    //private LikeShopAdapter.LikeViewHolder holder;
    private OnListDeleteItem onListDeleteItem;

    public void setOnListDeleteItem(OnListDeleteItem onListDeleteItem) {
        this.onListDeleteItem = onListDeleteItem;
    }

    public interface OnListDeleteItem{
        void sendItem(List<ShopItem> list, int position);
    }


    public LikeShopAdapter(Context context, List<ShopItem> listLikeItem){
        this.context = context;
        this.listLikeItem = listLikeItem;
    }


    @Override
    public LikeShopAdapter.LikeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shop,parent,false);
        return new LikeShopAdapter.LikeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LikeShopAdapter.LikeViewHolder holder, final int position) {
        final ShopItem shopItem = listLikeItem.get(position);
        holder.oldPrice.setText(shopItem.getOldPrice());
        holder.newPrice.setText(shopItem.getNewPrice());
        holder.nameProduct.setText(shopItem.getNameProduct());
        holder.ibProduct.setImageResource(shopItem.getImg());
        holder.cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onListDeleteItem.sendItem(listLikeItem,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listLikeItem.size();
    }


    public void updateData(List<ShopItem> list){
        this.listLikeItem = list;
        this.notifyDataSetChanged();
    }

    public class LikeViewHolder extends RecyclerView.ViewHolder {
        private TextView oldPrice, newPrice, nameProduct;
        private ImageView ibProduct,cart;
        private LinearLayout layoutItem;


        private LikeViewHolder(View view) {
            super(view);
            oldPrice = view.findViewById(R.id.oldMoney);
            newPrice = view.findViewById(R.id.newMoney);
            ibProduct = view.findViewById(R.id.imProduct);
            nameProduct = view.findViewById(R.id.nameProduct);
            layoutItem = view.findViewById(R.id.itemLayout);
            cart = view.findViewById(R.id.cart);
        }
    }
//    public void getData(List<ShopItem> list){
//        listLikeItem = list;
//    }
}
