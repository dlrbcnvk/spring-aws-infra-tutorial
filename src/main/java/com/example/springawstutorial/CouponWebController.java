package com.example.springawstutorial;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
public class CouponWebController {

    private final CouponService couponService;

    public CouponWebController(CouponService couponService) {
        this.couponService = couponService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Coupon> couponList = couponService.findAll();
        model.addAttribute("couponList", couponList);
        return "index";
    }

    @GetMapping("/increment/{couponId}")
    public String increment(@PathVariable("couponId") String couponId) {
        couponService.increment(Long.valueOf(couponId));
        return "redirect:/";
    }

    @GetMapping("/decrement/{couponId}")
    public String decrement(@PathVariable("couponId") String couponId) {
        couponService.decrement(Long.valueOf(couponId));
        return "redirect:/";
    }

    @PostMapping("/add")
    public String addCoupon(@ModelAttribute CouponAddDto dto) {
        log.info("dto={}", dto);
        if (dto == null) {
            return "redirect:/";
        }
        Coupon coupon = new Coupon(dto.getQuantity());
        couponService.save(coupon);
        return "redirect:/";
    }
}
