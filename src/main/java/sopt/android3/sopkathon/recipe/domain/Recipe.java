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
	private Long recipe_id;

	private String thumbnail_image;

	private String thumbnail_url;

	private Long recipe_level;

	private String recipe_time;

	private Boolean recipe_scrap;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "region_id", nullable = false)
	private Region region;


	@OneToMany(mappedBy = "recipe")
	private List<Ingredient> ingredients;


	@OneToOne
	@JoinColumn(name = "owner_id",nullable = false)
	private Owner owner;





}
