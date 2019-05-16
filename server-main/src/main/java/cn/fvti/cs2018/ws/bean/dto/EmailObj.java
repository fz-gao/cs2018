package cn.fvti.cs2018.ws.bean.dto;

import lombok.Value;

/**
 * Created by gsd on 2018/12/24.
 * 只支持单个人发送邮件
 */
@Value
public class EmailObj {
    private String toEmail;
    private String subject;
    private String htmlText;
    private String fromEmail;
    private String password;
    private String sender;

    public final static  EmailObj getObjByToEmail(String toEmail, String htmlText) {
        EmailObj eo = new EmailObj(toEmail,
                "信息基础课程表单课程训练",
                htmlText,
                "fz_gao@163.com",
                "woshi00266",
                "高老师");
        return eo;
    }
}
