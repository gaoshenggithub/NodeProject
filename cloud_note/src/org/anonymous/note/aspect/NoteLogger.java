package org.anonymous.note.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NoteLogger {
	@After("within(org.anonymous.note.controller..*)")
	public void alogger(){
		System.out.println("进入到Controller");
	}
}
