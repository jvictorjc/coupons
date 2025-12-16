package com.outforce.coupon.repository;

import com.outforce.coupon.entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CouponRepository extends JpaRepository<Coupon, Long> {


}
