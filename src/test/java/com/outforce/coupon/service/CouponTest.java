package com.outforce.coupon.service;

import com.outforce.coupon.coupondto.CouponDTO;
import com.outforce.coupon.entities.Coupon;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CouponTest {

    @Autowired
    private CouponService couponService;

    @Test
    void createCouponSuccess() {
        CouponDTO couponDTO = new CouponDTO(
                "AB@1234#",
                "Coupon Test",
                8.0,
                OffsetDateTime.now().plusDays(5),
                true
        );

        Coupon coupon = couponService.createCoupon(couponDTO);
        assertEquals(6, coupon.getCode().length());
        assertFalse(coupon.isDeleted());
    }

    @Test
    void failWhenExpirationBefore() {
        CouponDTO couponDTO = new CouponDTO(
                "ABC321",
                "Expired",
                8.0,
                OffsetDateTime.now().minusDays(1),
                false
        );
        assertThrows(RuntimeException.class, () -> couponService.createCoupon(couponDTO));
    }
}
