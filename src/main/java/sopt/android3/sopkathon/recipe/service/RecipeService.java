package sopt.android3.sopkathon.recipe.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import sopt.android3.sopkathon.ingredient.repository.IngredientRepository;
import sopt.android3.sopkathon.owner.domain.Owner;
import sopt.android3.sopkathon.owner.repository.OwnerJpaRepository;
import sopt.android3.sopkathon.recipe.domain.Recipe;
import sopt.android3.sopkathon.recipe.dto.RecipeResponse;
import sopt.android3.sopkathon.recipe.dto.RecipeScrapListResponse;
import sopt.android3.sopkathon.recipe.repository.RecipeRepository;
import sopt.android3.sopkathon.recipeStory.domain.RecipeStory;
import sopt.android3.sopkathon.recipeStory.repository.RecipeStoryRepository;
import sopt.android3.sopkathon.recommend.domain.Recommend;
import sopt.android3.sopkathon.recommend.repository.RecommendRepository;
import sopt.android3.sopkathon.review.domain.Review;
import sopt.android3.sopkathon.review.repository.ReviewRepository;

@RequiredArgsConstructor
@Service
public class RecipeService {

	private final RecipeRepository recipeRepository;
	private final IngredientRepository ingredientRepository;
	private final RecipeStoryRepository recipeStoryRepository;
	private final ReviewRepository reviewRepository;
	private final RecommendRepository recommendRepository;
    private final OwnerJpaRepository ownerRepository;


	@Transactional(readOnly = true)
	public RecipeResponse getRecipe(Long recipeId){
		Recipe recipe = recipeRepository.findByRecipeId(recipeId);
		RecipeStory recipeStory = recipeStoryRepository.findByRecipe(recipe);
		List<Review> reviews = reviewRepository.findAllByRecipe(recipe);
		List<Recommend> recommends = recommendRepository.findAllByRecipe(recipe);

		return RecipeResponse.builder()
				.recipe_id(recipeId)
			.thumbnail_image(recipe.getThumbnailImage())
			.thumbnail_url(recipe.getThumbnailUrl())
			.recipe_level(recipe.getRecipeLevel())
			.recipe_time(recipe.getRecipeTime())
			.recipe_title(recipe.getRecipeName())
			.recipe_scrap(recipe.getRecipeScrap())
			.ingredients(recipe.getIngredients())
			.owner_id(recipe.getOwner().getOwnerId())
			.owner_name(recipe.getOwner().getOwnerName())
			.owner_image(recipe.getOwner().getOwnerImage())
			.owner_residence(recipe.getOwner().getOwnerResidence())
			.recipe(Arrays.asList(recipe.getRecipeDescription().split("\n")))
			.story_id(recipeStory.getStoryId())
			.recipe_story(recipeStory.getRecipeStory())
			.recipe_small_title(recipeStory.getRecipeSmallTitle())
			.reviews(reviews)
			.recommends(recommends)
			.build();
	}

    public RecipeScrapListResponse getScrappedRecipes() {
        List<Recipe> scrappedRecipes = recipeRepository.findAllByRecipeScrapTrue();

        List<RecipeScrapListResponse.RecipeItem> recipeItems = scrappedRecipes.stream()
                .map(recipe -> {
                    Owner owner = ownerRepository.findById(recipe.getOwner().getOwnerId())
                            .orElseThrow(() -> new RuntimeException("Owner not found"));

                    return new RecipeScrapListResponse.RecipeItem(
                            recipe.getRecipeId(),
                            owner.getOwnerResidence(),
                            recipe.getRecipeName(),
                            recipe.getThumbnailImage(),
                            recipe.getRecipeLevel().intValue(),
                            recipe.getRecipeTime()
                    );
                })
                .toList();

        return new RecipeScrapListResponse(recipeItems.size(), recipeItems);
    }


}
