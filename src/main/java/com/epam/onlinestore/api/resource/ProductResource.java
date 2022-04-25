package com.epam.onlinestore.api.resource;

import com.epam.onlinestore.api.dto.GoodsDTO;
import com.epam.onlinestore.api.dto.ProductDTO;
import java.util.List;
import java.util.UUID;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = {"/product"})
public interface ProductResource {

  @GetMapping("/{id}")
  ProductDTO get(@PathVariable("id") UUID id);

  @GetMapping
  List<ProductDTO> getAll();

  @PostMapping
  ProductDTO create(@RequestBody ProductDTO productDTO);


//  @GetMapping
//  String getAll(Model model);
//
//  @GetMapping("/{id}")
//  String get(Model model);
//
//  @PostMapping
//  String create(ProductDTO productDTO, BindingResult bindingResult);
//

//1.3.1.1	GET /product
//  Возвращает список доступной для поставки продукции (из таблицы товар).
//
//      1.3.1.2	GET /product/{id}
//  Возвращает данные по конкретному идентификатору товара.
//
//      1.3.1.3	POST /product
//  Заведение новой продукции для создания и последующих заказов.


}