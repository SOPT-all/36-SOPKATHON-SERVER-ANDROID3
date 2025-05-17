package sopt.android3.sopkathon.recipe.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import sopt.android3.sopkathon.recipe.dto.RecipeResponse;
import sopt.android3.sopkathon.recipe.repository.RecipeRepository;
import sopt.android3.sopkathon.recipe.service.RecipeService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class RecipeController {

	private final RecipeService recipeService;


	@GetMapping("/recipe/{recipe_id}")
	public ResponseEntity<RecipeResponse> getRecipe(@PathVariable("recipe_id") Long recipeId){
		return ResponseEntity.ok(recipeService.getRecipe(recipeId));
	}

}
