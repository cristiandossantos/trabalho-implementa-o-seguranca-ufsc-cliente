package com.study.projects.clientsync.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.study.projects.clientsync.models.Bookmark;
import com.study.projects.clientsync.models.User;
import com.study.projects.clientsync.repository.BookmarkRepository;
import com.study.projects.clientsync.repository.UserRepository;



@Controller
public class UserController {
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private BookmarkRepository bm;
	
@RequestMapping(value="/cadastrarUsuario", method=RequestMethod.GET)	
public String form() {
	return "usuario/formUsuario";
}

@RequestMapping(value="/cadastrarUsuario", method=RequestMethod.POST)	
public String form(User usuario) {
	ur.save(usuario);
	return "redirect:/cadastrarUsuario";
}

@RequestMapping("usuarios")
public ModelAndView listaUsuarios() {
	ModelAndView mv = new ModelAndView("index");
	Iterable<User> usuarios = ur.findAll();
	mv.addObject("usuarios", usuarios);
	return mv;
}

@RequestMapping(value="/{id}", method=RequestMethod.GET)
public ModelAndView detalhesUsuario(@PathVariable("id")int id) {
	User usuario = ur.findById(id);
	ModelAndView mv = new ModelAndView("usuario/detalhesUsuario");
	mv.addObject("usuario", usuario);
	Iterable<Bookmark> bookmarks = bm.findByUsuario(usuario);
	mv.addObject("bookmarks", bookmarks);
	return mv;
}
@RequestMapping(value="/{id}", method=RequestMethod.POST)
public String detalhesUsuariosPost(@PathVariable("id")int id, Bookmark bookmark) {
	User usuario = ur.findById(id);
	bookmark.setUser(usuario);
	bm.save(bookmark);
	return "redirect:/{id}";
}

@RequestMapping("/deletarUsuario")
public String deletarUsuario(int id){
	User usuario = ur.findById(id);
	ur.delete(usuario);
	return "redirect:/usuarios";
}
@RequestMapping("/deletarBookmark")
	public String deletarBookmark(int id){
	Bookmark bookmark = bm.findById(id);
	bm.delete(bookmark);
	User usuario = bookmark.getUser();
	int idInt = usuario.getId();
	String idx =""+idInt;
	return "redirect:/" + idx;
}
}
