package com.youtube.geekific;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
       PriorityQueue<Student> students=new PriorityQueue<>(
                Arrays.asList(
                        new Student(79,"zacheus"),
                        new Student(23,"esther"),
                        new Student(24,"peter"),
                        new Student(24,"andrew")

                )
       );
        while(!students.isEmpty()){
            Student student =students.poll();
            System.out.println(student.getAge() +"  "+student.getName());
        }
    }
}
