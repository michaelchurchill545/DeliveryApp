package com.example.michael.deliveryapp.AdaptersForDifferentStores;

import android.content.Context;

import com.example.michael.deliveryapp.ItemAdapter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * The Factory Class that will instantiate new ItemAdapters
 * Created by michael on 11/29/2015.
 */
public class AdapterFactory {
    private String[] stores = new String[]{"createAdapterVillageMarket",
            "createAdapterSpartanBookstore",
            "createAdapterOnFourth",
            "createAdapterJustBelow",
            "createAdapterStudentUnion"};

    /**
     * The Factory method that works as follows:
     * 1)Instantiate a standard adapter that has multiple adapter subclasses.
     * 2)Gets a string with a given createAdapter method name and passes it a Context Parameter
     * 3)Calls the method in this ItemAdapterClass with the given Context
     *
     * @param position the index in the String array of method names
     * @param context global information about the application.
     * @return an instantiated adapter of the given type
     * @throws NoSuchMethodException if an adapter wants to be created but there is no
     * supporting method for it's creation
     * @throws InvocationTargetException
     * @throws IllegalAccessException when the application tries to reflectively create
     * an instance but the currently executing method does not have access to the definition
     * of the specified method
     */
    public ItemAdapter createAdapter(int position, Context context)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ItemAdapter adapter;//1)
        String methodName = stores[position];
        Method m = AdapterFactory.class.getDeclaredMethod(methodName, Context.class);//2)
        adapter = (ItemAdapter) m.invoke(this, context);//3)
        return adapter;
    }

    private ItemAdapter createAdapterVillageMarket(Context context) {
        return new AdapterVillageMarket(context);
    }

    private ItemAdapter createAdapterSpartanBookstore(Context context) {
        return new AdapterSpartanBookstore(context);
    }

    private ItemAdapter createAdapterJustBelow(Context context) {
        return new AdapterJustBelow(context);
    }

    private ItemAdapter createAdapterOnFourth(Context context) {
        return new AdapterOnFourth(context);
    }

    private ItemAdapter createAdapterStudentUnion(Context context) {
        return new AdapterStudentUnion(context);
    }
}
