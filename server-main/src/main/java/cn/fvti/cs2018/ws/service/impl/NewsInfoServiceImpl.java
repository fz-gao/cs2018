package cn.fvti.cs2018.ws.service.impl;

import cn.fvti.cs2018.ws.bean.model.NewsInfo;
import cn.fvti.cs2018.ws.bean.query.NewsInfoQuery;
import cn.fvti.cs2018.ws.mapper.NewsInfoMapper;
import cn.fvti.cs2018.ws.service.NewsInfoService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 新闻信息表 服务实现类
 * </p>
 *
 * @author gsd
 * @since 2019-05-16
 */
@Service
public class NewsInfoServiceImpl extends ServiceImpl<NewsInfoMapper, NewsInfo> implements NewsInfoService {

    @Override
    public List<NewsInfo> list(Page<NewsInfo> page, NewsInfoQuery query) {
        return this.baseMapper.list(page, query.getPlatform());
    }
}
