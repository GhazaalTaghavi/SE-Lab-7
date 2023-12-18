package com.unittest.codecoverage.samples;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.unittest.codecoverage.models.Person;
import com.unittest.codecoverage.repositories.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonRepositoryTest {

    private PersonRepository personRepository;

    @BeforeEach
    void setUp() {
        personRepository = new PersonRepository();
    }

    @Test
    void insert_ValidPerson_ReturnsInsertedPerson() {
        // Arrange
        Person person = new Person();
        person.setName("John");
        person.setAge(30);

        // Act
        Person insertedPerson = personRepository.insert(person);

        // Assert
        assertNotNull(insertedPerson);
        assertEquals(person, insertedPerson);
    }

    @Test
    void insert_NullPerson_ThrowsNullPointerException() {
        // Assert
        assertThrows(NullPointerException.class, () -> personRepository.insert(null));
    }

    @Test
    void update_ValidPerson_NoExceptionsThrown() {
        // Arrange
        Person person = new Person();
        person.setName("Alice");
        person.setAge(25);

        // Act & Assert
        assertDoesNotThrow(() -> personRepository.update(person));
    }

    @Test
    void update_NullPerson_ThrowsNullPointerException() {
        // Assert
        assertThrows(NullPointerException.class, () -> personRepository.update(null));
    }

    @Test
    void delete_ValidName_NoExceptionsThrown() {
        // Arrange
        String name = "Bob";

        // Act & Assert
        assertDoesNotThrow(() -> personRepository.delete(name));
    }

    @Test
    void delete_NullName_ThrowsNullPointerException() {
        // Assert
        assertThrows(NullPointerException.class, () -> personRepository.delete(null));
    }

    @Test
    void get_ValidName_ReturnsNull() {
        // Arrange
        String name = "Charlie";

        // Act
        Person retrievedPerson = personRepository.get(name);

        // Assert
        assertNull(retrievedPerson);
    }

    @Test
    void get_NullName_ThrowsNullPointerException() {
        // Assert
        assertThrows(NullPointerException.class, () -> personRepository.get(null));
    }
}
