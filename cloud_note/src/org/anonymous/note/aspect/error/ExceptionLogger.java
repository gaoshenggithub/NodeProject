package org.anonymous.note.aspect.error;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.junit.After;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionLogger {
		@AfterThrowing(throwing = "ex",pointcut="within(org.anonymous.note.controller..*)")
	public void loggerException(Exception ex){
		//将异常信息写入文件中
		System.out.println("异常信息:"+ex);
		try {
			
			//创建路径
			File file = new File("Exception");
			//
			FileWriter fw = new FileWriter
						("");
			PrintWriter pw = new PrintWriter(fw);
			ex.printStackTrace(pw);
			pw.flush();
			pw.close();
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
