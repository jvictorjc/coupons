package com.outforce.coupon.controller;

import com.outforce.coupon.coupondto.CouponDTO;
import com.outforce.coupon.entities.Coupon;
import com.outforce.coupon.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coupons")
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    @GetMapping("/{id}")
    public ResponseEntity<Coupon> getCoupon(@PathVariable Long id){
        Coupon coupon = couponService.getCoupon(id);
        return ResponseEntity.ok(coupon);
    }

    @PostMapping
    public ResponseEntity<Coupon> addCoupon(@RequestBody CouponDTO couponDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(couponService.createCoupon(couponDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoupon(@PathVariable Long id) {
        couponService.couponDelete(id);
        return ResponseEntity.noContent().build();
    }
}
