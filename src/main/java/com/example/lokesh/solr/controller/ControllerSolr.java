package com.example.lokesh.solr.controller;

import com.example.lokesh.solr.query.SearchIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerSolr {

    @Autowired
    SearchIndex searchIndex;

    @RequestMapping("/solrsearch")
    public String solrSearch() {

        searchIndex.search();

        return "Lokesh Solr";
    }
}
