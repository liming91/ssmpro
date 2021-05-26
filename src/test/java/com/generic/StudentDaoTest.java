package com.generic;

/**
 * 泛型测试
 */
public class StudentDaoTest {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.add(new Student());
    }
}
