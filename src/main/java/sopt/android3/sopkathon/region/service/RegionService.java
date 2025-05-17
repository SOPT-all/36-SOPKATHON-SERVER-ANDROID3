package sopt.android3.sopkathon.region.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import sopt.android3.sopkathon.common.CustomException;
import sopt.android3.sopkathon.common.ErrorMessage;
import sopt.android3.sopkathon.owner.domain.Owner;
import sopt.android3.sopkathon.owner.repository.OwnerJpaRepository;
import sopt.android3.sopkathon.recipe.domain.Recipe;
import sopt.android3.sopkathon.recipe.domain.dto.response.RecipePreviewResponse;
import sopt.android3.sopkathon.recipe.repository.RecipeJpaRepository;
import sopt.android3.sopkathon.recipeStory.domain.RecipeStory;
import sopt.android3.sopkathon.recipeStory.repository.RecipeStoryJpaRepository;
import sopt.android3.sopkathon.region.domain.Region;
import sopt.android3.sopkathon.region.repository.RegionRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RegionService {
	private final RegionRepository regionRepository;
	private final RecipeJpaRepository recipeRepository;
	private final RecipeStoryJpaRepository recipeStoryRepository;
	private final OwnerJpaRepository ownerJpaRepository;

	public RecipePreviewResponse getRecipePreview(Long regionId) {
		Long totalCount = regionRepository.findByRegionId(regionId).getRecipeCount();
		Long recipeId = getRandomRecipe(totalCount);

		Recipe recipe = recipeRepository.findById(recipeId)
				.orElseThrow(() -> new CustomException(ErrorMessage.NOT_FOUND_ERROR));

		String recipeStory = recipeStoryRepository.findById(recipeId)
				.map(RecipeStory::getRecipeStory)
				.orElse("");

		Owner owner = ownerJpaRepository.findById(recipe.getOwner().getOwnerId())
				.orElseThrow(() -> new CustomException(ErrorMessage.NOT_FOUND_ERROR));

		return new RecipePreviewResponse(
				recipe.getRecipeId(),
				recipe.getThumbnailImage(),
				new RecipePreviewResponse.RecipeOwner(
						owner.getOwnerImage(),
						owner.getOwnerName(),
						owner.getOwnerResidence()
				),
				recipe.getRecipeName(),
				recipeStory,
				recipe.getRecipeLevel(),
				recipe.getRecipeTime()

		);
	}

	private Long getRandomRecipe(Long totalCount) {
		if(totalCount <= 0) {
			// TODO 에러 핸들링
			throw new IllegalArgumentException("totalCount가 1보다 작습니다");
		}
		return (long)(Math.random() * totalCount + 1);
	}
}
