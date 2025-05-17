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
	private Long region_id;

	private String region;

	private Long recipe_count;

	@OneToMany(mappedBy = "region")
	private List<Recipe> recipes;

	public Region(){

	}

	public Region(String region, Long recipe_count){
		this.region = region;
		this.recipe_count =  recipe_count;
	}




}
