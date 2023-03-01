package com.yansen.mall.controller;

import com.yansen.mall.entity.CartItemEntity;
import com.yansen.mall.entity.OrderEntity;
import com.yansen.mall.entity.OrderItemEntity;
import com.yansen.mall.service.CartService;
import com.yansen.mall.service.OrderItemService;
import com.yansen.mall.service.OrderService;
import com.yansen.mall.vo.CartVo;
import com.yansen.mall.vo.OrderListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.sql.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    CartService cartService;

    @Autowired
    OrderItemService orderItemService;

    @GetMapping("detail.html")
    public String detail() {
        return "detail";
    }

    @GetMapping("/order.html")
    public String order(Model model) {
        OrderListVo orderListVo = new OrderListVo();
        List<OrderEntity> orderList = orderService.list();
        List<OrderItemEntity> orderItemList = orderItemService.list();
        orderListVo.setOrderList(orderItemList);
        orderListVo.setOrders(orderList);
        model.addAttribute("orderList", orderListVo);
        return "orderList";
    }

    @GetMapping("/deleteOrder")
    public String deleteOrder(@RequestParam("orderId") Long orderId) {
        orderService.deleteOrder(orderId);
        return "redirect:http://localhost:8090/order.html";
    }

    @GetMapping("/toTrade")
    public String toTrade(Model model) throws ExecutionException, InterruptedException {
        CartVo cart = cartService.getCart();
        model.addAttribute("cartList", cart);
        return "confirm";
    }

    @PostMapping("/submitOrder")
    public String submitOrder(Model model, RedirectAttributes redirectAttributes) {
        CartVo cart = cartService.getCart();
        if (cart.getCountNum() != 0) {
            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setTotal(cart.getTotalAmount());
            orderEntity.setPaymentWay("手机支付");
            orderEntity.setDeliverWay("顺丰快递");
            orderEntity.setOrderTime(new Date(new java.util.Date().getTime()));
            if (orderService.getById(orderEntity.getOrderId()) != null) {
                String msg = "请勿重复下单";
                redirectAttributes.addFlashAttribute("msg", msg);
                return "redirect:http://localhost:8090/toTrade";
            }
            orderService.save(orderEntity);
            for (CartItemEntity item : cart.getItems()) {
                OrderItemEntity orderItemEntity = new OrderItemEntity();
                orderItemEntity.setOrderId(orderEntity.getOrderId());
                orderItemEntity.setOrderTime(orderEntity.getOrderTime());
                orderItemEntity.setSkuId(item.getSkuId());
                orderItemEntity.setCount(item.getCount());
                orderItemEntity.setImage(item.getImage());
                orderItemEntity.setTitle(item.getTitle());
                orderItemEntity.setTotalPrice(cart.getTotalAmount());
                orderItemService.save(orderItemEntity);
            }
            model.addAttribute("order", orderEntity);
            return "pay";
        } else {
            String msg = "下单失败";
            redirectAttributes.addFlashAttribute("msg", msg);
            return "redirect:http://localhost:8090/toTrade";
        }
    }
}
