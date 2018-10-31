package com.example.hp.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class Tab1 extends Fragment  implements View.OnClickListener{

    public LinearLayout ell1;
    public LinearLayout ell2;
    public LinearLayout ell3;


    /*@Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        LinearLayout ell1 = (LinearLayout)view.findViewById(R.id.ell1);

        ell1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),PlumberMain.class);
                startActivity(intent);
            }
        });
    }*/


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.tab1,container,false);
        LinearLayout ell1 = (LinearLayout)view.findViewById(R.id.ell1);
        LinearLayout ell2 = (LinearLayout)view.findViewById(R.id.ell2);
        LinearLayout ell3 = (LinearLayout)view.findViewById(R.id.ell3);

        ell1.setOnClickListener(this);
        ell2.setOnClickListener(this);
        ell3.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ell1:
                Intent intent = new Intent(getActivity(), ElectricianMain.class);
                startActivity(intent);
                break;
            case R.id.ell2:
                Intent intent1 = new Intent(getActivity(),PlumberMain.class);
                startActivity(intent1);
                break;
            case R.id.ell3:
                Intent intent2 = new Intent(getActivity(),CarpenterMain.class);
                startActivity(intent2);
                break;
            default:
                break;
        }

    }
}
