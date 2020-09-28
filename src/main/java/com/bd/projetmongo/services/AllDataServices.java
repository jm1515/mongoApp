package com.bd.projetmongo.services;

import com.bd.projetmongo.model.entities.Data;
import com.bd.projetmongo.model.entities.Fields;
import com.bd.projetmongo.model.persistance.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@EnableMongoRepositories(basePackageClasses = DataRepository.class)
@Component
public class AllDataServices {

    @Autowired
    DataRepository dataRepository;

    private List<Fields> result = new ArrayList<>();
    public static final int RECORDS_PER_PAGE = 10;
    private boolean fetched = false;

    /**
     * Récupérer les données en base
     */
    private void fetchData(){
        //TODO appel à persistance
        List<Data> listData = dataRepository.findAll(Sort.unsorted());
        for(Data d : listData){
            this.result.add(new Fields(d.getFields().getCodePostal(),
                    d.getFields().getcode_insee(),
                    d.getFields().getNomCommune(),
                    d.getFields().getCodeDepartement(),
                    d.getFields().getSurfaceCommune(),
                    d.getFields().getPopulationCommune(),
                    d.getFields().getReseau(),
                    d.getFields().getOperateur(),
                    d.getFields().getTypeCouverture(),
                    d.getFields().getCouverture()));
        }
    }

    public List<Fields> getData(){
        if (!fetched){
            fetchData();
            fetched = true;
        }
        return this.result;
    }

    public int getPages(){
        double rpp = (double) RECORDS_PER_PAGE;
        return (int) Math.ceil((result.size()/ rpp));
    }
}
