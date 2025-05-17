package sopt.android3.sopkathon.recipe.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import sopt.android3.sopkathon.owner.domain.Owner;
import sopt.android3.sopkathon.ingredient.domain.Ingredient;
import sopt.android3.sopkathon.region.domain.Region;

@Getter
@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long recipeId;

	private String thumbnailImage;

	private String thumbnailUrl;

	private Long recipeLevel;

	private String recipeTime;

	private Boolean recipeScrap;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "regionId", nullable = false)
	private Region region;


	@OneToMany(mappedBy = "recipe")
	private List<Ingredient> ingredients;


	@ManyToOne

	@JoinColumn(name = "owner_id",nullable = false)
	private Owner owner;

	private String recipeDescription;


}
