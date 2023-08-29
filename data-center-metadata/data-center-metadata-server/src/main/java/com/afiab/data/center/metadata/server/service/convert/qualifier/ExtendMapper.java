package com.afiab.data.center.metadata.server.service.convert.qualifier;

import com.alibaba.fastjson.JSON;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/29 17:52
 * @Description:
 */
@Named("ExtendMapper")
@Component("ExtendMapper")
public class ExtendMapper {

    // list 转 json
//    @Named("translatorStr")
//    public String translatorStr(StuPO stu) {
//        if (null == stu) {
//            return null;
//        }
//        List<String> stus = new ArrayList<>();
//        stus.add(stu.getName());
//        stus.add(stu.getCreatedBy());
//        return JSON.toJSONString(stus);
//    }
}
