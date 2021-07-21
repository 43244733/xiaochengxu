package com.example.controller;

import com.example.bean.Shop;
import com.example.service.SerachBase;
import com.example.service.ShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品搜索
 */
@Api(tags = "SearchController", description = "商品搜索")
@RestController
public class SearchController {

    @Autowired
    private ShopService shopService;

    @ApiOperation("模糊搜索")
    @RequestMapping(value = "/search", produces = "application/json; charset=utf-8")
    public List<Shop> search(String input) {
        SerachBase serachBase = SerachBase.getSerachBase();
        List<Shop> shops = shopService.selectAll();
        for (int i = 0; i < shops.size(); i++) {
            String id = String.valueOf(shops.get(i).getId());
            String value = shops.get(i).getName();
            serachBase.add(id, value, value);
        }
        String ids = serachBase.getIds(input);

        /**
         * @param ids
         * @Description: 根据ids获取详细，id之间用","隔开
         */

        if (ids == null || "".equals(ids)) {
            return null;
        }
        List<Shop> objs = new ArrayList<>();
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            Shop shop = shopService.selectGoodsById(Integer.valueOf(id));
            objs.add(shop);
        }
        return objs;
    }
}
