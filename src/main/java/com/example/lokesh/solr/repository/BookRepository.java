package com.example.lokesh.solr.repository;

import com.example.lokesh.solr.core.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;


import java.util.List;

public interface BookRepository extends SolrCrudRepository<Book, String> {

    public List<Book> findByName(String name);

    @Query("id:*?0* OR name:*?0*")
    public Page<Book> findByCustomQuery(String searchTerm, Pageable pageable);

}
