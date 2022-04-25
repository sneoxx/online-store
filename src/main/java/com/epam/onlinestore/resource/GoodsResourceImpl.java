package com.epam.onlinestore.resource;

import com.epam.onlinestore.api.dto.GoodsDTO;
import com.epam.onlinestore.api.resource.GoodsResource;
import com.epam.onlinestore.converter.GoodsDTOFromGoodsConverter;
import com.epam.onlinestore.converter.GoodsFromGoodsDTOConverter;
import com.epam.onlinestore.entity.Goods;
import com.epam.onlinestore.service.GoodsService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
public class GoodsResourceImpl implements GoodsResource {

  private final GoodsService goodsService;

//  private GoodsDTOFromGoodsConverter goodsDTOFromGoodsConverter = new GoodsDTOFromGoodsConverter();
//  private GoodsFromGoodsDTOConverter goodsFromGoodsDTOConverter = new GoodsFromGoodsDTOConverter();

  private final ConversionService conversionService;

  @Override
  public GoodsDTO get(UUID id) {
    Goods goodsResult = goodsService.getGoods(id);
    GoodsDTO goodsDTOCheck = conversionService.convert(goodsResult, GoodsDTO.class);
    log.info("get() - Получен customer: {}", goodsDTOCheck);
    return goodsDTOCheck;
  }

  @Override
  public List<GoodsDTO> getAll() {
    List<Goods> goodsList = goodsService.getAllGoods();
    List<GoodsDTO> goodsDTOList = new ArrayList<>();
    for (Goods goods : goodsList) {
      goodsDTOList.add(conversionService.convert(goods, GoodsDTO.class));
    }
    log.info("getAll() - Получены все goods");
    return goodsDTOList;
  }

  @Override
  public GoodsDTO create(GoodsDTO goodsDTO) {
//    Goods goodsConvert = goodsFromGoodsDTOConverter.convert(goodsDTO);
//    Goods goodsResult = goodsService.create(goodsConvert);
//    GoodsDTO goodsDTOCheck = goodsDTOFromGoodsConverter.convert(goodsResult);

    Goods goodsConvert = conversionService.convert(goodsDTO, Goods.class);
    Goods goodsResult = goodsService.create(goodsConvert);
    GoodsDTO goodsDTOCheck = conversionService.convert(goodsResult, GoodsDTO.class);
    log.info("create() - Создан новый goods {}", goodsDTOCheck);
    return goodsDTOCheck;
  }

//  @Override
//  public String getAll(Model model) {
//    List<GoodsDTO> goodsDTOList = getAllGoodsDTO();
//    model.addAttribute("goods", goodsDTOList);
//    log.info("getAll() - Получены все goods");
//    return "clientList";
//  }

//  public String getAll(Model model) {
//    List<ClientDTO> clientDTOList = getAllClientDTO();
//    model.addAttribute("clients", clientDTOList);
//    log.info("getAll() - Получены все client");
//    return "clientList";
//  }

//  @Override
//  public String create(Model model) {
//    model.addAttribute("clientDTO", new ClientDTO());
//    log.debug("create() - Форма добавления client");
//    return "addClient";
//  }

  /**
   * Получение всех Client из БД и конвертация их в ClientDTO
   * @return - List всех ClientDTO из БД
   */
  public List<GoodsDTO> getAllGoodsDTO() {
    List<Goods> goodsList = goodsService.getAllGoods();
    List<GoodsDTO> goodsDTOList = new ArrayList<>();
    for (Goods goods : goodsList) {
      goodsDTOList.add(conversionService.convert(goods, GoodsDTO.class));
    }
    log.debug("getAllGoodsDTO() - все Goods из БД успешно получены и сконвертированы в GoodsDTO: {}", goodsDTOList);
    return goodsDTOList;
  }



//  public List<ClientDTO> getAllClientDTO() {
//    List<Client> clientList = clientService.getAllClient();
//    List<ClientDTO> clientDTOList = new ArrayList<>();
//    for (Client client : clientList) {
//      clientDTOList.add(conversionService.convert(client, ClientDTO.class));
//    }
//    log.debug("getAllClientDTO() - все Client из БД успешно получены и сконвертированы в ClientDTO: {}", clientDTOList);
//    return clientDTOList;
//  }

}
