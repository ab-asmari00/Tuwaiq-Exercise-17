package com.example.tuwaiqexercise17.Service;

import com.example.tuwaiqexercise17.Api.ApiException;
import com.example.tuwaiqexercise17.Model.Teacher;
import com.example.tuwaiqexercise17.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        List<Teacher> result = teacherRepository.findAll();
        if (result.isEmpty()) {
            throw new ApiException("Teacher list is empty");
        }
        return result;
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id, Teacher teacher) {
        Teacher oldTeacher = teacherRepository.findById(id)
                .orElseThrow(() -> new ApiException("Teacher not found"));

        oldTeacher.setName(teacher.getName());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setEmail(teacher.getEmail());
        oldTeacher.setSalary(teacher.getSalary());
        oldTeacher.setAddress(teacher.getAddress());

        teacherRepository.save(oldTeacher);
    }

    public void deleteTeacher(Integer id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new ApiException("Teacher was not found"));
        teacherRepository.delete(teacher);
    }

    public Teacher getTeacherById(Integer id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new ApiException("Teacher was not found"));
    }
}
