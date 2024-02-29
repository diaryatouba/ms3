package com.groupeisi.service;

import com.groupeisi.entity.Etudiant;

import java.util.List;

public class EtudiantService {
    Etudiant creer(Etudiant etudiant);
    List<Etudiant> lire();
    Etudiant modifier(int id, Etudiant etudiant);
    String supprimer(int id);
}

}
