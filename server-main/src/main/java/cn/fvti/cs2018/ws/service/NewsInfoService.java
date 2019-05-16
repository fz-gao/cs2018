package cn.fvti.cs2018.ws.service;

import cn.fvti.cs2018.ws.bean.model.NewsInfo;
import cn.fvti.cs2018.ws.bean.query.NewsInfoQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 新闻信息表 服务类
 * </p>
 *
 * @author gsd
 * @since 2019-05-16
 */
public interface NewsInfoService extends IService<NewsInfo> {
    /**
     * 条件查询，并分页返回
     * @param page
     * @param query
     * @return
     */
    List<NewsInfo> list(Page<NewsInfo> page, NewsInfoQuery query);
}
