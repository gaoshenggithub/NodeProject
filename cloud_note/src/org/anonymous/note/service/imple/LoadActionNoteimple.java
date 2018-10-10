package org.anonymous.note.service.imple;

import java.util.List;

import javax.annotation.Resource;

import org.anonymous.note.dao.ActivityDao;
import org.anonymous.note.entiry.Activity;
import org.anonymous.note.entiry.NoteResult;
import org.anonymous.note.service.ActivityService;
import org.springframework.stereotype.Service;

@Service
public class LoadActionNoteimple implements ActivityService{
	@Resource
	private ActivityDao activityDao;
	@Override
	public NoteResult actionNote() {
		NoteResult result = new NoteResult();
		List<Activity> list = activityDao.findAction();
		result.setStatus(0);
		result.setMsg("操作成功!");
		result.setData(list);
		return result;
	}

}
