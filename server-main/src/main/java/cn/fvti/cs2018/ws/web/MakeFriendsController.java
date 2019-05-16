package cn.fvti.cs2018.ws.web;

import cn.fvti.cs2018.ws.bean.dto.EmailObj;
import cn.fvti.cs2018.ws.bean.dto.MakeFriendsInfo;
import cn.fvti.cs2018.ws.util.EmailUtil;
import com.google.common.base.Joiner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by gsd on 2018/12/25.
 */
@Controller
@RequestMapping("/v1/api/makefriends")
@Slf4j
public class MakeFriendsController {
    String str =
            "<!doctype html>\n" +
            "<html>\n" +
            "    <head>\n" +
            "        <title>信息基础课表单练习——可以和我交朋友么？</title>\n" +
            "        <meta charset=\"utf-8\">\n" +
            "        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/mf.css\">\n" +
            "    </head>\n" +
            "    \n" +
            "    <body>\n" +
            "        <h1>%s: 您好！<br>        已经收到您的择友条件（%s），后续我们会通知你来参加我院《非诚勿扰》</h1>\n" +
            "        <br>\n" +
            "        <br>\n" +
            "        <br>\n" +
            "        <br>\n" +
            "        <p>\n" +
            "            ps: 本邮件是教学练习使用，若发错邮件，请忽略。对不够仔细的学生（填错邮箱地址），我向您表示歉意！\n" +
            "        </p>\n" +
            "       \n" +
            "    </body>\n" +
            "</html>";

    @PostMapping("/input")
    public String mfInput(MakeFriendsInfo info, Model model) {
        log.info("request mfInput info:{}", info);
        EmailObj emailObj = EmailObj.getObjByToEmail(info.getEmail(),
                String.format(str,info.getName(), "input练习"));
        EmailUtil.asySendEmail(emailObj);

        Joiner joiner = Joiner.on("<br>");
        Joiner.MapJoiner mapJoiner = joiner.withKeyValueSeparator(":");

        Map maps = MakeFriendsInfo.getNoNullOrEmpty(info);
        model.addAttribute("result", mapJoiner.join(maps));
        return "makefriends";
    }
}
