package com.geekbrains.market;

import com.geekbrains.person.salesman.Salesman;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public List<Salesman> getSalesmanList() {
        return salesmanList;
    }

    public void setSalesmanList(List<Salesman> salesmanList) {
        this.salesmanList = salesmanList;
    }

    private List<Salesman> salesmanList;

    public void addSalesman(Salesman salesman){
        if (salesmanList == null){
            salesmanList = new ArrayList<>();
        }
        salesmanList.add(salesman);
    }
}

