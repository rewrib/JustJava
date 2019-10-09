/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.justjava;



import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

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
        CheckBox whippedCreamCheckbox = findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckbox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price = quantity * 5;
        displayMessage(createOrderSummary(price, hasWhippedCream, hasChocolate));
    }
    public void setStateWC(View view){
        stateWC = true;
    }

    private String createOrderSummary(int price, boolean hasWhippedCream, boolean hasChocolate) {
        String priceMessage = "Name : Kaptain Kunal" +
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