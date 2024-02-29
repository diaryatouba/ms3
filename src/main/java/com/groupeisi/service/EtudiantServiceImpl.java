package com.groupeisi.service;

import com.groupeisi.entity.Etudiant;
import com.groupeisi.repository.EtudiantRepository;
import org.springframework.stereotype.Service;
import com.groupeisi.service.EtudiantService;

import java.util.List;

public interface EtudiantServiceImpl implements EtudiantService {

    private final EtudiantRepository etudiantRepository;

    public EtudiantServiceImpl(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public Etudiant creer(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> lire() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant modifier(int id, Etudiant etudiant) {
        return etudiantRepository
            .findById(id)
            .map(e -> {
                e.setPrenom(etudiant.getPrenom());
                e.setNom(etudiant.getNom());
                return etudiantRepository.save(e);
            })
            .orElseThrow(() -> new RuntimeException("Etudiant non trouve !"));
    }

    @Override
    public String supprimer(int id) {
        etudiantRepository.deleteById(id);
        return "Etudiant supprime avec succes !";
    }
}
