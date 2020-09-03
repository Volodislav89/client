package com.spring_cloud.client.controller;

import com.spring_cloud.client.model.Cat;
import com.spring_cloud.client.repository.CatRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/cat/cloud")
public class Controller {
    CatRepository catRepository;

    public Controller(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @Value("${welcome.message}")
    String s;

    @GetMapping
    public String getValue() {
        return s;
    }

    @GetMapping("/all")
    public List<Cat> catList() {
        return catRepository.findAll();
    }
}
