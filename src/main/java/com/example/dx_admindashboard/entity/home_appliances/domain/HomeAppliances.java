package com.example.dx_admindashboard.entity.home_appliances.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "HOME_APPLIANCES_TB")
public class HomeAppliances {

    @Id
    @GeneratedValue
    @Column(name = "HOME_APPLIANCES_ID")
    private Long homeAppliancesId;

    @NotNull
    @Column(name = "HOME_APPLIANCES_CLASSIFICATION")
    private String homeAppliancesClassification;

    @NotNull
    @Column(name = "HOME_APPLIANCES_NAME")
    private String homeAppliancesName;

    @NotNull
    @Column(name = "HOME_APPLIANCES_MODEL_NAME")
    private String homeAppliancesModelName;

    @NotNull
    @Column(name = "HOME_APPLIANCES_PRICE")
    private Integer homeAppliancesPrice;

    @NotNull
    @Column(name = "HOME_APPLIANCES_DESCRIPTION")
    private String homeAppliancesDescription;

    @OneToMany(mappedBy = "homeAppliances")
    private List<HomeAppliancesState> homeAppliancesStateList;
}
