package com.jwt.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jwt.example.entities.Link;
import com.jwt.example.entities.User;
import com.jwt.example.repository.LinkRepository;

@Service
public class LinkServiceImpl implements LinkService {

    private final LinkRepository linkRepository;

    public LinkServiceImpl(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public List<Link> getLinksByUser(User user) {
        return linkRepository.findByUser(user);
    }

    @Override
    public Link saveLink(Link link) {
        return linkRepository.save(link);
    }

    @Override
    public void deleteLinkByName(String name) {
        linkRepository.deleteLinkByName(name);
    }
}
