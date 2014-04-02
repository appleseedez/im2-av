
package com.itel.platform.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SelfLogTest extends GenericJunitDataInDBTest {
   
    protected Logger log = LoggerFactory.getLogger(getClass());
    @Test
    public void logself(){
        log.info("-----------------self4JJJ to log4j------------------");
    }
    
    protected org.apache.log4j.Logger log4 = org.apache.log4j.Logger.getLogger(SelfLogTest.class);
    @Test
    public void testlog4(){
    	log4.info("-----------------this is log4j------------------");
    }
   
}
