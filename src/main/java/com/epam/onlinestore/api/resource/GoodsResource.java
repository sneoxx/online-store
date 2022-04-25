package com.epam.onlinestore.api.resource;

import com.epam.onlinestore.api.dto.GoodsDTO;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = {"/goods"})
public interface GoodsResource {

  @GetMapping("/{id}")
  GoodsDTO get(@PathVariable("id") UUID id);

  @GetMapping
  List<GoodsDTO> getAll();

  @PostMapping
  GoodsDTO create(@RequestBody GoodsDTO goodsDTO);

}


