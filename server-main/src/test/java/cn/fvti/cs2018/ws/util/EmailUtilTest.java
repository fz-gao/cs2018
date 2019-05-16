package cn.fvti.cs2018.ws.util;

import cn.fvti.cs2018.ws.bean.dto.EmailObj;
import org.junit.Test;

/**
 * Created by gsd on 2018/12/24.
 */
public class EmailUtilTest {
    @Test
    public void testSendEmail() {
        EmailObj obj = new EmailObj("5400266@qq.com",
                "测试",
                "asfasdf",
                "fz_gao@163.com",
                "!@#$%^&*()",
                "fz_gao"
                );

        EmailUtil.sendSSLEmail(obj);
    }
}
