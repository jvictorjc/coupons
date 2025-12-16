package com.outforce.coupon.coupondto;

import java.time.OffsetDateTime;

public record CouponDTO(
            String code,
            String description,
            Double discountValue,
            OffsetDateTime expirationDate,
            boolean published
            ){}
