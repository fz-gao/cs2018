package cn.fvti.cs2018.ws.mapper;

import cn.fvti.cs2018.ws.bean.model.NewsInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 新闻信息表 Mapper 接口
 * </p>
 *
 * @author gsd
 * @since 2019-05-16
 */
public interface NewsInfoMapper extends BaseMapper<NewsInfo> {
    /**
     * Mapper接口列表
     * @param page
     * @param platform
     * @return
     */
    List<NewsInfo> list(@Param("page") Page<NewsInfo> page,
                        @Param("platform") Byte platform);
}
