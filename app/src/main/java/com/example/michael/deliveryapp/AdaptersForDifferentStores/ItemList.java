package com.example.michael.deliveryapp.AdaptersForDifferentStores;

import com.example.michael.deliveryapp.Item;
import com.example.michael.deliveryapp.Iterator;

import java.util.List;

/**
 * Created by michael on 12/7/2015.
 */
public class ItemList {

    private List<Item> items;

    public ItemList(List<Item> items) {
        this.items = items;
    }

    public ItemIterator createIterator() {
        return new ItemIterator();

    }

    class ItemIterator implements Iterator {
        int currentIndex = 0;

        @Override
        public boolean hasNext() {

            return currentIndex < items.size();
        }

        @Override
        public Item next() {

            return items.get(currentIndex++);
        }
    }

}
