package sopt.android3.sopkathon.recommend.dto;

public record RecommendResponse(Long recommend_id,
								String recommend_img,
								String recommend_store, String recommend_store_url, Long recommend_item_price) {
}
