package com.group1.client.controller;

import com.group1.client.service.RecipeService;
import com.group1.core.entity.recipe.Recipe;
import com.group1.core.utils.ResultBody;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("recipe")
public class RecipeController {

    @Resource(name="recipeService")
    private RecipeService recipeService;

    @GetMapping("/{shopId}")
    @ResponseBody
    public ResultBody listAll(@PathVariable String shopId){
        ResultBody resultBody = new ResultBody();
        List<Recipe> list = recipeService.getAll(shopId);
        resultBody.addData("recipes",list);
        return resultBody;
    }


}
