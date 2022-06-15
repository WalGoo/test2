package com.sparta.recipes.controller;


import com.sparta.recipes.domain.Recipes;
import com.sparta.recipes.dto.RecipeDto;
import com.sparta.recipes.repository.RecipeRepository;
import com.sparta.recipes.service.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// @RequestMapping("/api")
public class RecipeController {

    private final RecipeRepository recipeRepository;
    private final RecipeService recipeService;

    public RecipeController(RecipeRepository recipeRepository, RecipeService recipeService) {
        this.recipeRepository = recipeRepository;
        this.recipeService = recipeService;
    }

    // 레시피 전체 조회
    @GetMapping("/api/board")
    public List<Recipes> giveAllOfRecipes() {
        System.out.println(recipeRepository.findAllByOrderByRecipeIdAsc());
        return recipeRepository.findAllByOrderByRecipeIdAsc();
    }

    // 레시피 수정
    @PutMapping("/api/board/{recipeId}")
    public Long editRecipe(@PathVariable Long recipeId, @RequestBody RecipeDto recipeDto) {
        recipeService.editRecipe(recipeDto, recipeId);
        return recipeId;
    }

    // 레시피 삭제
    @DeleteMapping("/api/board/{recipeId}")
    public Long deleteRecipe(@PathVariable Long recipeId) {
        recipeService.deleteRecipe(recipeId);
        return recipeId;
    }

    // 레시피 작성
    @PostMapping("/api/board")
    public Long createRecipe(@RequestBody RecipeDto recipeDto) {
        return recipeService.createRecipe(recipeDto);
    }

    // 레시피 상세 조회
    @GetMapping("/api/board/{recipeId}")
    public Recipes giveRecipe(@PathVariable Long recipeId) {
        return recipeService.selectRecipe(recipeId);
    }
}
