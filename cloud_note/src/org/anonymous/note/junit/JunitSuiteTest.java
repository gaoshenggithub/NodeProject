package org.anonymous.note.junit;

import org.anonymous.note.dao.test.imple.TestClass;
import org.anonymous.note.dao.test.imple.TestLogin;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestClass.class,TestLogin.class})
public class JunitSuiteTest {
	
}
