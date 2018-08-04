package com.group1.merchant.controller;

import com.group1.merchant.service.RecipeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Resource(name = "recipeService")
    private RecipeService recipeService;

}
