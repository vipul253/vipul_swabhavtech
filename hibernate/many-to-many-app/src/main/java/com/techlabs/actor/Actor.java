package com.techlabs.actor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ACTORS")
public class Actor {
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)", name = "ACTOR_ID", unique = true)
	private UUID id;	
	private String name;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
		name = "ACTORS_MOVIES", 
		joinColumns = { @JoinColumn(name = "ACTOR_ID") }, 
		inverseJoinColumns = { @JoinColumn(name = "MOVIE_ID") }
	)
	private Set<Movie> movies;
	
	public Actor(){
		movies = new HashSet<Movie>();
	}
	
	public void addMovie(Movie m){
		movies.add(m);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}

	public UUID getId() {
		return id;
	}
}
