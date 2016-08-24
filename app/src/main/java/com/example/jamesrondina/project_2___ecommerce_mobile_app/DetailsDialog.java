package com.example.jamesrondina.project_2___ecommerce_mobile_app;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jamesrondina.project_2___ecommerce_mobile_app.models.Item;

import java.util.List;

/**
 * Created by jamesrondina on 8/23/16.
 */
public class DetailsDialog {

    private ImageView itemPic;
    private TextView itemName, itemDesc, itemPrice;

    public void launchItemDetail(Context context, int i, final List<Item> items){

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        final View dialogView = inflater.inflate(R.layout.dialog, null);

        itemPic = (ImageView) dialogView.findViewById(R.id.dialogPic);
        itemName = (TextView) dialogView.findViewById(R.id.dialogName);
        itemDesc = (TextView) dialogView.findViewById(R.id.dialogDesc);
        itemPrice = (TextView) dialogView.findViewById(R.id.dialogPrice);

        itemPic.setImageResource(items.get(i).getmPic());
        itemName.setText(items.get(i).getmName());
        itemDesc.setText(items.get(i).getmDesc());
        itemPrice.setText(items.get(i).getmPrice());


        builder.setView(dialogView)
                .setTitle("Item Details")
                .setPositiveButton("Add to Cart", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //add item to cart
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        final AlertDialog dialog = builder.create();
        dialog.show();

    }
}
