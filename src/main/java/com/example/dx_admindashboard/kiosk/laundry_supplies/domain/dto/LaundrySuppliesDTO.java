package com.example.dx_admindashboard.kiosk.laundry_supplies.domain.dto;

import com.example.dx_admindashboard.kiosk.laundry_supplies.domain.LaundrySupplies;

public record LaundrySuppliesDTO(
    Long laundrySuppliesId,
    String laundrySuppliesName,
    Integer laundrySuppliesPrice,
    String laundrySuppliesClassification,
    String laundrySuppliesCompanyName,
    String laundrySuppliesDescription,
    String laundrySuppliesUrl
) {
    public static LaundrySuppliesDTO of(Long laundrySuppliesId,
                                        String laundrySuppliesName,
                                        Integer laundrySuppliesPrice,
                                        String laundrySuppliesClassification,
                                        String laundrySuppliesCompanyName,
                                        String laundrySuppliesDescription,
                                        String laundrySuppliesUrl) {
        return new LaundrySuppliesDTO(laundrySuppliesId, laundrySuppliesName, laundrySuppliesPrice, laundrySuppliesClassification, laundrySuppliesCompanyName, laundrySuppliesDescription, laundrySuppliesUrl);
    }

    public static LaundrySuppliesDTO from(LaundrySupplies laundrySupplies) {
        return new LaundrySuppliesDTO(
                laundrySupplies.getLaundrySuppliesId(),
                laundrySupplies.getLaundrySuppliesName(),
                laundrySupplies.getLaundrySuppliesPrice(),
                laundrySupplies.getLaundrySuppliesClassification(),
                laundrySupplies.getLaundrySuppliesCompanyName(),
                laundrySupplies.getLaundrySuppliesDescription(),
                laundrySupplies.getLaundrySuppliesUrl()
               );
    }

    public LaundrySupplies toEntity() {
        return LaundrySupplies.builder()
                .laundrySuppliesId(laundrySuppliesId)
                .laundrySuppliesName(laundrySuppliesName)
                .laundrySuppliesPrice(laundrySuppliesPrice)
                .laundrySuppliesClassification(laundrySuppliesClassification)
                .laundrySuppliesCompanyName(laundrySuppliesCompanyName)
                .laundrySuppliesDescription(laundrySuppliesDescription)
                .laundrySuppliesUrl(laundrySuppliesUrl)
                .build();
    }
}
