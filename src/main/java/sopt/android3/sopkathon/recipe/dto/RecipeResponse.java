package sopt.android3.sopkathon.recipe.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import sopt.android3.sopkathon.ingredient.domain.Ingredient;
import sopt.android3.sopkathon.ingredient.dto.IngredientResponse;
import sopt.android3.sopkathon.recommend.domain.Recommend;
import sopt.android3.sopkathon.recommend.dto.RecommendResponse;
import sopt.android3.sopkathon.review.domain.Review;
import sopt.android3.sopkathon.review.dto.ReviewResponse;

@Getter
public class RecipeResponse {

	private Long recipe_id;
	private String thumbnail_image;
	private String thumbnail_url;
	private Long recipe_level;
	private String recipe_time;
	private Boolean recipe_scrap;

	private List<IngredientResponse> ingredients;

	private Long owner_id;
	private String owner_name;
	private String owner_image;
	private String owner_residence;

	private String recipe_description; // 레시피 본문 (텍스트)

	private Long story_id;
	private String recipe_story;

	private List<ReviewResponse> reviews;
	private List<RecommendResponse> recommends;

	@Builder
	public RecipeResponse(Long recipe_id, String thumbnail_image, String thumbnail_url,
		Long recipe_level, String recipe_time, Boolean recipe_scrap, List<Ingredient> ingredients, Long owner_id,
		String owner_name, String owner_image, String owner_residence, String recipe_description, Long story_id,
		String recipe_story,
		List<Review> reviews, List<Recommend> recommends) {
		this.recipe_id = recipe_id;
		this.thumbnail_image = thumbnail_image;
		this.thumbnail_url = thumbnail_url;
		this.recipe_level = recipe_level;
		this.recipe_time = recipe_time;
		this.recipe_scrap = recipe_scrap;
		this.ingredients = ingredients.stream()
			.map(ingredient -> new IngredientResponse(ingredient.getIngredientId(),ingredient.getIngredientImage(),ingredient.getIngredientName(),ingredient.getIngredientAmount())).toList();
		this.owner_id = owner_id;
		this.owner_name = owner_name;
		this.owner_image = owner_image;
		this.owner_residence = owner_residence;
		this.recipe_description = recipe_description;
		this.story_id = story_id;
		this.recipe_story = recipe_story;
		this.reviews = reviews.stream()
			.map(review -> new ReviewResponse(review.getReviewId(),review.getReviewContent()))
			.toList();
		this.recommends = recommends.stream()
			.map(recommend -> new RecommendResponse(recommend.getRecommendId(),recommend.getRecommendImg(),recommend.getRecommendStore(),recommend.getRecommendStoreUrl(),recommend.getRecommendItemPrice()))
			.toList();
	}
}
