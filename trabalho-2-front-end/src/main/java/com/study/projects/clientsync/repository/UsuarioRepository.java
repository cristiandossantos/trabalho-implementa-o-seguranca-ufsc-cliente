package com.study.projects.clientsync.repository;

import org.springframework.data.repository.CrudRepository;

import com.study.projects.clientsync.models.Usuario;

import org.springframework.data.repository.CrudRepository;


public interface UsuarioRepository extends CrudRepository<Usuario, String>{

	Usuario findByLogin(String login);
}
