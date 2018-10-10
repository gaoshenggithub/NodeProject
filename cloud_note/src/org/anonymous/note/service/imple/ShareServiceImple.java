package org.anonymous.note.service.imple;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.anonymous.note.dao.NoteDao;
import org.anonymous.note.dao.ShareDao;
import org.anonymous.note.entiry.Note;
import org.anonymous.note.entiry.NoteResult;
import org.anonymous.note.entiry.Share;
import org.anonymous.note.service.ShareService;
import org.anonymous.note.util.NoteUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShareServiceImple implements ShareService{
	@Resource
	private NoteDao noteDao;
	@Resource
	private ShareDao shareDao;
	@Override
	public NoteResult share(String noteId) {
		NoteResult result = new NoteResult();
		//该内容已经分享处理
		Share findShareNoteId = shareDao.findShareNoteId(noteId);
		if(findShareNoteId != null){
			result.setStatus(1);
			result.setMsg("已经分享过了");
			return result;
		}
		//该内容为分享处理
		Share share = new Share();
		Note note = noteDao.findNoteId(noteId);
		String share_Id = NoteUtil.create_UserId();
		share.setCn_note_id(note.getCn_note_id());
		share.setCn_share_body(note.getCn_note_body());
		share.setCn_share_id(share_Id);
		share.setCn_share_title(note.getCn_note_title());
		shareDao.save(share);
		result.setStatus(0);
		result.setMsg("分享成功");
		return result;
	}
	@Override
	public NoteResult shareLikeTitle(String keyNote) {
		
		if(keyNote != null && 
				!"".equals(keyNote)){
			keyNote = "%" + keyNote + "%";
		}else{
			keyNote = "%";
		}
		NoteResult result = new NoteResult();
		List<Map> list = shareDao.findLikeTitle(keyNote);
		result.setStatus(0);
		result.setMsg("数据查询成功");
		result.setData(list);
		return result;
	}
	@Override
	public NoteResult shareShow(String shareId) {
		 Share share 
		 		= shareDao.findId(shareId);
		 NoteResult result = new NoteResult();
		 result.setStatus(0);
		 result.setData(share);
		 result.setMsg("操作成功");
		return result;
	}
}
