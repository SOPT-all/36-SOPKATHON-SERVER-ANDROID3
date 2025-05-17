package sopt.android3.sopkathon.recipeStory.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import sopt.android3.sopkathon.recipe.domain.Recipe;

@Getter
@Entity
public class RecipeStory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long storyId;

	private String recipeStory;

	private String recipeSmallTitle;


	@OneToOne
	@JoinColumn(name = "recipeId",nullable = false)
	private Recipe recipe;

}
