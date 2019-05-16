package cn.fvti.cs2018.ws.web;

import cn.fvti.cs2018.ws.bean.model.NewsInfo;
import cn.fvti.cs2018.ws.bean.query.NewsInfoQuery;
import cn.fvti.cs2018.ws.bean.vo.PageListVO;
import cn.fvti.cs2018.ws.bean.vo.ResponseData;
import cn.fvti.cs2018.ws.bean.vo.SuccessResponseData;
import cn.fvti.cs2018.ws.service.NewsInfoService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 新闻信息表 前端控制器
 * </p>
 *
 * @author gsd
 * @since 2019-05-16
 */
@RestController
@RequestMapping("/v1/api/newsInfo")
public class NewsInfoController extends BaseController {

    @Autowired
    private NewsInfoService newsInfoService;

    @GetMapping("/detail/{id}/")
    public ResponseData detail(@Valid @NotNull(message = "id号不能为空") @PathVariable Long id) {
        NewsInfo newsInfo = this.newsInfoService.getById(id);
        return SuccessResponseData.success(newsInfo);
    }

    @PostMapping("/listNews")
    public ResponseData listNews(@Valid NewsInfoQuery query) {
        Page page = new Page(query.getCurrent(), query.getSize());
        List<NewsInfo> result =this.newsInfoService.list(page, query);
        page.setRecords(result);
        return SuccessResponseData.success(new PageListVO<>(page));
    }
}
