package com.hilaltasolar.service;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hilaltasolar.dao.NoteDAO;
import com.hilaltasolar.dto.UserLoginDTO;
import com.hilaltasolar.entity.Note;
import com.hilaltasolar.entity.User;
import com.hilaltasolar.security.LoginFilter;

@Service
@Transactional
public class NoteService {
	
	@Autowired
	private UserService UserService;
	@Autowired
	private NoteDAO noteDAO;

	public Long createNote(Note note,HttpServletRequest request) {
		note.setUser_id(LoginFilter.user.getId());
		note.setCreate_date(new Date(System.currentTimeMillis()));
		return noteDAO.Ýnsert(note);
	}
	public Long deleteNote(Note note,HttpServletRequest request) {
		noteDAO.delete(note);
		return 1l;
	}
	public Note getNoteFindById(Long id) {
		return noteDAO.getFindId(id);
	}
	public ArrayList<Note> getAll(){
			return noteDAO.getAll();
	}
	public ArrayList<Note>getAll(Long userId){
			return noteDAO.getAll(userId);
	}
	public void updateNote(Note oldNote, HttpServletRequest request) {
			noteDAO.update(oldNote);
		
	}
	public ArrayList<Note> getAll(UserLoginDTO login){
		User userm=new User();
		userm.setUsername(login.getUsername());
		userm.setPassword(login.getPassword());
		User user=UserService.getFindByUsernameAndPass(userm);
		
		return noteDAO.getAll(user.getId());
}
	
}
