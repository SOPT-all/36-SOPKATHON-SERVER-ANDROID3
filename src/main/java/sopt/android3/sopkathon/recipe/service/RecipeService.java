package sopt.android3.sopkathon.recipe.service;

import org.springframework.stereotype.Service;
import sopt.android3.sopkathon.recipe.repository.RecipeJpaRepository;

@Service
public class RecipeService {
    private final RecipeJpaRepository recipeRepository;

    protected RecipeService(final RecipeJpaRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }
}
