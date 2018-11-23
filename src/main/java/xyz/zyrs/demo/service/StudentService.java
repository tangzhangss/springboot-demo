package xyz.zyrs.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
    public void update_student(Student student){
        studentMapper.update_student(student);

        //模拟中间环节错误
        int  test = 1/0;
        //将年龄置为100
        student.setAge(100);
        studentMapper.update_student(student);
    }

    public void delete_student(Integer id){
        studentMapper.delete_student(id);
    }
}