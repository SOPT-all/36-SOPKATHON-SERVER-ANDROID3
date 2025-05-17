package sopt.android3.sopkathon.region.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import sopt.android3.sopkathon.region.repository.RegionRepository;

@RequiredArgsConstructor
@Service
public class RegionService {

	private final RegionRepository regionRepository;


}
