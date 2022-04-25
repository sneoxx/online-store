package com.epam.onlinestore.service.impl;

import com.epam.onlinestore.repository.GoodsRepository;
import com.epam.onlinestore.entity.Goods;
import com.epam.onlinestore.service.GoodsService;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class GoodsServiceImpl implements GoodsService {

  private final GoodsRepository goodsRepository;

  @Override
  public Goods getGoods(UUID id) {
    Goods goods = goodsRepository.findById(id).orElseThrow(RuntimeException::new);
    log.debug("getGoods() Объект Goods успешно получен из БД: {}", goods);
    return goods;
  }

  @Override
  public List<Goods> getAllGoods() {
    List<Goods> goodsList = goodsRepository.findAll();
    log.debug("getAllGoods() Объекты Goods успешно получены из БД: {}", goodsList);
    return goodsList;
  }

  @Override
  public Goods create(Goods goods) {
    Goods goodsCheck;
    if (goods.getGoodsId() != null && goodsRepository.existsById(goods.getGoodsId())) {
      Timestamp creationDate = goodsRepository.findById(goods.getGoodsId()).orElseThrow(RuntimeException::new).getCreationDate();
      goods.setCreationDate(creationDate);
      goods.setUpdateDate(new Timestamp(System.currentTimeMillis()));
      goodsCheck = goodsRepository.save(goods);
      log.debug("create() Объект Goods успешно обновлен в БД: {} ", goodsCheck);
    } else {
      goods.setCreationDate(new Timestamp(System.currentTimeMillis()));
      goodsCheck = goodsRepository.save(goods);
      log.debug("create() Объект Goods успешно записан в БД: {} ", goodsCheck);
    }
    return goodsCheck;
  }

}
