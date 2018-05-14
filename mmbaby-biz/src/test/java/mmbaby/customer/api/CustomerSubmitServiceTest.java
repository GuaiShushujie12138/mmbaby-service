package mmbaby.customer.api;

import com.mmbaby.customer.dto.submitbiz.CustomerSubmitDTO;
import com.mmbaby.customer.service.CustomerSubmitService;
import mmbaby.base.BaseJUnitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/14 at 12:19
 */
public class CustomerSubmitServiceTest extends BaseJUnitTest {

    @Autowired
    private CustomerSubmitService customerSubmitService;

    /**
     * 客户注册测试
     */
    @Test
    public void registerTest() {
        CustomerSubmitDTO customerSubmitDTO = buildCustomerSubmitDTO();
        
//        customerSubmitService.submit()
    }

    private CustomerSubmitDTO buildCustomerSubmitDTO() {
        return null;
    }
}
