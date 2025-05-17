package sopt.android3.sopkathon.owner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sopt.android3.sopkathon.owner.domain.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
	Owner findByOwnerId(Long onwerId);
}
