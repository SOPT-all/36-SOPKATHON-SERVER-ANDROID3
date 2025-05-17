package sopt.android3.sopkathon.recommend.domain;

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
public class Recommend {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long recommendId;

	private String recommendImg;

	private String recommendStore;

	private String recommendStoreUrl;

	private Long recommendItemPrice;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "recipe_id", nullable = false)
	private Recipe recipe;
}
