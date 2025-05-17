package sopt.android3.sopkathon.region.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import sopt.android3.sopkathon.recipe.domain.Recipe;

@Getter
@Entity
public class Region {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long regionId;

	private String region;

	private Long recipeCount;

	@OneToMany(mappedBy = "region")
	private List<Recipe> recipes;

	public Region(){

	}

	public Region(String region, Long recipeCount){
		this.region = region;
		this.recipeCount =  recipeCount;
	}




}
