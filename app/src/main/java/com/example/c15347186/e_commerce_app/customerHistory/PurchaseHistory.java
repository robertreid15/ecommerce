/*
package com.example.c15347186.e_commerce_app.customerHistory;

import java.util.ArrayList;

import com.example.demo.order.ItemOrders;

public class PurchaseHistory implements Container{

    public ArrayList<ItemOrders> orders;

    public PurchaseHistory(ArrayList<ItemOrders> ordersList) {
        orders = ordersList;
    }

    public Iterator getIterator() {
        return new PurchaseHistoryIterator();
    }

    private class PurchaseHistoryIterator implements Iterator {
        int index;

        public boolean hasNext() {
            if (index < orders.size()) {
                return true;
            }
            return false;
        }

        public Object next() {
            if (this.hasNext()) {
                return orders.get(index++);
            }
            return null;
        }
    }
}
*/
