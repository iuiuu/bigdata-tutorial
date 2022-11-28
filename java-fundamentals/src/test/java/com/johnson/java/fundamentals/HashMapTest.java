package com.johnson.java.fundamentals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author johnson lin
 * @date 2022/5/6 18:04
 */
public class HashMapTest {
    @Test
    public void testHashMap(){
        Map<String, Object> source = new HashMap<>(16);
        source.put("goods_name", "goods_name");
        source.put("goods_img", null);

        Object objGoodsName = source.get("goods_name");
        Object objGoodsImg = source.get("goods_img");
        Object objParentId = source.get("opid");

        Object obj = source.get("opid");

        if (obj == null) {

        }

        Assertions.assertNotNull(objGoodsImg);
//        Assertions.assertNull(objGoodsImg);


//        String goodsName = ObjectUtils.getIfNull(objGoodsName, () -> "").toString();
//        String goodsImg = ObjectUtils.getIfNull(objGoodsImg, () -> "").toString();
//        String parentId = ObjectUtils.getIfNull(objParentId, () -> "").toString();

//        String goodsName = source.getOrDefault("goods_name", "").toString();
//        String goodsImg = source.getOrDefault("goods_img", "").toString();

//        System.out.println(goodsName);
//        System.out.println(goodsImg);
    }
}
