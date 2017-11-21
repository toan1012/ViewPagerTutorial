package com.example.toandm.viewpagertutorial.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.toandm.viewpagertutorial.Database;
import com.example.toandm.viewpagertutorial.R;
import com.example.toandm.viewpagertutorial.adapter.LikeShopAdapter;
import com.example.toandm.viewpagertutorial.impl.OnClickLikeTabs;
import com.example.toandm.viewpagertutorial.models.ShopItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by toandm on 11/14/17.
 */

public class LikeFragment extends Fragment implements OnClickLikeTabs{

    TextView txtData;
    List<ShopItem> listLikeItem;
    private GridLayoutManager layoutManager;
    private RecyclerView recyclerLike;
    private LikeShopAdapter likeShopAdapter;

    public static LikeFragment newInstance(List<ShopItem> listItem) {
//        Bundle bundle = new Bundle();
//        bundle.putSerializable(Database.KEYNAME, (Serializable) listItem);
        LikeFragment fragment = new LikeFragment();
//        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_like,null);
        recyclerLike = view.findViewById(R.id.listLikeShop);
        listLikeItem = new ArrayList<>();
        likeShopAdapter = new LikeShopAdapter(getContext(),listLikeItem);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerLike.setLayoutManager(mLayoutManager);
        recyclerLike.setItemAnimator(new DefaultItemAnimator());
        layoutManager= new GridLayoutManager(getContext(),2);
        recyclerLike.hasFixedSize();
        recyclerLike.setLayoutManager(layoutManager);
        recyclerLike.setAdapter(likeShopAdapter);
        likeShopAdapter.setOnListDeleteItem(new LikeShopAdapter.OnListDeleteItem() {
            @Override
            public void sendItem(List<ShopItem> list, int position) {
                list.remove(list.get(position));
                likeShopAdapter.updateData(list);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtData = view.findViewById(R.id.txtData);
        txtData.setText(System.getProperty("java.vm.version"));
    }


    @Override
    public void sendListData(List<ShopItem> list) {
        listLikeItem = list;
        likeShopAdapter.updateData(listLikeItem);
    }
}
