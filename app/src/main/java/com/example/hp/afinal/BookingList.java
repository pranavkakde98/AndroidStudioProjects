package com.example.hp.afinal;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class BookingList extends ArrayAdapter<ServiceDetail> {

    private Activity context;
    private List<ServiceDetail> serviceDetailList;

    public BookingList(Activity context, List<ServiceDetail> serviceDetailList){
        super(context, R.layout.booking_list, serviceDetailList);
        this.context = context;
        this.serviceDetailList = serviceDetailList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.booking_list, null, true);

        TextView sName = (TextView) listViewItem.findViewById(R.id.sName);
        TextView sAddress = (TextView) listViewItem.findViewById(R.id.sAddress);
        TextView sPrice = (TextView) listViewItem.findViewById(R.id.sPrice);
        TextView sDate = (TextView) listViewItem.findViewById(R.id.sDate);
        TextView sTime = (TextView) listViewItem.findViewById(R.id.sTime);


        ServiceDetail serviceDetail = serviceDetailList.get(position);

        sName.setText(serviceDetail.getServiceName());
        sAddress.setText(serviceDetail.getAddress());
        sPrice.setText(serviceDetail.getPrice());
        sDate.setText(serviceDetail.getDate());
        sTime.setText(serviceDetail.getHours());

        return listViewItem;
    }
}
