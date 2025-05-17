package sopt.android3.sopkathon.region.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sopt.android3.sopkathon.common.BaseResponse;
import sopt.android3.sopkathon.common.SuccessMessage;
import sopt.android3.sopkathon.recipe.domain.dto.response.RecipePreviewResponse;
import sopt.android3.sopkathon.region.service.RegionService;

@RestController
public class RegionController {
    private final RegionService regionService;

    protected RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("/api/v1/recipe/preview/{region_id}")
    public BaseResponse<RecipePreviewResponse> getRecipePreview(
            @PathVariable("region_id") Long region_id
    ) {
        return BaseResponse.success(SuccessMessage.OK, regionService.getRecipePreview(region_id));
    }
}
