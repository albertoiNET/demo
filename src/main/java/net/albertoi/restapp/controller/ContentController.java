package net.albertoi.restapp.controller;

import net.albertoi.restapp.model.Content;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ContentController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/content")
    public Content content(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Content(counter.incrementAndGet(), String.format(template, name));
    }
}
