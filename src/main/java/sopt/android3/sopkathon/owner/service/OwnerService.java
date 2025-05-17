package sopt.android3.sopkathon.owner.service;

import org.springframework.stereotype.Service;
import sopt.android3.sopkathon.owner.repository.OwnerJpaRepository;

@Service
public class OwnerService {
    private final OwnerJpaRepository ownerRepository;

    public OwnerService(final OwnerJpaRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }
}
