package com.example.culturaladriodapp.model.dto.api;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.List;

@DatabaseTable
public class LegalEntity extends Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@DatabaseField
	private String register;

	@DatabaseField
	private String companyName;

	//@ForeignCollectionField(eager = true,  maxEagerLevel = 2)
	private List<CulturalArtifact> culturalArtifacts;
	

	public LegalEntity( String register, String companyName, List<CulturalArtifact> culturalArtifacts) {
		super();
		this.register = register;
		this.companyName = companyName;
		this.culturalArtifacts = culturalArtifacts;
	}
	
	
	public LegalEntity() {
		super();
	}


	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
