package mmbaby.customer.api;

import com.mmbaby.base.util.security.MD5Util;
import com.mmbaby.customer.dto.submitbiz.CustomerSubmitDTO;
import com.mmbaby.customer.service.CustomerSubmitService;
import lombok.extern.log4j.Log4j;
import mmbaby.base.BaseJUnitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/14 at 12:19
 */

@Log4j
public class CustomerSubmitServiceTest extends BaseJUnitTest {

    @Autowired
    private CustomerSubmitService customerSubmitService;

    /**
     * 客户注册测试
     */
    @Test
    public void registerTest() {
        CustomerSubmitDTO customerSubmitDTO = buildCustomerSubmitDTO();
        
        log.debug("==>" + customerSubmitService.submit(customerSubmitDTO));
    }

    private CustomerSubmitDTO buildCustomerSubmitDTO() {
        CustomerSubmitDTO customerSubmitDTO = new CustomerSubmitDTO();

        customerSubmitDTO.setCustomerName("李四");
        customerSubmitDTO.setPassword(MD5Util.getMD5ofStr("123456"));

        return customerSubmitDTO;
    }
}
