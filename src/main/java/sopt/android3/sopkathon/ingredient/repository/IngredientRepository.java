package sopt.android3.sopkathon.ingredient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sopt.android3.sopkathon.ingredient.domain.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Long> {
	List<Ingredient> findAllByIngredientId(Long ingredientId);
}
