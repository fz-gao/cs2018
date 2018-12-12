package cn.fvti.cs2018.ws.web;

/**
 * Created by gsd on 2018/12/12.
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v1/api/user")
@ResponseBody
@Slf4j
public class UserController extends BaseController {

}