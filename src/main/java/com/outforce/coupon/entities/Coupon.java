package com.outforce.coupon.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "coupons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 6, unique = true)
    private String code;
    private String description;
    private Double discountValue;
    private LocalDateTime expirationDate;
    private boolean deleted = false;
    private LocalDateTime createdCoupon;
    private boolean published;

}
