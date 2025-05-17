package sopt.android3.sopkathon.recipeStory.service;

import org.springframework.stereotype.Service;
import sopt.android3.sopkathon.recipeStory.repository.RecipeStoryJpaRepository;

@Service
public class RecipeStoryService {
    private final RecipeStoryJpaRepository recipeStoryRepository;

    protected RecipeStoryService(RecipeStoryJpaRepository recipeStoryRepository) {
        this.recipeStoryRepository = recipeStoryRepository;
    }
}
