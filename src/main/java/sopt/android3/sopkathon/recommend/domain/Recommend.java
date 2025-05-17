package sopt.android3.sopkathon.recommend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import sopt.android3.sopkathon.recipe.domain.Recipe;

@Entity
public class Recommend {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long recommend_id;

	private String recommend_img;

	private String recommend_store;

	private String recommend_store_url;

	private Long recommend_item_price;

	@ManyToOne
	@JoinColumn(name = "recipe_id", nullable = false)
	private Recipe recipe;
}
