package com.example.apiLoja.api.controller;

import com.example.apiLoja.api.model.Tags;
import com.example.apiLoja.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tags")
public class TagsController {
    private final TagsService tagsService;

    @Autowired
    public TagsController(TagsService tagsService) {
        this.tagsService = tagsService;
    }

    @PostMapping("/create")
    public Tags createTags(@RequestBody Tags tags) {
        return tagsService.saveTags(tags);
    }
}
