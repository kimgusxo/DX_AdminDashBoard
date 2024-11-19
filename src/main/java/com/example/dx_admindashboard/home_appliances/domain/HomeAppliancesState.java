package com.example.dx_admindashboard.home_appliances.domain;

import com.example.dx_admindashboard.store.domain.Store;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "HOME_APPLIANCES_STATE_TB")
public class HomeAppliancesState {

   @Id
   @GeneratedValue
   @Column(name = "HOME_APPLIANCES_STATE_ID")
   private long homeAppliancesStateId;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "HOME_APPLIANCES_ID")
   private HomeAppliances homeAppliances;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "STORE_ID")
   private Store store;

   @NotNull
   @Column(name = "HOME_APPLIANCES_STATE")
   private String homeAppliancesState;

   @NotNull
   @Column(name = "HOME_APPLIANCES_POSITION")
   private String homeAppliancesPosition;
}
