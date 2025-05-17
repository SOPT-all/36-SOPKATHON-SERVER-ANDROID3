package sopt.android3.sopkathon.recipe.domain.dto.response;

public record RecipePreviewResponse(
        Long recipe_id,
        String recipe_image,
        RecipeOwner recipe_owner,
        String recipe_name,
        String recipe_story,
        Long recipe_level,
        String cooking_time
) {
    public record RecipeOwner(
            String recipe_owner_image,
            String recipe_owner_name,
            String recipe_owner_address
    ) {

    }
}
