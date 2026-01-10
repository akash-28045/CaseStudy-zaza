package com.zaza.model;

public class DeliveryPerson {
    private final int deliveryPersonId;
    private final String name;
    private final long contactNo;

    public DeliveryPerson(int deliveryPersonId, String name, long contactNo) {
        this.deliveryPersonId = deliveryPersonId;
        this.name = name;
        this.contactNo = contactNo;
    }

    public int getDeliveryPersonId() {
        return deliveryPersonId;
    }

    public String getName() {
        return name;
    }

    public long getContactNo() {
        return contactNo;
    }

    @Override
    public String toString() {
        return String.format("DeliveryPerson[ID: %d, Name: %s, Contact: %d]", deliveryPersonId, name, contactNo);
    }
}
