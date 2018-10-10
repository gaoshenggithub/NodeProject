package org.anonymous.note.service.imple;

import java.util.List;

import javax.annotation.Resource;

import org.anonymous.note.dao.NoteDao;
import org.anonymous.note.entiry.ActivityNote;
import org.anonymous.note.entiry.NoteResult;
import org.anonymous.note.service.ActionNoteService;
import org.springframework.stereotype.Service;

@Service
public class ActionNoteServiceImple implements ActionNoteService {

	@Resource
	private NoteDao noteDao;
	@Override
	public NoteResult actionNote() {
		NoteResult result = new NoteResult();
		List<ActivityNote> list = noteDao.selectActionNote();
		result.setStatus(0);
		result.setMsg("操作成功!");
		result.setData(list);
		return result;
	}

}
