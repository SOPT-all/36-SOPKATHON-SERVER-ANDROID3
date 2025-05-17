package sopt.android3.sopkathon.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.android3.sopkathon.recipe.domain.Recipe;

public interface RecipeJpaRepository extends JpaRepository<Recipe, Long> {

}
