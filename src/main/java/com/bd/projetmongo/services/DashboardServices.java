package com.bd.projetmongo.services;

import com.bd.projetmongo.model.persistance.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

@EnableMongoRepositories(basePackageClasses = DataRepository.class)
@Component
public class DashboardServices {

    @Autowired
    DataRepository dataRepository;

    /**
     * Orange data
     */

    public int getOrangeCount(){
        return dataRepository.countByOperateur("Orange France").size();
    }

    public int getOrange2GCount(){
        return dataRepository.countByOperateurAndReseau("Orange France", "2G").size();
    }

    public int getOrange3GCount(){
        return dataRepository.countByOperateurAndReseau("Orange France", "3G").size();
    }

    public int getOrange4GCount(){
        return dataRepository.countByOperateurAndReseau("Orange France", "4G").size();
    }

    /**
     * SFR data
     */

    public int getSFRCount(){
        return dataRepository.countByOperateur("SFR").size();
    }

    public int getSFR2GCount(){
        return dataRepository.countByOperateurAndReseau("SFR", "2G").size();
    }

    public int getSFR3GCount(){
        return dataRepository.countByOperateurAndReseau("SFR", "3G").size();
    }

    public int getSFR4GCount(){
        return dataRepository.countByOperateurAndReseau("SFR", "4G").size();
    }

    /**
     * Bouygues data
     */

    public int getBouyguesCount(){
        return dataRepository.countByOperateur("Bouygues Telecom").size();
    }

    public int getBouygues2GCount(){
        return dataRepository.countByOperateurAndReseau("Bouygues Telecom", "2G").size();
    }

    public int getBouygues3GCount(){
        return dataRepository.countByOperateurAndReseau("Bouygues Telecom", "3G").size();
    }

    public int getBouygues4GCount(){
        return dataRepository.countByOperateurAndReseau("Bouygues Telecom", "4G").size();
    }

    /**
     * Free data
     */

    public int getFreeCount(){
        return dataRepository.countByOperateur("Free").size();
    }

    public int getFree2GCount(){
        return dataRepository.countByOperateurAndReseau("Free", "2G").size();
    }

    public int getFree3GCount(){
        return dataRepository.countByOperateurAndReseau("Free", "3G").size();
    }

    public int getFree4GCount(){
        return dataRepository.countByOperateurAndReseau("Free", "4G").size();
    }
}
