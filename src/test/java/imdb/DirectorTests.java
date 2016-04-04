/**
 * 
 */
package imdb;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cs.mum.edu.extraCredit.dao.DirectorDAO;
import cs.mum.edu.extraCredit.domain.Director;

/**
 * @author OWNER
 *
 */
public class DirectorTests {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void createDirectorTest() {
		
		//Arrange
		Director director = new Director();
		director.setFirstName("Harold");
		director.setLastName("Cronk");
		
		DirectorDAO directorDao = new DirectorDAO();
		
		try {
			
			directorDao.createDirector(director);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Act
		Director directorTest = new Director();
		try {
			
			directorTest = directorDao.getDirectorByName("Harold", "Cronk").get(0);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//Assert
		assertEquals(director.getFirstName(), directorTest.getFirstName());
		
	}
	
	@Test
	public void deleteDirectorTest(){
		
		DirectorDAO directorDao = new DirectorDAO();
		try {
			
			//Arrange
			Director director = directorDao.getDirector(8);
			directorDao.deleteDirector(director);
			
			//Act
			director = directorDao.getDirector(8);
			
			//Assert
			assertNull(director);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void udpateDirectorTest(){
		DirectorDAO directorDao = new DirectorDAO();
		try {
			
			//Arrange
			Director director = directorDao.getDirector(9);
			director.setLastName("UpdatedLastName");
			directorDao.updateDirector(director);
			
			//Act
			Director directorTest = directorDao.getDirector(9);
			
			//Assert
			assertEquals(directorTest.getLastName(), "UpdatedLastName");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
