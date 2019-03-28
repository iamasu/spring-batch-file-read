package com.pms.config;

import org.springframework.batch.item.ItemProcessor;

/**
 *
 * @author Asu
 */
public class OrderItemProcessor implements ItemProcessor<Order, SvcReq> {

    @Override
    public SvcReq process(final Order order) throws Exception {

        final SvcReq svcReq = new SvcReq();

        svcReq.setId(order.getOrderID());
        svcReq.setName(order.getOrderName().toUpperCase());

        System.out.println("Converting (" + order + ") into (" + svcReq + ")");

        return svcReq;
    }

}
