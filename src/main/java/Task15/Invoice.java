package Task15;

import java.util.ArrayList;

/**
 * Represents an invoice containing a list of items.
 */
public class Invoice {

    /**
     * Represents an item in the invoice with a description, quantity, and unit price.
     */
    public static class Item {
        private final String description;
        private final int quantity;
        private final double unitPrice;

        /**
         * Constructs an item with the given description, quantity, and unit price.
         *
         * @param description the description of the item
         * @param quantity    the quantity of the item
         * @param unitPrice   the unit price of the item
         */
        public Item(String description, int quantity, double unitPrice) {
            this.description = description;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
        }

        /**
         * Calculates the total price of the item.
         *
         * @return the total price of the item
         */
        public double price() {
            return quantity * unitPrice;
        }
    }

    private final ArrayList<Item> items = new ArrayList<>();

    /**
     * Adds a new item to the invoice.
     *
     * @param newItem the item to add to the invoice
     */
    public void addItem(Item newItem) {
        items.add(newItem);
    }

    /**
     * Prints the invoice details including description, quantity, unit price, and total price for each item.
     */
    public void printInvoice() {
        System.out.printf("%14s%14s%14s%14s\n", "description", "quantity", "unitPrice", "price");
        for (Item item : this.items) {
            System.out.printf("%14s%14s%14s%14s\n", item.description, item.quantity, item.unitPrice, item.unitPrice * item.quantity);
        }
    }

    /**
     * Main method to test the Invoice class.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        Invoice invoice = new Invoice();
        invoice.addItem(new Invoice.Item("Вода", 2000, 20));
        invoice.addItem(new Invoice.Item("Ананас", 100, 300));
        invoice.addItem(new Invoice.Item("Яйца", 200, 150));
        invoice.addItem(new Invoice.Item("Творог", 50, 80));
        invoice.printInvoice();
    }
}
