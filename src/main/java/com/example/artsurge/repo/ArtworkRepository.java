package com.example.artsurge.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// ArtworkRepository interface
@Repository
public interface ArtworkRepository extends JpaRepository<Artwork, Long> {}
