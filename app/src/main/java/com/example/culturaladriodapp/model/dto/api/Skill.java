package com.example.culturaladriodapp.model.dto.api;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.List;

@DatabaseTable
public class Skill implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@DatabaseField(id = true)
	private Integer id;

	@DatabaseField
	private String name;

	@DatabaseField
	private String status;

	@DatabaseField
	private String description;

	@DatabaseField
	private String includesDate;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIncludesDate() {
		return includesDate;
	}

	public void setIncludesDate(String includesDate) {
		this.includesDate = includesDate;
	}
	
	
}
