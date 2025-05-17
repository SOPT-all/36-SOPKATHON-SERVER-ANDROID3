package sopt.android3.sopkathon.ingredient.dto;

public record IngredientResponse(Long ingredient_id,
								 String ingredient_image
								 ,String ingredient_Name,
								 String ingredient_amount,
								 Boolean isLocal
								 ) {
}
