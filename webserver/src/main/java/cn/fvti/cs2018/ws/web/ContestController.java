package cn.fvti.cs2018.ws.web;

/**
 * Created by gsd on 2018/12/12.
 */

import cn.fvti.cs2018.ws.entity.Results;
import cn.fvti.cs2018.ws.entity.bean.Name;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v1/api/contest")
@Slf4j
public class ContestController extends BaseController {
    @PostMapping("/join")
    public String contest(String lastname, String firstname, Model model) {
        log.info("request contest lastname:{}, firstname:{}", lastname, firstname);
        model.addAttribute("lastname", lastname);
        model.addAttribute("firstname", firstname);
        return "contest";
    }
}