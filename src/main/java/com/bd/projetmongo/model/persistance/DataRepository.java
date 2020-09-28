package com.bd.projetmongo.model.persistance;

import com.bd.projetmongo.model.entities.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface DataRepository extends MongoRepository<Data, ObjectId>{

    @Query("{'fields.operateur' : ?0 }")
    List<Data> countByOperateur(String operateur);

    @Query("{'fields.operateur' : ?0, 'fields.reseau' : ?1}")
    List<Data> countByOperateurAndReseau(String operateur, String reseau);

    @Query("{'fields.operateur' : ?0, 'fields.reseau' : ?1, 'fields.code_postal' : ?2, 'fields.code_departement' : ?3, 'fields.nom_commune' : ?4 }")
    List<Data> findByCriteria(String operateur, String reseau, String code_postal,
                              String code_departement, String nom_commune);

}
