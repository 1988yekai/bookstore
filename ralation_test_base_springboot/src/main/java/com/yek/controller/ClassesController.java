package com.yek.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.yek.entity.Classes;
import com.yek.entity.Student;
import com.yek.repository.ClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
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
        Iterable<Classes> classesList = classesRepository.findAll();
        Iterator<Classes> iterator = classesList.iterator();
        while (iterator.hasNext()){
            Classes classes = iterator.next();
            System.out.println(classes.getStudents());
        }
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
