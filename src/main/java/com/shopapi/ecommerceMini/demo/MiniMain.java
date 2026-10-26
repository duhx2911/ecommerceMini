package com.shopapi.ecommerceMini.demo;

public class MiniMain {
    public static void main(String[] args) {
        MiniContainer container = new MiniContainer();
        DemoController controller = container.getBean(DemoController.class);
        System.out.println("1. Tổng tiền đơn hàng: " + controller.getTotal());
        System.out.println("2. Sản phẩm trên 1 triệu, giá giảm dần: " + controller.getByPrice());
        System.out.println("3. Tổng tiền theo danh mục: " + controller.getByCate());
        System.out.println("4. Có dòng nào số lượng trên 10?: " + controller.hasBulk());
        System.out.println("5. Dòng đắt nhất: " + controller.mostExpensive());

    }
}
