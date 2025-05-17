package sopt.android3.sopkathon.recipeStory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sopt.android3.sopkathon.recipeStory.domain.RecipeStory;

@Repository
public interface RecipeStoryJpaRepository extends JpaRepository<RecipeStory, Long> {
}
