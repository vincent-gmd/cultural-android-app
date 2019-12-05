package com.example.culturaladriodapp.model.dto.api;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@DatabaseTable
public class Group implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@DatabaseField(id = true)
	private Integer id;

	@DatabaseField
	private String name;

	//@ForeignCollectionField(eager = true,  maxEagerLevel = 2)
	private List<Experience> experiences;

	@DatabaseField
	private Date creationDate;

	//@ForeignCollectionField(eager = true,  maxEagerLevel = 2)
	private List<Artist> artists;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<Artist> getArtists() {
		return artists;
	}

	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

}
