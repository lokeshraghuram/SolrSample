package com.example.lokesh.solr.query;

import com.example.lokesh.solr.core.Book;
import com.example.lokesh.solr.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SearchIndex {

    @Autowired
    BookRepository bookRepository;

    public void search() {
       /* Page<Book> result = bookRepository.findByCustomQuery("Phone", new PageRequest(0, 10));
        result.getTotalPages();*/

       Page<Book> page = (Page<Book>) bookRepository.findAll();
       Optional<Book> page1 = bookRepository.findById("0553573403");


        List<Book> books = bookRepository.findByName("A Game of Thrones");
        System.out.println("success");
    }


}
