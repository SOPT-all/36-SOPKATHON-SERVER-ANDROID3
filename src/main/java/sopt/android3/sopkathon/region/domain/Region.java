package sopt.android3.sopkathon.region.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import sopt.android3.sopkathon.recipe.domain.Recipe;

import java.util.List;

@Getter
@Entity
public class Region {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long regionId;


    private String region;

    @NonNull
    private Long recipeCount;

    @OneToMany(mappedBy = "region")
    private List<Recipe> recipes;


    public Region() {

    }

    public Region(String region, @NonNull Long recipeCount) {
        this.region = region;
        this.recipeCount = recipeCount;
    }


}
