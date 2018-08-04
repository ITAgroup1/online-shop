package com.group1.merchant.controller;

import com.group1.core.entity.recipe.Recipe;
import com.group1.core.utils.ResultBody;
import com.group1.merchant.service.RecipeService;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/recipe")
@SessionAttributes("merchant")
public class RecipeController {

    @Resource(name = "recipeService")
    private RecipeService recipeService;

    @PostMapping
    public ResultBody saveRecipe(@Valid @RequestBody Recipe recipe, Errors errors) {
        ResultBody resultBody = new ResultBody();
        if(errors.hasErrors()) {
            resultBody.addData("errors", errors);
        }else{
            resultBody.addData("recipe", recipeService.saveRecipe(recipe));
        }
        return resultBody;
    }

    @PutMapping
    public ResultBody updateRecipe(@Valid @RequestBody Recipe recipe, Errors errors) {
        ResultBody resultBody = new ResultBody();
        if(errors.hasErrors()) {
            resultBody.addData("errors", errors);
        } else{
            resultBody.addData("recipe", recipeService.updateRecipe(recipe));
        }
        return resultBody;
    }

    @GetMapping("/{shopId}")
    public ResultBody getRecipes(@PathVariable String shopId) {
        ResultBody resultBody = new ResultBody();
        resultBody.addData("recipes", recipeService.getRecipeByShopId(shopId));
        return resultBody;
    }

    @DeleteMapping("/{recipeId}")
    public ResultBody deleteRecipe(@PathVariable String recipeId) {
        ResultBody resultBody = new ResultBody();
        boolean isDelete = recipeService.deleteRecipeById(recipeId);
        if(!isDelete) {
            resultBody.addData("errors", "delete recipe fail");
        } else {
            resultBody.addData("recipeId", recipeId);
        }
        return resultBody;
    }
}
