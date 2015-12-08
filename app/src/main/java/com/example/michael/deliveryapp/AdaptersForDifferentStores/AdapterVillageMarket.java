package com.example.michael.deliveryapp.AdaptersForDifferentStores;

import android.content.Context;

import com.example.michael.deliveryapp.Item;
import com.example.michael.deliveryapp.ItemAdapter;
import com.example.michael.deliveryapp.Iterator;
import com.example.michael.deliveryapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michael on 11/26/2015.
 */
public class AdapterVillageMarket extends ItemAdapter {

    /**
     * Created by michael on 11/9/2015.
     *
     * @param context
     */
    public AdapterVillageMarket(Context context) {
        super(context);

    }

    @Override
    public List<Item> inputData() {
        List<Item> a = new ArrayList<>();
        int[] iconId = {R.drawable.ic_generic_pizza, R.drawable.ic_generic_pizza, R.drawable.ic_generic_pizza, R.drawable.ic_veggie_pizza, R.drawable.ic_chicken};
        String[] itemNames = {"Pizzooki", "Cheese Pizzooki", "Cheese Pizza", "Veggie Pizza", "Chicken Wings"};
        double[] itemPrice = {10.43, 12.99, 4.30, 6.45, 5.99,};
        for (int i = 0; i < iconId.length && i < itemNames.length && i < itemPrice.length; i++) {
            Item current = new Item(itemNames[i], "description", itemPrice[i], iconId[i]);
            a.add(current);
        }
        //use iterator to travverse list
        ItemList itemList = new ItemList(a);
        Iterator itemIterator = itemList.createIterator();
        while (itemIterator.hasNext()) {
            //verifies that the item was added to the list
            Item i = itemIterator.next();
            System.out.println(i.getName() + " added to the list");
        }

        return a;
    }
}
