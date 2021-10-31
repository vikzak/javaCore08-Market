package com.geekbrains;

import com.geekbrains.market.Market;
import com.geekbrains.person.customer.Customer;
import com.geekbrains.person.salesman.Salesman;
import com.geekbrains.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Market market = new Market();
        Salesman firstSalesman = createFirstSalesman();
        Salesman secondSalesman = createSecondSalesman();
        market.addSalesman(firstSalesman);
        market.addSalesman(secondSalesman);
        
        Customer customer = createFirstCastomer();
        customer.findProductOnMarket(market);
        customer.whatiBoughtInfo();
    }

    private static Customer createFirstCastomer() {
        Product firstProduct = new Product();
        firstProduct.setName("Помидоры");
        firstProduct.setCount(4);
        Product secondProduct = new Product();
        secondProduct.setName("Огурцы");
        secondProduct.setCount(2);
        return new Customer(List.of(firstProduct, secondProduct),2);
    }

    private static Salesman createSecondSalesman() {
        Salesman salesman = new Salesman();
        salesman.setName("Vasiliy");
        salesman.setSecondName("Pupkin");
        Product firstproduct = new Product();
        salesman.setCash(0);

        firstproduct.setName("Помидоры");
        firstproduct.setPrice(8);
        firstproduct.setCount(40);

        Product secondproduct = new Product();
        secondproduct.setName("Огурцы");
        secondproduct.setPrice(5);
        secondproduct.setCount(12);

        List<Product> product = new ArrayList<>();
        product.add(firstproduct);
        product.add(secondproduct);
        salesman.setProducts(product);

        return salesman;
    }

    private static Salesman createFirstSalesman(){
        Salesman salesman = new Salesman();
        salesman.setName("Viktor");
        salesman.setSecondName("Zakharov");
        Product firstproduct = new Product();
        salesman.setCash(0);

        firstproduct.setName("Помидоры");
        firstproduct.setPrice(10);
        firstproduct.setCount(20);

        Product secondproduct = new Product();
        secondproduct.setName("Огурцы");
        secondproduct.setPrice(8);
        secondproduct.setCount(100);

        List<Product> product = new ArrayList<>();
        product.add(firstproduct);
        product.add(secondproduct);
        salesman.setProducts(product);

        return salesman;
    }
}
