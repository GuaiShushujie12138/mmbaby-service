package mmbaby.base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/14 at 12:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath*:config/spring/*.xml"})
//@Rollback()
//@Transactional
public class BaseJUnitTest {


    @Test
    public void testBase() {
        System.out.println("==========开始测试=============");
    }

}
