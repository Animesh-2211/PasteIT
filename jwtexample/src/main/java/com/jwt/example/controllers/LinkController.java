package com.jwt.example.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.example.entities.Link;
import com.jwt.example.entities.User;
import com.jwt.example.services.LinkService;
import com.jwt.example.services.UserService;

@RestController
@RequestMapping("/api/links")
public class LinkController {

    private final LinkService linkService;
    private final UserService userService;

    public LinkController(LinkService linkService, UserService userService) {
        this.linkService = linkService;
        this.userService = userService;
    }

    @GetMapping("/{email}")
    public ResponseEntity<List<Link>> getLinkByUser(@PathVariable String email) {
        Optional<User> userOptional = userService.getUserByEmail(email);
        if (userOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        User user = userOptional.get();
        List<Link> links = linkService.getLinksByUser(user);
        return ResponseEntity.ok(links);
    }

    @PostMapping("/{email}")
    public ResponseEntity<Link> saveLink(@PathVariable String email, @RequestBody Link link) {
        Optional<User> userOptional = userService.getUserByEmail(email);
        if (userOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        User user = userOptional.get();
        link.setUser(user);
        Link savedLink = linkService.saveLink(link);
        return ResponseEntity.ok(savedLink);
    }

    @DeleteMapping("delete/{name}")
    public ResponseEntity<Void> deleteLink(@PathVariable String name) {
        linkService.deleteLinkByName(name);
        return ResponseEntity.noContent().build();
    }
}
