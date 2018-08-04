package com.group1.client.controller;

import com.group1.client.service.RecipeService;
import com.group1.core.entity.recipe.Recipe;
import com.group1.core.utils.ResultBody;
import com.group1.core.utils.base.model.Pageable;
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

    @GetMapping("/{shopId}/{offset}/{size}")
    @ResponseBody
    public ResultBody listAllByShopId(@PathVariable String shopId,@PathVariable Integer offset,@PathVariable Integer size){
        ResultBody resultBody = new ResultBody();
        Pageable pageable = new Pageable();
        pageable.setOffset(offset);
        pageable.setSize(size);
        resultBody.addData("recipeList",recipeService.getAllByShopId(shopId,pageable));
        return resultBody;
    }


}
