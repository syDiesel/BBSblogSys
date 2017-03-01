package com.bbsBlog.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the FilterWords database table.
 * 
 */
@Entity
@Table(name="FilterWords")
@NamedQuery(name="FilterWord.findAll", query="SELECT f FROM FilterWord f")
public class FilterWord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String find;

	private String replacement;

	public FilterWord() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFind() {
		return this.find;
	}

	public void setFind(String find) {
		this.find = find;
	}

	public String getReplacement() {
		return this.replacement;
	}

	public void setReplacement(String replacement) {
		this.replacement = replacement;
	}

}