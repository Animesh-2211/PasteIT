package com.jwt.example.services;

import java.util.List;

import com.jwt.example.entities.Link;
import com.jwt.example.entities.User;

public interface LinkService {

    List<Link> getLinksByUser(User user);

    Link saveLink(Link link);

    void deleteLinkByName(String name); // Add this method

}
