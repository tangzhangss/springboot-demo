package xyz.zyrs.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.zyrs.demo.bean.Student;
import xyz.zyrs.demo.mapper.StudentMapper;

import java.util.List;

@Service
public class StudentService{

    @Autowired
    private StudentMapper studentMapper;

    //获取所有的学生信息
    public List<Student> get_student_list_all() {

      return studentMapper.get_student_list_all();

    }

    public  void insert_student(Student student){
        studentMapper.insert_student(student);
    }

    public void update_student(Student student){
        studentMapper.update_student(student);
    }

    public void delete_student(Integer id){
        studentMapper.delete_student(id);
    }
}