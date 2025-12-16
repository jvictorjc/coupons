package com.outforce.coupon.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

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

    @Column(name = "Code", length = 6, unique = true)
    private String code;

    @Column(name = "Description")
    private String description;

    @Column(name = "DiscountValue")
    private Double discountValue;

    @Column(name = "ExpirationDate")
    private OffsetDateTime expirationDate;

    @Column(name = "Deleted")
    private boolean deleted = false;

    @Column(name = "CreatedCoupon")
    private LocalDateTime createdCoupon;

    @Column(name = "Published")
    private boolean published;

}
