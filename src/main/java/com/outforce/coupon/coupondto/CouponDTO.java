package com.outforce.coupon.coupondto;

import java.time.LocalDateTime;

public record CouponDTO(
            String code,
            String description,
            Double discountValue,
            LocalDateTime expirationDate,
            boolean published
            ){}
