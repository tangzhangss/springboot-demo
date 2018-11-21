package xyz.zyrs.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.zyrs.demo.bean.Student;

import java.util.List;


@Mapper
public interface StudentMapper {
      List<Student> get_student_list_all();

      void delete_student(Integer id);

      void insert_student(Student student);

      void update_student(Student student);
}
