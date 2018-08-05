package com.group1.merchant.controller;

import com.group1.core.entity.merchant.Merchant;
import com.group1.core.entity.merchant.MerchantDetail;
import com.group1.core.entity.recipe.Recipe;
import com.group1.core.entity.shop.Shop;
import com.group1.core.utils.ResultBody;
import com.group1.merchant.service.MerchantDetailService;
import com.group1.merchant.service.RecipeService;
import com.group1.merchant.service.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    @Resource(name = "recipeService")
    private RecipeService recipeService;

    @Resource(name = "merchantDetailService")
    private MerchantDetailService merchantDetailService;

    @Resource(name = "shopService")
    private ShopService shopService;

    @PostMapping
    @ResponseBody
    public ResultBody saveRecipe(@Valid @RequestBody Recipe recipe, Errors errors, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ResultBody resultBody = new ResultBody();
        Merchant merchant = (Merchant) session.getAttribute("merchant");
        if(merchant == null) {
            response.sendRedirect("/");
        }

        MerchantDetail merchantDetail = merchantDetailService.getMerchantDetail(merchant);
        if(merchantDetail != null && merchantDetail.getStatus().equals(MerchantDetail.PASSED)) {
            System.out.println(errors.hasErrors());
            if(errors.hasErrors()) {
                resultBody.addData("errors", errors);
            }else{
                String shopId = merchantDetail.getShopId();
                Shop shop = shopService.findByShopId(shopId);
                recipe.setShop(shop);
                resultBody.addData("recipe", recipeService.saveRecipe(recipe));
            }
            return resultBody;
        }else {
            resultBody.addData("errors","No Application Shop Or Application failed");
            request.getRequestDispatcher("merchantDetail").forward(request, response);
            return resultBody;
        }
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

    @GetMapping
    public void getRecipes(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Merchant merchant = (Merchant) session.getAttribute("merchant");
        if(merchant == null) {
            response.sendRedirect("/");
            return;
        }
        MerchantDetail merchantDetail = merchantDetailService.getMerchantDetail(merchant);
        if(merchantDetail !=null && merchantDetail.getStatus().equals(MerchantDetail.PASSED)) {
            String shopId = merchantDetail.getShopId();
            List<Recipe> recipes = recipeService.getRecipesByShopId(shopId);
            request.setAttribute("recipes", recipes);
            request.getRequestDispatcher("recipeManager").forward(request,response);
        }else {
            request.getRequestDispatcher("merchantDetail").forward(request, response);
        }
    }

    @DeleteMapping("/{recipeId}")
    @ResponseBody
    public ResultBody deleteRecipe(@PathVariable String recipeId) {
        ResultBody resultBody = new ResultBody();
        boolean isDelete = recipeService.deleteRecipeById(recipeId);
        if(!isDelete) {
            resultBody.addData("errors", "delete recipe fail");
        } else {
            resultBody.setMessage("删除成功！");
            resultBody.addData("recipeId", recipeId);
        }
        return resultBody;
    }
}
