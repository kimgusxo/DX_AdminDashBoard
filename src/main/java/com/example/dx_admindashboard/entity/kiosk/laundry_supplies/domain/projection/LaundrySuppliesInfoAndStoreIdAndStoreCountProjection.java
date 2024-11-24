package com.example.dx_admindashboard.entity.kiosk.laundry_supplies.domain.projection;

public interface LaundrySuppliesInfoAndStoreIdAndStoreCountProjection {
    Long getLaundrySuppliesId();
    String getLaundrySuppliesName();
    String getLaundrySuppliesClassification();
    Integer getLaundrySuppliesPrice();
    Long getStoreId();
    Integer getStoreCount();
}

