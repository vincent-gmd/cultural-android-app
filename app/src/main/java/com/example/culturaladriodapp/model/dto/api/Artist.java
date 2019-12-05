package com.example.culturaladriodapp.model.dto.api;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@DatabaseTable
public class Artist extends Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@DatabaseField
	private String individualRegistration;

	@DatabaseField
	private String name;

	@DatabaseField
	private String lastName;

	//@ForeignCollectionField(eager = true,  maxEagerLevel = 2)
	private List<Group> groups;

	//@ForeignCollectionField(eager = true,  maxEagerLevel = 2)
	private List<CulturalArtifact> culturalArtifacts;

	//@ForeignCollectionField(eager = true,  maxEagerLevel = 2)
	private List<Skill> skills;

	//@ForeignCollectionField(eager = true,  maxEagerLevel = 2)
	private List<Artist> artists;

	@DatabaseField
	private String status;
	

	
	public Artist(String userName, String email, String password, String individualRegistration, String name,
			String lastName, List<Group> groups, List<CulturalArtifact> culturalArtifacts, List<Skill> skills, List<Artist> artists,  String status) {

		super(null, userName, email, password);
		this.individualRegistration = individualRegistration;
		this.name = name;
		this.lastName = lastName;
		this.groups = groups;
		this.culturalArtifacts = culturalArtifacts;
		this.skills = skills;
		this.artists = artists;
		this.status = status;
	}

	public Artist() {
		super();
	}

	public String getIndividualRegistration() {
		return individualRegistration;
	}

	public void setIndividualRegistration(String individualRegistration) {
		this.individualRegistration = individualRegistration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Group> getGroups() {
		if (groups == null) {
			groups = new ArrayList<Group>();
		}
		return groups;
	}

	public void setGroups(List<Group> groups) {

		this.groups = groups;
	}

	public List<CulturalArtifact> getCulturalArtifacts() {
		return culturalArtifacts;
	}

	public void setCulturalArtifacts(List<CulturalArtifact> culturalArtifacts) {
		this.culturalArtifacts = culturalArtifacts;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public List<Artist> getArtists() {
		return artists;
	}

	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
