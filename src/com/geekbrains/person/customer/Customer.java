package com.geekbrains.person.customer;

import com.geekbrains.market.Market;
import com.geekbrains.person.Person;
import com.geekbrains.person.salesman.Salesman;
import com.geekbrains.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {
    List<Product> purchaseList;
    List<Product> expectedPurchasedList;


    public Customer(List<Product> expectedPurchasedList, int cach){
        this.purchaseList = new ArrayList<>();
        this.expectedPurchasedList = expectedPurchasedList;
        this.setCash(cach);

    }

    public void whatiBoughtInfo(){
        StringBuilder builder = new StringBuilder("\nЯ купил:\n");
        if (purchaseList.size() == 0) {
            builder.append("ничего! Денег нехватило!\n");
        } else {
            for (Product purchase: purchaseList){
                builder.append(purchase.getName());
                builder.append(" в количестве: ");
                builder.append(purchase.getCount());
                builder.append(" шт.\n");
            }
        }

        builder.append("У меня осталось: ");
        builder.append(this.getCash());
        builder.append("руб.");
        System.out.printf(String.valueOf(builder));
    }

    public void addPurchase(Product product){
        if (purchaseList == null){
            purchaseList = new ArrayList<>();
        }
        purchaseList.add(product);
    }

    public void findProductOnMarket(Market market) {
        for (Product product: getExpectedPurchasedList()){
            for (Salesman salesman: market.getSalesmanList()){
                boolean isBought = salesman.sellProduct(this,product);
                if (isBought){
                    break;
                }
            }


        }
    }

    public List<Product> getExpectedPurchasedList() {
        return expectedPurchasedList;
    }

    public void setExpectedPurchasedList(List<Product> expectedPurchasedList) {
        this.expectedPurchasedList = expectedPurchasedList;
    }
}
