package org.anonymous.note.service.imple;


import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.anonymous.note.dao.NoteDao;
import org.anonymous.note.entiry.Note;
import org.anonymous.note.entiry.NoteResult;
import org.anonymous.note.service.NoteService;
import org.anonymous.note.util.NoteUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NoteServiceImple implements NoteService {
	@Resource
	private NoteDao noteDao;
	@Override
	public NoteResult loadNotes(String noteId) {
		List<Map> list = noteDao.findByBookId(noteId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("操作成功");
		result.setData(list);
		return result;
	}
	@Override
	public NoteResult addNotes(String noteTitle,
							   String bookId,
							   String userId) {
		Note note = new Note();
		NoteResult result = new NoteResult();
		String cn_note_id = NoteUtil.create_UserId();
		note.setCn_note_id(cn_note_id);
		note.setCn_notebook_id(bookId);
		note.setCn_user_id(userId);
		note.setCn_note_status_id("1");
		note.setCn_note_type_id("1");
		note.setCn_note_title(noteTitle);
		note.setCn_note_body("");
		long cn_note_create_time = System.currentTimeMillis();
		note.setCn_note_create_time(cn_note_create_time);
		noteDao.save(note);
		result.setStatus(0);
		result.setMsg("创建成功");
		result.setData(cn_note_id);
		return result;
	}
	@Override
	public NoteResult findNote(String noteId) {
		NoteResult result = new NoteResult();
		 Note list = noteDao.findNoteId(noteId);
		if(list==null){
			result.setStatus(1);
			result.setMsg("查询失败");
		}
		result.setStatus(0);
		result.setData(list);
		result.setMsg("查询成功");
		return result;
	}
	@Override
	public NoteResult updateNotes(String noteTitle,
			String noteId,String noteBody) {
		Note note = new Note();
		NoteResult result = new NoteResult();
		note.setCn_note_id(noteId);
		note.setCn_note_title(noteTitle);
		note.setCn_note_body(noteBody);
		long times  = System.currentTimeMillis();
		note.setCn_note_last_modify_time(times);
		noteDao.update(note);
			result.setStatus(0);
			result.setMsg("保存成功");
			return result;
	}
	@Override
	public NoteResult recycleNote(String noteId) {
		noteDao.updateStatus(noteId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("删除笔记成功");
		return result;
	}
	@Override
	public NoteResult findRecycleNote(String userId) {
		List<Note> list = noteDao.findRecycleId(userId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setData(list);
		result.setMsg("查询成功");
		return result;
	}
	@Override
	public NoteResult recycleNoteId(String noteId, String bookNoteId) {
		NoteResult result = new NoteResult();
		Note note = new Note();
		note.setCn_note_id(noteId);
		note.setCn_notebook_id(bookNoteId);
		noteDao.replayNote(note);
		result.setStatus(0);
		result.setMsg("操作成功!");
		return result;
	}
	@Override
	
	public NoteResult search(String title, 
							 String status, 
							 String beginTime,
							 String endTime) {
		Map<String,Object> map = new HashMap<String,Object>();
		NoteResult result = new NoteResult();
		//对传入的值进行校验
		if(title!=null && !"".equals(title)){
			title = "%"+title+"%";
			map.put("title", title);
		}
		if(status!=null && !"0".equals(status)){
			map.put("status", status);
		}
		if(beginTime!=null &&!"".equals(beginTime)){
			Date bTime = Date.valueOf(beginTime);
			map.put("beginTime", bTime.getTime());
		}
		if(endTime!=null && !"".equals(endTime)){
			Date eTime = Date.valueOf(endTime);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(eTime);
			calendar.add(Calendar.DATE,1);
			map.put("endTime", calendar.getTimeInMillis());
		}
		List<Note> list = noteDao.hightSearch(map);
		result.setStatus(0);
		result.setMsg("查询成功!"+list.size());
		result.setData(list);
		return result;
		
	}
	@Override
	public NoteResult move(String noteId, String noteBookId) {
		Note note = new Note();
		note.setCn_note_id(noteId);
		note.setCn_notebook_id(noteBookId);
		noteDao.moveNote(note);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("操作成功!");
		return result;
	}
	@Override
	public NoteResult delete(String userId) {
		noteDao.deleteNote(userId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("操作成功!");
		return result;
	}

}
