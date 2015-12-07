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
public class AdapterStudentUnion extends ItemAdapter {


    /**
     * Created by michael on 11/9/2015.
     *
     * @param context
     */
    public AdapterStudentUnion(Context context) {
        super(context);


    }

    @Override
    public List<Item> inputData() {
        ArrayList<Item> a = new ArrayList<>();
        int[] iconId = { R.drawable.ic_local_pizza, R.drawable.ic_local_pizza, R.drawable.ic_local_pizza, R.drawable.ic_local_pizza, R.drawable.ic_local_pizza};
        String[] itemNames = {"TacoBell Quesorito", "Brick's Vegan Pizza", "Apples 'n Greens", "Waffle Thing", "Orange Chicken Bowl",};
        double[] itemPrice = {4.99, 6.53, 5.11, 11.23, 5.16,};
        for (int i = 0; i < iconId.length && i < itemNames.length && i < itemPrice.length; i++) {
            Item current = new Item(itemNames[i], "description", itemPrice[i], iconId[i]);
            System.out.println(itemNames[i] + " added to the list");
            a.add(current);
        }
        return a;
    }
}
