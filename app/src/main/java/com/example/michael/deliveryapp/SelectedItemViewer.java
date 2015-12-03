package com.example.michael.deliveryapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created By not-Roben
 */
public class SelectedItemViewer extends AppCompatActivity {
    Item item = new Item("test", "description", 20.00, R.drawable.ic_action_mustache);

    public SelectedItemViewer(Item item) {
        this.item = item;
    }

    public SelectedItemViewer() {

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_item_fragment);
        TextView title = (TextView) findViewById(R.id.item_name);
        TextView price = (TextView) findViewById(R.id.item_price);
        ImageView icon = (ImageView) findViewById(R.id.item_icon);
        String textValuePrice = "$" + String.valueOf(item.getItemPrice());
        title.setText(item.getName());
        price.setText(textValuePrice);
        icon.setImageResource(item.getIconId());
    }

//
//    /**
//     * Reacts when user presses "Add to Cart" button
//     * Passes item to Shopping Cart activity
//     */
//    public void addToCart(View view) {
//        Intent intent = new Intent(this, ShoppingCartActivity.class);
//        intent.putExtra("cartitem", (Serializable)item);
//        startActivity(intent);
//    }
}
