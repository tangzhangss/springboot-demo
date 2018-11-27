package xyz.zyrs.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.zyrs.demo.bean.Student;
import xyz.zyrs.demo.mapper.StudentMapper;
import xyz.zyrs.demo.utils.RedisUtil;

import java.util.List;

@Service
public class StudentService{

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private RedisUtil redisUtil;


    //获取所有的学生信息
    @Cacheable(value="myCache", key = "'student_list_all'")
    public List<Student> get_student_list_all() {

        List<Student> studentList =  studentMapper.get_student_list_all();

        System.out.println("从mysql中取得数据...");

//换注解方式实现
//        List<Student> studentList = null;
//
//        if(  null != (studentList= (List<Student>) redisUtil.get("student_list_all"))){
//
//            System.out.println("redis取得数据..."+studentList.toString());
//
//        }else {
//            System.out.println("从mysql中取得数据...");
//            studentList = studentMapper.get_student_list_all();
//
//            redisUtil.set("student_list_all",studentList);
//            System.out.println("数据放入redis中...");
//        }

        return studentList;

    }

    public  void insert_student(Student student){
        studentMapper.insert_student(student);
    }


    @Transactional
    @CacheEvict(value="myCache",key="'student_list_all'")
    public void update_student(Student student){
        studentMapper.update_student(student);

        //删除缓存 -- 换成注解方式
        //redisUtil.remove("student_list_all");


//        //模拟中间环节错误 - 事务测试
//        int  test = 1/0;
//        //将年龄置为100
//        student.setAge(100);
//        studentMapper.update_student(student);
    }

    public void delete_student(Integer id){
        studentMapper.delete_student(id);
    }
}