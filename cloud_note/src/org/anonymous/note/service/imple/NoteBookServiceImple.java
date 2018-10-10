package org.anonymous.note.service.imple;

import java.sql.Timestamp;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.anonymous.note.dao.NoteBookDao;
import org.anonymous.note.entiry.NoteBook;
import org.anonymous.note.entiry.NoteResult;
import org.anonymous.note.service.NoteBookService;
import org.anonymous.note.util.NoteUtil;
import org.springframework.stereotype.Service;

@Service
public class NoteBookServiceImple implements NoteBookService {
	@Resource
	private NoteBookDao noteBookDao;
	@Override
	public NoteResult loadBooks(String userId) {
		List<Map> list = noteBookDao.findByUser(userId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("查询成功");
		result.setData(list);
		return result;
	}
	@Override
	public NoteResult addBooks(String bookName, String userId) {
		NoteResult result = new NoteResult();
		NoteBook noteBook = new NoteBook();
		//
		String noteId = NoteUtil.create_UserId();
		//笔记ID
		noteBook.setCn_notebook_id(noteId);
		System.out.println("Service:"+bookName);
		
		//用户ID
		noteBook.setCn_user_id(userId);
		//笔记类型
		noteBook.setCn_notebook_type_id("5");//normal
		//笔记名称
		noteBook.setCn_notebook_name(bookName);
		//创建笔记时间
		Timestamp timesTamp = new Timestamp(System.currentTimeMillis());
		noteBook.setCn_notebook_createtime(timesTamp);
		noteBookDao.save(noteBook);
		String cn_notebook_name = noteBook.getCn_notebook_name();
		System.out.println("DAO:"+cn_notebook_name);
		result.setStatus(0);
		result.setMsg("创建成功!");
		result.setData(noteId);
		return result;
	}

}
