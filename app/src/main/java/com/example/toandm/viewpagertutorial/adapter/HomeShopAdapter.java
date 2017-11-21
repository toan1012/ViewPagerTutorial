package com.example.toandm.viewpagertutorial.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.toandm.viewpagertutorial.R;
import com.example.toandm.viewpagertutorial.impl.OnItemClickedListener;
import com.example.toandm.viewpagertutorial.models.ShopItem;

import java.util.List;

/**
 * Created by toandm on 11/1/17.
 */

public class HomeShopAdapter extends RecyclerView.Adapter<HomeShopAdapter.ShopViewHolder>{
    private Context context;
    private List<ShopItem> listShopItem;
    private HomeShopAdapter.ShopViewHolder holder;
    private OnItemClickedListener onItemClickedListener;

    public void setOnItemClickedListener(OnItemClickedListener onItemClickedListener) {
        this.onItemClickedListener = onItemClickedListener;
    }

    public HomeShopAdapter(Context context, List<ShopItem> listShopItem){
        this.context = context;
        this.listShopItem = listShopItem;
    }

    public HomeShopAdapter(List<ShopItem> listShopItem){
        this.listShopItem = listShopItem;
    }

    @Override
    public HomeShopAdapter.ShopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shop,parent,false);
        return new HomeShopAdapter.ShopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ShopViewHolder holder, final int position) {
        final ShopItem shopItem = listShopItem.get(position);
        holder.oldPrice.setText(shopItem.getOldPrice());
        holder.newPrice.setText(shopItem.getNewPrice());
        holder.nameProduct.setText(shopItem.getNameProduct());
        holder.ibProduct.setImageResource(shopItem.getImg());

        holder.cart.setOnClickListener( new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               onItemClickedListener.onClicked(shopItem, position);
               Log.d("CLICK",holder.nameProduct.toString());
           }
       });
    }

    @Override
    public int getItemCount() {
        return listShopItem.size();
    }

    public class ShopViewHolder extends RecyclerView.ViewHolder{
        private TextView oldPrice, newPrice, nameProduct;
        private ImageView ibProduct,cart;
        private LinearLayout layoutItem;


        private ShopViewHolder(View view) {
            super(view);
            oldPrice = view.findViewById(R.id.oldMoney);
            newPrice = view.findViewById(R.id.newMoney);
            ibProduct = view.findViewById(R.id.imProduct);
            nameProduct = view.findViewById(R.id.nameProduct);
            layoutItem = view.findViewById(R.id.itemLayout);
            cart = view.findViewById(R.id.cart);
        }
    }
    private static String makeFragmentName(int viewId, long id) {
        return "android:switcher:" + viewId + ":" + id;
    }
}
