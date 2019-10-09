package com.example.justjava;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    int quantity = 2;
    boolean stateWC;
    public void submitOrder(View view) {
        EditText nameField = findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        CheckBox whippedCreamCheckbox = findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckbox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price = quantity * 5;
        displayMessage(createOrderSummary(price, hasWhippedCream, hasChocolate, name));
    }
    public void setStateWC(View view){
        stateWC = true;
    }

    /**
     * Create summary of the order.
     *
     * @param hasWhippedCream is whether or not the user wants whipped cream topping
     * @param hasChocolate is whether or not the user wants chocolate topping
     * @param price of the order
     * @return text summary
     */

    private String createOrderSummary(int price, boolean hasWhippedCream, boolean hasChocolate, String name) {
        String priceMessage = "Name : " + name +
                "\nQuantity: " + quantity +
                "\nTotal: $" + price +
                "\nWhipped cream: " + hasWhippedCream +
                "\nChocolate: " + hasChocolate +
                "\n\nPlease come again, when I'm not working.";
        return priceMessage;

    }
    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);

    }

    public void decrement(View view) {
        quantity--;
        displayQuantity(quantity);

    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

}