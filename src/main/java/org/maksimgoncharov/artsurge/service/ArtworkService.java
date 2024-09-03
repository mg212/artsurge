package org.maksimgoncharov.artsurge.service;

import org.maksimgoncharov.artsurge.model.Artwork;
import org.maksimgoncharov.artsurge.repo.ArtworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtworkService {

    @Autowired
    private ArtworkRepository artworkRepository;

    public List<Artwork> getAllArtworks() {
        return artworkRepository.findAll();
    }

    public Optional<Artwork> getArtworkById(Long id) {
        return artworkRepository.findById(id);
    }

    public Artwork saveArtwork(Artwork artwork) {
        return artworkRepository.save(artwork);
    }

    public void deleteArtwork(Artwork artwork) {
        artworkRepository.delete(artwork);
    }
}