package com.geekbrains.person.salesman;

import com.geekbrains.person.Person;
import com.geekbrains.person.customer.Customer;
import com.geekbrains.product.Product;

import java.util.List;

public class Salesman extends Person {
    private String name;
    private String secondName;
    private List<Product> products;

    public boolean sellProduct(Customer customer, Product wannaBay){
        for (Product product: products){
            // проверяем по имени, что у продавца есть продукт
            if (product.getName().equals(wannaBay.getName())){
                if (product.getCount() >= wannaBay.getCount()){
                    // проверяем количество денег
                    long requiredCash = (long) product.getPrice() * wannaBay.getCount();
                    if (requiredCash <= customer.getCash()){
                        product.setCount(product.getCount() - wannaBay.getCount());

                        // создаем новый объект продуктов чтобы создать новую ссылку
                        Product customerProduct = new Product();
                        customerProduct.setCount(wannaBay.getCount());
                        customerProduct.setName(wannaBay.getName());
                        customer.addPurchase(customerProduct);
                        this.setCash((int) (this.getCash() + requiredCash));
                        customer.setCash((int) (customer.getCash() - requiredCash));

                        return true;
                    }

                }

            }
        }
        //System.out.printf("Продукт у продавца %s %s не найден, либо его нехватает",name, secondName);
        return false;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
