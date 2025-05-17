package sopt.android3.sopkathon.ingredient.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import sopt.android3.sopkathon.recipe.domain.Recipe;

@Getter
@Entity
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ingredientId;

	private String ingredientImage;

	private String ingredientName;

	private String ingredientAmount;

	private Boolean isLocal;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "recipe_id", nullable = false)
	private Recipe recipe;



}
