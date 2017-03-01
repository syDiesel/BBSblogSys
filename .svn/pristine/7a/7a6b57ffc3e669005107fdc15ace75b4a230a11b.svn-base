package com.bbsBlog.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the AttachStatus database table.
 * 
 */
@Entity
@NamedQuery(name="AttachStatus.findAll", query="SELECT a FROM AttachStatus a")
public class AttachStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="attach_status")
	private String attachStatus;

	//bi-directional many-to-one association to Attachment
	@OneToMany(mappedBy="attachStatus")
	private List<Attachment> attachments;

	public AttachStatus() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAttachStatus() {
		return this.attachStatus;
	}

	public void setAttachStatus(String attachStatus) {
		this.attachStatus = attachStatus;
	}

	public List<Attachment> getAttachments() {
		return this.attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public Attachment addAttachment(Attachment attachment) {
		getAttachments().add(attachment);
		attachment.setAttachStatus(this);

		return attachment;
	}

	public Attachment removeAttachment(Attachment attachment) {
		getAttachments().remove(attachment);
		attachment.setAttachStatus(null);

		return attachment;
	}

}