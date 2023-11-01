package com.example.demo.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class StudentRepositoryTest {
@Autowired
private StudentRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();

    }


    @Test
    void itShouldCheckIfStudentEmailExist() {
//        given
        String email="ataleltizazu19@gmail.com";
        Student student=new Student("Atalel",
                email,
                Gender.MALE);
        underTest.save(student);
//        when
        boolean exist=underTest.selectExistsEmail(email);
//         then
        assertThat(exist).isTrue();

    }
    @Test
    void itShouldCheckIfStudentEmailIsNotExist() {
//        given
        String email="ataleltizazu19@gmail.com";

//        when
        boolean exist=underTest.selectExistsEmail(email);
//         then
        assertThat(exist).isFalse();

    }
}
