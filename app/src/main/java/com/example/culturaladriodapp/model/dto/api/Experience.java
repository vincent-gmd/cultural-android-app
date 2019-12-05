package com.example.culturaladriodapp.model.dto.api;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Date;

@DatabaseTable
public class Experience implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@DatabaseField(id = true)
	private Integer id;

	@DatabaseField
	private Integer groupId;

	@DatabaseField
	private Integer artistHasSkillId;

	@DatabaseField
	private String description;

	@DatabaseField
	private Date initialDate;

	@DatabaseField
	private Date finalDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getArtistHasSkillId() {
		return artistHasSkillId;
	}

	public void setArtistHasSkillId(Integer artistHasSkillId) {
		this.artistHasSkillId = artistHasSkillId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}

	public Date getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	
}
