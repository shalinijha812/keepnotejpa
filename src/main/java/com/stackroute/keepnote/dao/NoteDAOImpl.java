package com.stackroute.keepnote.dao;

import java.util.List;
import org.springframework.context.annotation.Bean;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.stackroute.keepnote.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/*
 * This class is implementing the NoteDAO interface. This class has to be annotated with @Repository
 * annotation.
 * @Repository - is an annotation that marks the specific class as a Data Access Object, thus 
 * 				 clarifying it's role.
 * @Transactional - The transactional annotation itself defines the scope of a single database 
 * 					transaction. The database transaction happens inside the scope of a persistence 
 * 					context.  
 * */
@Repository("NoteDAO")
@Transactional
public class NoteDAOImpl implements NoteDAO {

	/*
	 * Autowiring should be implemented for the SessionFactory.
	 */
	@Autowired
	public SessionFactory sessionFactory;


//	Session sessionOne = HibernateUtil.getSessionFactory().openSession();
//      sessionOne.beginTransaction();

	public NoteDAOImpl(SessionFactory sessionFactory) {
	this.sessionFactory=sessionFactory;

	}

	/*
	 * Save the note in the database(note) table.
	 */

	public boolean saveNote(Note note) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(note);
		System.out.println(note);
		session.flush();
		return true;

	}

	/*
	 * Remove the note from the database(note) table.
	 */

	public boolean deleteNote(int noteId) {
		Session session=sessionFactory.getCurrentSession();
		Note note = getNoteById(noteId);
		session.delete(note);
		session.flush();
		return true;
	}

	/*
	 * retrieve all existing notes sorted by created Date in descending
	 * order(showing latest note first)
	 */
	public List<Note> getAllNotes() {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Note.class);
		return(List<Note>) criteria.list();

	}

	/*
	 * retrieve specific note from the database(note) table
	 */
	public Note getNoteById(int noteId) {
		Session session=sessionFactory.getCurrentSession();
		Note note1=session.get(Note.class,noteId);
		session.flush();
		return note1;
	}

	/* Update existing note */

	public boolean UpdateNote(Note note) {
		Note note1=getNoteById(note.getNoteId());
		if(note1!=null) {
			note1.setNoteId(note.getNoteId());
			note1.setNoteContent(note.getNoteContent());
			note1.setNoteStatus(note.getNoteStatus());
			note1.setNoteTitle(note.getNoteTitle());
			note1.setCreatedAt(note.getDate());
			return true;
		}
		return false;

	}

}
