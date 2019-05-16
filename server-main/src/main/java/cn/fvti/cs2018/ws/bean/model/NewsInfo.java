package cn.fvti.cs2018.ws.bean.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 新闻信息表
 * </p>
 *
 * @author gsd
 * @since 2019-05-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class NewsInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 新闻标题
     */
    private String title;

    /**
     * 新闻报道时间
     */
    private LocalDateTime newsTime;

    /**
     * 新闻报道来源
     */
    private String newsSource;

    /**
     * 新闻详情链接
     */
    private String detailUrl;

    private LocalDateTime createTime;

    /**
     * 新闻爬取平台（1: 腾讯热点新闻；2: 网易新闻排行；3: 新浪排行；4: 凤凰新闻；5: 搜狐新闻；6: 今日头条；7: 百度热搜；8: 微博热搜）
     */
    private Integer platform;

    /**
     * 编辑时间
     */
    private LocalDateTime editTime;

    /**
     * 新闻详情的内容id
     */
    private Long detailId;

}
