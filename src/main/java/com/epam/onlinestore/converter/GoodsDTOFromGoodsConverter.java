package com.epam.onlinestore.converter;

import com.epam.onlinestore.api.dto.GoodsDTO;
import com.epam.onlinestore.entity.Goods;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GoodsDTOFromGoodsConverter implements Converter<Goods, GoodsDTO> {

  @Override
  public GoodsDTO convert(Goods goods) {
    GoodsDTO goodsDTO = new GoodsDTO();
    goodsDTO.setGoodsId(goods.getGoodsId());
    goodsDTO.setGoodsName(goods.getGoodsName());
    goodsDTO.setGoodsDescription(goods.getGoodsDescription());
    goodsDTO.setGoodsPrice(goods.getGoodsPrice());
    goodsDTO.setCreationDate(goods.getCreationDate());
    goodsDTO.setUpdateDate(goods.getUpdateDate());
    return goodsDTO;
  }
}
