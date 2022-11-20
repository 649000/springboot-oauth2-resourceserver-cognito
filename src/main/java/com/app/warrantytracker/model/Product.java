package com.app.warrantytracker.model;

import lombok.Data;

@Data
public class Product {

    private String id;

    private String name;

    private String serialNumber;

    private String purchasedDate;

    private String warrantyExpiryDate;
}
