package com.bd.projetmongo.controllers;

import com.bd.projetmongo.model.entities.Fields;
import com.bd.projetmongo.model.entities.SearchCriteria;
import com.bd.projetmongo.services.AllDataServices;
import com.bd.projetmongo.services.DashboardServices;
import com.bd.projetmongo.services.InsertDataServices;
import com.bd.projetmongo.services.SearchServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static com.bd.projetmongo.services.AllDataServices.RECORDS_PER_PAGE;

@Controller
public class MainController {

    @Autowired
    private DashboardServices dashboardServices;
    @Autowired
    private AllDataServices allDataServices;
    @Autowired
    private SearchServices searchServices;
    @Autowired
    private InsertDataServices insertDataServices;

    @GetMapping("/")
    public void greeting(HttpServletResponse response) {
        try {
            response.sendRedirect("/dashboard");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("OrangeCount", dashboardServices.getOrangeCount());
        model.addAttribute("SFRCount", dashboardServices.getSFRCount());
        model.addAttribute("BouyguesCount", dashboardServices.getBouyguesCount());
        model.addAttribute("FreeCount", dashboardServices.getFreeCount());
        model.addAttribute("Orange2GCount", dashboardServices.getOrange2GCount());
        model.addAttribute("Orange3GCount", dashboardServices.getOrange3GCount());
        model.addAttribute("Orange4GCount", dashboardServices.getOrange4GCount());
        model.addAttribute("SFR2GCount", dashboardServices.getSFR2GCount());
        model.addAttribute("SFR3GCount", dashboardServices.getSFR3GCount());
        model.addAttribute("SFR4GCount", dashboardServices.getSFR4GCount());
        model.addAttribute("Bouygues2GCount", dashboardServices.getBouygues2GCount());
        model.addAttribute("Bouygues3GCount", dashboardServices.getBouygues3GCount());
        model.addAttribute("Bouygues4GCount", dashboardServices.getBouygues4GCount());
        model.addAttribute("Free2GCount", dashboardServices.getFree2GCount());
        model.addAttribute("Free3GCount", dashboardServices.getFree3GCount());
        model.addAttribute("Free4GCount", dashboardServices.getFree4GCount());
        return "index";
    }

    @GetMapping("/insert")
    public String insert(@ModelAttribute Fields fields, Model model) {
        System.out.println(fields.toString());
        if (fields.getNomCommune() == null){
            model.addAttribute("noinsert", true);
        }else {
            model.addAttribute("noinsert", false);
            model.addAttribute("return", insertDataServices.insertRecord(fields));
        }
        return "insert";
    }

    @GetMapping("/search")
    public String searchPage(@RequestParam("page") Optional<Integer> page, @ModelAttribute SearchCriteria searchCriteria, Model model) {
        System.out.println("Test");
        System.out.println(searchCriteria.toString());
        searchServices.getSearchResults(searchCriteria);
        int currentPage = page.orElse(1);
        try {
            model.addAttribute("fields", searchServices.getSearchResults().subList((currentPage - 1) * RECORDS_PER_PAGE, currentPage * RECORDS_PER_PAGE));
        }catch (IndexOutOfBoundsException e){
            model.addAttribute("fields", searchServices.getSearchResults().subList((currentPage - 1) * RECORDS_PER_PAGE, searchServices.getSearchResults().size()));
        }
        model.addAttribute("iteration", (currentPage-1)* RECORDS_PER_PAGE);
        model.addAttribute("pages", searchServices.getPages());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("size", searchServices.getSearchResults().size());
        return "search";
    }

    @GetMapping("/all-data")
    public String all(@RequestParam("page") Optional<Integer> page, Model model) {
        int currentPage = page.orElse(1);
        if (currentPage <= 0){
            currentPage = 1;
        }
        if(allDataServices.getPages() == 0){
            allDataServices.getData();
        }
        if (currentPage > allDataServices.getPages()){
            currentPage = allDataServices.getPages();
        }
        try {
            model.addAttribute("fields", allDataServices.getData().subList((currentPage - 1) * RECORDS_PER_PAGE, currentPage *  RECORDS_PER_PAGE));
        }catch (IndexOutOfBoundsException e){
            model.addAttribute("fields", allDataServices.getData().subList((currentPage - 1) * RECORDS_PER_PAGE, allDataServices.getData().size()));
        }
        model.addAttribute("iteration", (currentPage-1)* RECORDS_PER_PAGE);
        model.addAttribute("pages", allDataServices.getPages());
        model.addAttribute("currentPage", currentPage);
        return "all-data";
    }
}
