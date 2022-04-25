package com.epam.onlinestore.service;

import com.epam.onlinestore.entity.Goods;
import java.util.List;
import java.util.UUID;

public interface GoodsService {

  /**
   * Получение Goods из БД
   *
   * @param id - id Goods, которое необходимо получить
   * @return - пoods полученный из базы или новый goods в случае отсутствия такового id в БД
   */
  Goods getGoods(UUID id);

  /**
   * Получение всех Goods из БД
   *
   * @return - коллекция list goods
   */
  List<Goods> getAllGoods();

  /**
   * Создание и запись в БД экземпляра Goods
   *
   * @param goods- Экземпляр Goods
   * @return - Goods записанный в базу
   */
  Goods create(Goods goods);

}