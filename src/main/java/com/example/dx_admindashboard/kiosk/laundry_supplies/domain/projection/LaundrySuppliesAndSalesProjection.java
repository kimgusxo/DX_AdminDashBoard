package com.example.dx_admindashboard.kiosk.laundry_supplies.domain.projection;

public interface LaundrySuppliesAndSalesProjection {
    Long getLaundrySuppliesId();
    String getLaundrySuppliesName();
    String getLaundrySuppliesClassification();
    Integer getLaundrySuppliesPrice();
    Long getStoreId();
    Long getTotalSales(); // 연도별 총 판매량
}
