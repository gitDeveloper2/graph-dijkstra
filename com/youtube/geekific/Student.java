package com.youtube.geekific;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@Data
@AllArgsConstructor
public class Student implements  Comparable{
    private int age;
    private String name;

    @Override
    public int compareTo(Object o) {
        return this.getName().compareTo(((Student)o).getName());
    }
}
