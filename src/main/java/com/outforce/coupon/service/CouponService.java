package com.outforce.coupon.service;

import com.outforce.coupon.coupondto.CouponDTO;
import com.outforce.coupon.entities.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.outforce.coupon.repository.CouponRepository;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class CouponService {

    private static final String BASE62 = "[^a-zA-Z0-9]";
    private static final Double MIN_DISCOUNT_VALUE = 0.50;

    private final CouponRepository couponRepository;

    public Coupon createCoupon(CouponDTO couponDTO) {

        String clearCode = clearCode(couponDTO.code());

        validateCoupon(couponDTO, clearCode);

        Coupon coupon = Coupon.builder()
                .code(clearCode)
                .description(couponDTO.description())
                .discountValue(couponDTO.discountValue())
                .expirationDate(couponDTO.expirationDate())
                .deleted(false)
                .createdCoupon(LocalDateTime.now())
                .published(couponDTO.published())
                .build();

        return couponRepository.save(coupon);
    }

    public void couponDelete(Long couponId) {
        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow(() -> new RuntimeException("Coupon not found"));

        if(coupon.isDeleted()) {
            throw new RuntimeException("Coupon has been deleted");
        }

        coupon.setDeleted(true);
        couponRepository.save(coupon);
    }

    public void validateCoupon(CouponDTO couponDTO, String code) {

        if(code.length() != 6){
            throw new IllegalArgumentException("Coupon code length should be 6 characters");
        }

        if(couponDTO.discountValue() < MIN_DISCOUNT_VALUE){
            throw new IllegalArgumentException("Coupon discount value should be greater than 0,5");
        }

        if(couponDTO.expirationDate().isBefore(OffsetDateTime.now())){
            throw new IllegalArgumentException("Coupon expiration date should be before now");
        }

        if (couponDTO.description() != null && couponDTO.description().length() > 255) {
            throw new IllegalArgumentException("Description must be at most 255 characters");
        }
    }

    private String clearCode(String code) {
        return code.replaceAll(BASE62, "")
                .substring(0, Math.min(6, code.length()))
                .toUpperCase();
    }

    public Coupon getCoupon(Long id) {
        return couponRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Coupon not found"));
    }
}
