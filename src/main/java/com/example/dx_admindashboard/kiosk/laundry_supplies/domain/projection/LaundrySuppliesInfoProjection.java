package com.example.dx_admindashboard.kiosk.laundry_supplies.domain.projection;

public interface LaundrySuppliesInfoProjection {
    Long getLaundrySuppliesId();
    String getLaundrySuppliesName();
    String getLaundrySuppliesClassification();
    Integer getLaundrySuppliesPrice();
    Long getStoreId();
    Integer getStoreCount();
}

