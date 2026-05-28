package com.ust.studentmanagement.service;

import com.ust.studentmanagement.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StudentService {
    private final ConcurrentMap<Long, Student> students = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public Student addStudent(Student student) {
        Long id = nextId.getAndIncrement();
        student.setId(id);
        students.put(id, student);
        return student;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    public Optional<Student> getStudentById(Long id) {
        return Optional.ofNullable(students.get(id));
    }

    public Optional<Student> updateStudent(Long id, Student updatedStudent) {
        if (!students.containsKey(id)) {
            return Optional.empty();
        }

        updatedStudent.setId(id);
        students.put(id, updatedStudent);
        return Optional.of(updatedStudent);
    }

    public boolean deleteStudent(Long id) {
        return students.remove(id) != null;
    }
}
