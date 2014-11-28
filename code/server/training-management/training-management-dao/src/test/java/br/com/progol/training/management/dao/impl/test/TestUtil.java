package br.com.progol.training.management.dao.impl.test;

import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-config.xml" } )
// @TransactionConfiguration(defaultRollback=true)
public abstract class TestUtil {

	/*
	@After
	@Rollback
	public void destroy() {
		
	}
	*/
	
}
