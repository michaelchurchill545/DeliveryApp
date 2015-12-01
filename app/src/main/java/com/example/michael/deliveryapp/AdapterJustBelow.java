package com.example.michael.deliveryapp;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michael on 11/26/2015.
 */
public class AdapterJustBelow extends ItemAdapter {


    /**
     * Created by michael on 11/9/2015.
     *
     * @param context
     */
    public AdapterJustBelow(Context context) {
        super(context);

    }


    @Override
    public List<Item> inputData() {
        List<Item> a = new ArrayList<>();
        int[] iconId = {R.drawable.example_item, R.drawable.example_item, R.drawable.example_item, R.drawable.example_item, R.drawable.example_item};
        String[] itemNames = {"JustBelowItem", "JustBelowItem", "JustBelowItem", "JustBelowItem", "JustBelowItem"};
        double[] itemPrice = {10.43, 10.43, 10.43, 10.43, 10.43,};
        for (int i = 0; i < iconId.length && i < itemNames.length && i < itemPrice.length; i++) {
            Item current = new Item(itemNames[i], "description", itemPrice[i], iconId[i]);
            System.out.println(itemNames[i] + " added to the list"); //Debug check
            a.add(current);
        }
        return a;
    }

}
