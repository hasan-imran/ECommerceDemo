package com.example.ecommercedemo.fragments.navigation_items.mycart;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecommercedemo.R;
import com.example.ecommercedemo.adapters.CartItemAdapter;
import com.example.ecommercedemo.models.CartItemModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyCartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyCartFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private RecyclerView rvCartItems;

    public MyCartFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyCart.
     */
    // TODO: Rename and change types and number of parameters
    public static MyCartFragment newInstance(String param1, String param2) {
        MyCartFragment fragment = new MyCartFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_cart, container, false);
        rvCartItems = view.findViewById(R.id.rvCartItems);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvCartItems.setLayoutManager(layoutManager);
        rvCartItems.setHasFixedSize(true);

        List<CartItemModel> cartItemModelList = new ArrayList<>();
        cartItemModelList.add(new CartItemModel(R.drawable.iphone_12_pro_max, "iPhone 12 Max Pro",
                "BDT 150000/-", "BDT 150000/-", 1));
        cartItemModelList.add(new CartItemModel(R.drawable.iphone_12_pro_max, "iPhone 12 Max Pro",
                "BDT 150000/-", "BDT 150000/-", 1));
        cartItemModelList.add(new CartItemModel(R.drawable.iphone_12_pro_max, "iPhone 12 Max Pro",
                "BDT 150000/-", "BDT 150000/-", 1));


        CartItemAdapter cartItemAdapter = new CartItemAdapter(cartItemModelList);
        cartItemAdapter.notifyDataSetChanged();

        rvCartItems.setAdapter(cartItemAdapter);

        return view;
    }
}