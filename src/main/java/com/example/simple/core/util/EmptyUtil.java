package com.example.simple.core.util;

import java.util.Collection;
import java.util.Map;

/**
 * 空值判断工具类
 * 提供各种类型对象的空值判断方法
 */
public class EmptyUtil {

    /**
     * 判断对象是否为空
     * 支持Collection、Map、数组和字符串的判断
     *
     * @param obj 要判断的对象
     * @return 是否为空
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null)
            return true;
        if ((obj instanceof Collection))
            return ((Collection) obj).size() == 0;
        if ((obj instanceof Map))
            return ((Map) obj).size() == 0;
        if ((obj instanceof Object[]))
            return ((Object[]) (Object[]) obj).length == 0;
        return obj.toString().trim().length() == 0;
    }
}
