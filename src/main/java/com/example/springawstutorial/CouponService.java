package com.example.springawstutorial;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CouponService {

    private final CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Transactional
    public Long save(Coupon coupon) {
        couponRepository.save(coupon);
        return coupon.getId();
    }

    public Coupon findById(Long couponId) {
        return couponRepository.findById(couponId).orElseThrow();
    }

    @Transactional
    public void delete(Long couponId) {
        couponRepository.deleteById(couponId);
    }

    @Transactional
    public int increment(Long couponId) {
        Coupon coupon = couponRepository.findById(couponId).orElseThrow();
        coupon.increment();
        return coupon.getQuantity();
    }

    @Transactional
    public int decrement(Long couponId) {
        Coupon coupon = couponRepository.findById(couponId).orElseThrow();
        coupon.decrement();
        return coupon.getQuantity();
    }

    public List<Coupon> findAll() {
        return couponRepository.findAll();
    }

}
