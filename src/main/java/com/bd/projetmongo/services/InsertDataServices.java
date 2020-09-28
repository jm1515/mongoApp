package com.bd.projetmongo.services;

import com.bd.projetmongo.model.entities.Data;
import com.bd.projetmongo.model.entities.Fields;
import com.bd.projetmongo.model.entities.Geometry;
import com.bd.projetmongo.model.persistance.DataRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import java.util.Random;

@EnableMongoRepositories(basePackageClasses = DataRepository.class)
@Component
public class InsertDataServices {

    @Autowired
    DataRepository dataRepository;

    /**
     * insert une nouvelle donnée dans la BD
     * @param newRecord l'enregistrement à rajouter
     * @return true si l'enregistrement s'est bien passé, false si il y a une erreur
     */
    public boolean insertRecord(Fields newRecord){
        if(newRecord.getReseau().equals("") || newRecord.getOperateur().equals("") || newRecord.getCodeDepartement().equals("")
                || newRecord.getcode_insee().equals("")){
            return false;
        }
        else{
            Fields f = new Fields(newRecord.getCodePostal(), newRecord.getcode_insee(), newRecord.getNomCommune(),
                    newRecord.getCodeDepartement(), newRecord.getSurfaceCommune(), newRecord.getPopulationCommune(), newRecord.getReseau(), newRecord.getOperateur(), newRecord.getTypeCouverture(),
                    newRecord.getCouverture(),newRecord.getOperateur()+" couverture surfacique "+newRecord.getReseau(),
                    "surfacique " + newRecord.getReseau());
            System.out.println(f.toString());
            Data d = new Data(new ObjectId(), this.getRandomHexString(30), f, new Geometry());
            System.out.println(d.toString());
            dataRepository.save(d);

            return true;
        }
    }

    private String getRandomHexString(int numchars){
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while(sb.length() < numchars){
            sb.append(Integer.toHexString(r.nextInt()));
        }

        return sb.toString().substring(0, numchars);
    }
}
