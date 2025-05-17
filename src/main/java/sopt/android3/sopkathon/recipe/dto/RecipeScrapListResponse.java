package sopt.android3.sopkathon.recipe.dto;

import java.util.List;

public record RecipeScrapListResponse(
        int total_scrap_count,
        List<RecipeItem> recipe_list
) {
    public record RecipeItem(
            Long recipe_id,
            String recipe_owner_address,
            String recipe_name,
            String thumbnail_image,
            int recipe_level,
            String recipe_time
    ) {}
}