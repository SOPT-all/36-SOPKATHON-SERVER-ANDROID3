package sopt.android3.sopkathon.region.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sopt.android3.sopkathon.region.domain.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region,Long> {
}
