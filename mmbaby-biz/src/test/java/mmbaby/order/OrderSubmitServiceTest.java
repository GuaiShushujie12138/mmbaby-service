package mmbaby.order;

import com.mmbaby.order.dto.submitbiz.OrderSubmitDTO;
import com.mmbaby.order.service.OrderSubmitService;
import com.mmbaby.orderline.dto.domain.OrderLineDTO;
import mmbaby.base.BaseJUnitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/22 at 21:59
 */
public class OrderSubmitServiceTest extends BaseJUnitTest {

    @Autowired
    private OrderSubmitService orderSubmitService;

    @Test
    public void saveOrderTest() {
        OrderSubmitDTO orderSubmitDTO = buildSubmitDTO();

        orderSubmitService.saveOrder(orderSubmitDTO);
    }

    private OrderSubmitDTO buildSubmitDTO() {
        OrderSubmitDTO orderSubmitDTO = new OrderSubmitDTO();

        OrderLineDTO orderLineDTO = new OrderLineDTO();
        orderLineDTO.setAmount(12.9);
        orderLineDTO.setNumber(9);

        orderSubmitDTO.setCustomerId(3);
        orderSubmitDTO.setNumber(4);
        orderSubmitDTO.setAddressId(1);
        orderSubmitDTO.setOrderLineList(Arrays.asList(orderLineDTO));

        return orderSubmitDTO;
    }

}
