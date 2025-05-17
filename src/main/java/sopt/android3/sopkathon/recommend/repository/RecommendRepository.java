package sopt.android3.sopkathon.recommend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sopt.android3.sopkathon.recipe.domain.Recipe;
import sopt.android3.sopkathon.recommend.domain.Recommend;

@Repository
public interface RecommendRepository extends JpaRepository<Recommend,Long> {

	List<Recommend> findAllByRecipe(Recipe recipe);
}
