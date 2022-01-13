package com.study.projects.clientsync.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Bookmark {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
String name;
String url;
@ManyToOne
public User usuario;


public User getUser() {
	return usuario;
}
public void setUser(User usuario) {
	this.usuario= usuario;
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}


}