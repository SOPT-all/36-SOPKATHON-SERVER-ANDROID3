package sopt.android3.sopkathon.recipe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sopt.android3.sopkathon.recipe.domain.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Long> {

	Recipe findByRecipeId(Long recipeId);
}
