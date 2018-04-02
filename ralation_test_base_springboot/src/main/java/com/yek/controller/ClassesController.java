package com.yek.controller;

import com.yek.entity.Classes;
import com.yek.entity.Student;
import com.yek.repository.ClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by Administrator on 2018-03-31.
 */
@Controller
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    ClassesRepository classesRepository;
    @RequestMapping("/list")
    @ResponseBody
    public Object getClassesList(){
        List<Classes> classesList = classesRepository.findAll();
        System.out.println(classesList);
        Optional<Classes> optional = classesRepository.findById(1L);
        Classes classes = optional.get();
        System.out.println(classes);
        return classesList;
    }
    @RequestMapping("/byId")
    @ResponseBody
    public Object getClassesById(){
        Optional<Classes> optional = classesRepository.findById(1L);
        Classes classes = optional.get();
        Set<Student> students = classes.getStudents();
        return students;
    }
}
