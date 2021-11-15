package com.ptx.ForEachAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Java8Comparator {
    public static void main(String[] args) {
        // Khai báo List persion:
        List<Persion> persions = new ArrayList<Persion>();
        persions.add(new Persion(3, "A", 18));
        persions.add(new Persion(2, "X", 22));
        persions.add(new Persion(1, "G", 20));
        persions.add(new Persion(4, "E", 28));
        persions.add(new Persion(5, "S", 19));
        // In danh sách persion trước khi sắp xếp java < 8:
        System.out.println("List of persion before sorting Java < 8: ");
        persions.forEach(persion -> {
            System.out.println("ID = " + persion.getId() + " Name = " + persion.getName() + " Age = " + persion.getAge());
        });
        // Sắp xếp theo tuổi java < 8:
        // truyền vào list persion , tạo class implement interface comparator:
        System.out.println("Sắp xếp theo ID với java < 8:");
        Collections.sort(persions, new Comparator<Persion>() {
            @Override
            public int compare(Persion p1, Persion p2) {
                return p1.getId() - p2.getId();
            }
        });
        System.out.println("List of persion After sorting ID Java < 8, theo thứ tự tăng dần. ");
        persions.forEach(persion -> {
            System.out.println("ID = " + persion.getId() + " Name = " + persion.getName() + " Age = " + persion.getAge());
        });
        // Dùng Java 8 để sắp xếp :
        System.out.println(" Sử dụng Java 8 để sắp xếp theo ID theo thứ tự giảm dần.");
        persions.sort(new Comparator<Persion>() {
            @Override
            public int compare(Persion p1, Persion p2) {
                return p2.getId()- p1.getId();
            }
        });
        persions.forEach(persion -> {
            System.out.println("ID = " + persion.getId() + " Name = " + persion.getName() + " Age = " + persion.getAge());
        });
        // Sử dụng Java 8 express lamda để viết :
        System.out.println(" Sử dụng Express Lamda để viết sắp xếp ID theo thứ tự giảm dần: ");
        persions.sort((Persion p1, Persion p2) -> {return p2.getId()- p1.getId();});
        persions.forEach(persion -> {
            System.out.println("ID = " + persion.getId() + " Name = " + persion.getName() + " Age = " + persion.getAge());
        });
        // Viết ngắn gọn hơn với express lamda:
        System.out.println(" Viết ngắn gọn với Express lamda để sắp xếp ID");
        persions.sort((p1, p2) -> {return p1.getId()- p2.getId();});
        persions.forEach(persion -> {
            System.out.println("ID = " + persion.getId() + " Name = " + persion.getName() + " Age = " + persion.getAge());
        });
        // Sắp xếp theo thứ tự tăng dần của tuổi:
        System.out.println(" Sắp xếp persion theo thứ tự tăng dần của tuổi: ");
        persions.sort((p1,p2)->{return p1.getAge()- p2.getAge();});
        persions.forEach(persion -> {
            System.out.println("ID = " + persion.getId() + " Name = " + persion.getName() + " Age = " + persion.getAge());
        });
        // Sắp xếp theo thứ tự tăng dần của tên:
        System.out.println("Sắp xếp Persion theo thứ tự tăng dần của tên: ");
        persions.sort((p1,p2)->{return (p1.getName()).compareTo(p2.getName());});
        persions.forEach(persion -> {
            System.out.println("ID = " + persion.getId() + " Name = " + persion.getName() + " Age = " + persion.getAge());
        });
    }
}
