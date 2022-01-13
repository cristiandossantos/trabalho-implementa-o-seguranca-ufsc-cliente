package com.study.projects.clientsync.repository;

import org.springframework.data.repository.CrudRepository;

import com.study.projects.clientsync.models.Bookmark;
import com.study.projects.clientsync.models.User;

public interface BookmarkRepository extends CrudRepository<Bookmark, String> {
Iterable <Bookmark> findByUsuario(User usuario);
Bookmark findById(int id);
}
