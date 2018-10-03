package com.stackroute.keepnote.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/*
 * The class "Note" will be acting as the data model for the note Table in the database. Please
 * note that this class is annotated with @Entity annotation. Hibernate will scan all package for 
 * any Java objects annotated with the @Entity annotation. If it finds any, then it will begin the 
 * process of looking through that particular Java object to recreate it as a table in your database.
 */

@Entity
@Table(name = "NOTE")
public class Note {
	@Id
	private int noteId;

	private String noteTitle;
	private String noteContent;
	private String noteStatus;
	private LocalDateTime localDate;

	public Note() {
		this.localDate=LocalDateTime.now();

	}

	public Note(int i, String string, String string2, String string3, LocalDateTime localDate) {
		this.noteId=i;
		this.noteTitle=string;
		this.noteContent=string2;
		this.noteStatus=string3;
		this.localDate=localDate;
	}

	public int getNoteId() {

		return noteId;
	}

	public String getNoteTitle() {

		return noteTitle;
	}

	public String getNoteContent() {

		return noteContent;
	}

	public String getNoteStatus() {

		return noteStatus;
	}

	public void setNoteId(int parseInt) {
		this.noteId=parseInt;

	}

	public void setNoteTitle(String parameter) {
		this.noteTitle=parameter;

	}

	public void setNoteContent(String parameter) {
		this.noteContent=parameter;

	}

	public void setNoteStatus(String parameter) {
		this.noteStatus=parameter;

	}

	public void setCreatedAt(LocalDateTime now) {
		this.localDate=now;

	}
	public LocalDateTime getDate()
	{
		return localDate;
	}
	@Override
	public String toString() {
		return "Note[id=" + noteId + ", title=" + noteTitle + ", Content="
				+ noteContent + ", status=" + noteStatus + ", date and time=" + localDate + "]";
	}

}
