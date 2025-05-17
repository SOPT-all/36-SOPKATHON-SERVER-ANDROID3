package sopt.android3.sopkathon.review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sopt.android3.sopkathon.recipe.domain.Recipe;
import sopt.android3.sopkathon.review.domain.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
	List<Review> findAllByRecipe(Recipe recipe);
}
