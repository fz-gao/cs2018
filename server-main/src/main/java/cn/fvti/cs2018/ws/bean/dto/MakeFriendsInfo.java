package cn.fvti.cs2018.ws.bean.dto;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by gsd on 2018/12/25.
 */
@Data
public class MakeFriendsInfo {
    private String name;
    private String nickname;
    private String addr;
    private String email;
    private String url;
    private String about;

    private String purpose;
    private String gender;
    private Integer num;
    private String date;
    private List<String> extras;

    public static Map getNoNullOrEmpty(MakeFriendsInfo info) {
        Map maps = Maps.newHashMap();

        putStrValue("个人主页", info.getUrl(),maps);
        putStrValue("昵称", info.getNickname(),maps);
        putStrValue("邮箱", info.getEmail(),maps);
        putStrValue("宿舍", info.getAddr(),maps);
        putStrValue("姓名", info.getName(),maps);
        putStrValue("关于你", info.getAbout(),maps);
        putStrValue("择友目的", info.getPurpose(),maps);
        putStrValue("择友性别", info.getGender(),maps);
        putIntValue("数量", info.getNum(),maps);
        putStrValue("日期", info.getDate(),maps);
        putIteratorValue("附加", info.getExtras(), maps);
        return maps;
    }

    private static void putStrValue(String label, String value, Map<String, Object> maps) {
        if(!Strings.isNullOrEmpty(value)) {
            maps.put(label, value);
        }
    }
    private static void putIntValue(String label, Integer value, Map<String, Object> maps) {
        if(!Objects.isNull(value) && value>0) {
            maps.put(label, value);
        }}

    private static void putIteratorValue(String label, Iterable value, Map<String, Object> maps) {
        Joiner joiner = Joiner.on("、");
        if(value!=null) {
            maps.put(label, joiner.join(value));
        }
    }
}
