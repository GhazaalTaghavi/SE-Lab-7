package com.unittest.codecoverage.samples;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;

import java.util.Optional;

import com.unittest.codecoverage.models.Footpassenger;
import com.unittest.codecoverage.models.Person;
import com.unittest.codecoverage.services.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AssertionsSampleTest {
	
	@Test
	public void whenAssertingArraysEquality_thenEqual() {
	    char[] expected = { 'J', 'a', 'v', 'a' };
	    char[] actual = "Java".toCharArray();

	    assertArrayEquals(expected, actual, "Arrays should be equal");
	}
	
	@Test
	public void whenAssertingEquality_thenEqual() {
	    float square = 2 * 2;
	    float rectangle = 2 * 2;

	    assertEquals(square, rectangle);
	}
	
	@Test
	public void whenAssertingConditions_thenVerified() {
	    assertTrue(5 > 4, "5 is greater the 4");
	    assertTrue(null == null, "null is equal to null");
	}
	
	@Test
	public void whenAssertingNull_thenTrue() {
	    Object object = null;

	    assertNull(object, () -> "The object should be null");
	}
	
	@Test
	public void whenAssertingNotNull_thenTrue() {
	    Object object = new Object();

	    assertNotNull(object, () -> "The object should not be null");
	}
	
	@Test
	public void whenAssertingSameObject_thenSuccessfull() {
	    String language = "Java";
	    Optional<String> optional = Optional.of(language);

	    assertSame(language, optional.get());
	}
	

	@Test
	void whenAssertingException_thenThrown() {
	    Throwable exception = assertThrows(
	      IllegalArgumentException.class, 
	      () -> {
	          throw new IllegalArgumentException("Exception message");
	      }
	    );
	    assertEquals("Exception message", exception.getMessage());
	}


	@Test
	void crossedTheCrosswalk_ReturnsCorrectValue() {
		Footpassenger footpassenger = new Footpassenger();
		boolean expectedValue = true;
		boolean actualValue = footpassenger.crossedTheCrosswalk();
		assertEquals(expectedValue, actualValue, "The crossedTheCrosswalk method should return the correct value");
	}


	@Test
	void setCrossedTheCrosswalk_SetsCorrectValue() {
		Footpassenger footpassenger = new Footpassenger();
		boolean expectedValue = true;
		footpassenger.setCrossedTheCrosswalk(expectedValue);
		assertEquals(expectedValue, footpassenger.crossedTheCrosswalk(), "The setCrossedTheCrosswalk method should set the value correctly");
	}


	@Test
	void getAge_ReturnsCorrectAge() {
		int expectedAge = 30;
		Person person = new Person();
		person.setAge(expectedAge);
		int actualAge = person.getAge();
		assertEquals(expectedAge, actualAge, "The getAge method should return the correct age");
	}
}
