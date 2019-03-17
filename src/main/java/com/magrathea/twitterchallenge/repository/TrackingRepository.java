package com.magrathea.twitterchallenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.magrathea.twitterchallenge.entity.Tracking;

public interface TrackingRepository extends JpaRepository<Tracking, Integer> {
	
	Tracking findByKeyword(final String keyword);
	
	@Query("SELECT tracking.keyword FROM Tracking tracking")
	List<String> findKeywords();
}
