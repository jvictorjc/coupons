package com.outforce.coupon.service;

import com.outforce.coupon.coupondto.CouponDTO;
import com.outforce.coupon.entities.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.outforce.coupon.repository.CouponRepository;

@Service
@RequiredArgsConstructor
public class CouponService {

    private static final Double MIN_DISCOUNT_VALUE = 0.50;

    private final CouponRepository couponRepository;

    public Coupon createCoupon(CouponDTO couponDTO) {
        Coupon coupon = Coupon.builder()
                .code(couponDTO.code())
                .description(couponDTO.description())
                .discountValue(couponDTO.discountValue())
                .expirationDate(couponDTO.expirationDate())
                .deleted(false)
                .build();

        return couponRepository.save(coupon);
    }
}
