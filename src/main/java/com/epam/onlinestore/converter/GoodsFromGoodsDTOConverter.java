package com.epam.onlinestore.converter;

import com.epam.onlinestore.api.dto.GoodsDTO;
import com.epam.onlinestore.entity.Goods;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GoodsFromGoodsDTOConverter implements Converter<GoodsDTO, Goods> {

  @Override
  public Goods convert(GoodsDTO goodsDTO) {
    Goods goods = new Goods();
    goods.setGoodsId(goodsDTO.getGoodsId());
    goods.setGoodsName(goodsDTO.getGoodsName());
    goods.setGoodsDescription(goodsDTO.getGoodsDescription());
    goods.setGoodsPrice(goodsDTO.getGoodsPrice());
    //не надо давать возможность creationDate и updateDate сетать из API, даты сетаются при создании/изменении записи в БД
    return goods;
  }
}
