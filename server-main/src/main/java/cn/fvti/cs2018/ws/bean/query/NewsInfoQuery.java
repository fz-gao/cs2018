package cn.fvti.cs2018.ws.bean.query;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class NewsInfoQuery {

    @Min(value = 1, message = "平台不存在")
    @Max(value = 8, message = "平台不存在")
    private Byte platform;

    @Min(value = 1, message = "当前页面编号从1开始")
    private Integer current = 1;
    @Min(value = 5, message = "每页数量设置小于5")
    @Max(value = 200, message = "每页数量设置超过200")
    private Integer size = 10;
}
