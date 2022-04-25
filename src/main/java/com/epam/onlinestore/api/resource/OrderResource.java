package com.epam.onlinestore.api.resource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = {"/order"})
public interface OrderResource {

  @GetMapping("/allOrder")
  String getAll(Model model);

}