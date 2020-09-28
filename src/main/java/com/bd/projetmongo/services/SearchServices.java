package com.bd.projetmongo.services;

import com.bd.projetmongo.model.entities.Data;
import com.bd.projetmongo.model.entities.Fields;
import com.bd.projetmongo.model.entities.SearchCriteria;
import com.bd.projetmongo.model.persistance.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.bd.projetmongo.services.AllDataServices.RECORDS_PER_PAGE;

@EnableMongoRepositories(basePackageClasses = DataRepository.class)
@Component
public class SearchServices {

    @Autowired
    DataRepository dataRepository;

    private List<Fields> result = new ArrayList<>();

    /**
     * Rechercher un element dans la base
     * @param searchCriteria les criètres de recherche
     */
    public List<Fields> getSearchResults(SearchCriteria searchCriteria){
        List<Data> dataFields = dataRepository.findByCriteria(searchCriteria.getOperateur(),
                searchCriteria.getReseau(), searchCriteria.getCodePostal(), searchCriteria.getCodeDepartement(),
                searchCriteria.getNomCommune());
        for(Data d : dataFields){
            result.add(new Fields(d.getFields().getCodePostal(), d.getFields().getcode_insee(), d.getFields().getNomCommune(),
                    d.getFields().getCodeDepartement(), d.getFields().getSurfaceCommune(), d.getFields().getPopulationCommune(),
                    d.getFields().getReseau(), d.getFields().getOperateur(), d.getFields().getTypeCouverture(),
                    d.getFields().getCouverture()));

        }
        return this.result;
    }

    public List<Fields> getSearchResults(){
        return this.result;
    }

    public int getPages(){
        return (result.size()/RECORDS_PER_PAGE)+1;
    }
}
