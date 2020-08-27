package com.example.university;

import com.example.university.domain.Person;
import com.example.university.domain.Student;
import com.example.university.repo.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrate Creation, Reading, Updating, and Deletion of Students with StudentRepository
 * <p>
 * Created by maryellenbowman
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudRepositoryDemo {

  private static Logger log = LoggerFactory.getLogger(CrudRepositoryDemo.class);

    @Autowired
    StudentRepository studentRepository;

    /**
     * Exercise CrudRepository methods.
     */
    @Test
    public void simpleStudentCrudExample() {
        boolean fullTime = true;
        studentRepository.save(new Student(new Person("jane", "doe"), fullTime, 20));
        studentRepository.save(new Student(new Person("john", "doe"), fullTime, 22));
        studentRepository.save(new Student(new Person("mike", "smith"), fullTime, 18));
        studentRepository.save(new Student(new Person("ally", "kim"), !fullTime, 19));

        log.info("\n*************Original Students*************");
        //studentRepository.findAll().forEach(log::info);

        //age up the students
        studentRepository.findAll().forEach(student -> {
            student.setAge(student.getAge() + 1);
            studentRepository.save(student);
        });

        log.info("\n*************Students a year older*************");
        //studentRepository.findAll().forEach(log::info);

        studentRepository.deleteAll();
        log.info("\n*************Students removed*************");
        //studentRepository.findAll().forEach(log::info);

    }


}
