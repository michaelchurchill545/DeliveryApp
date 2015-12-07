package com.example.michael.deliveryapp.AdaptersForDifferentStores;

import android.content.Context;

import com.example.michael.deliveryapp.Item;
import com.example.michael.deliveryapp.ItemAdapter;
import com.example.michael.deliveryapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michael on 11/26/2015.
 */
public class AdapterSpartanBookstore extends ItemAdapter {
    /**
     * Created by michael on 11/9/2015.
     *
     * @param context
     */
    public AdapterSpartanBookstore(Context context) {
        super(context);
    }

    @Override
    public List<Item> inputData() {
        ArrayList<Item> a = new ArrayList<>();

        int[] iconId = {R.drawable.ic_action_mustache, R.drawable.ic_action_mustache, R.drawable.ic_action_tshirt, R.drawable.ic_action_tshirt, R.drawable.ic_local_pizza, R.drawable.ic_local_pizza};
        String[] itemNames = {"Apple Earbuds", "Pencils (Box of 2)", "Spartan Hoodie(Grey)", "Black Spartan Shirt", "5 Gum: Spear Mint", "Gatorade"};
        double[] itemPrice = {59.99, 29.99, 16.43, 15.49, 2.43, 1.99};
        for (int i = 0; i < iconId.length && i < itemNames.length && i < itemPrice.length; i++) {
            Item current = new Item(itemNames[i], "description", itemPrice[i], iconId[i]);
            System.out.println(itemNames[i] + " added to the list"); //debugger check
            a.add(current);
        }
        return a;
    }
}
