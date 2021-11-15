package com.ptx.ForEachAndComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Java8ComparatorPlus {
    public static void main(String[] args) {
        List<Persion> list = new ArrayList<Persion>();
        list.add(new Persion(3, "A", 28));
        list.add(new Persion(1, "A", 22));
        list.add(new Persion(4, "B", 26));
        list.add(new Persion(2, "B", 20));
        list.add(new Persion(5, "C", 30));
        System.out.println("In ra danh sách Persion theo java < 8: trước khi sắp xếp.");
        list.forEach(persion -> {
            System.out.println("ID= " + persion.getId() + " Name= " + persion.getName() + " Age= " + persion.getAge());
        });
        // Sắp xếp theo nhiều điều kiện sử dụng express lamda:
        System.out.println("Sắp xếp persion theo nhiều điều kiện sử dụng Express lamda: theo tên -> tuổi -> ID");
        list.sort((p1, p2) -> {
            if (p1.getName().compareTo(p2.getName()) > 0) {
                return 1;
            } else if (p1.getName().compareTo(p2.getName()) < 0) {
                return -1;
            } else {
                if (p1.getAge() - p2.getAge() > 0) {
                    return 1;
                } else if (p1.getAge() - p2.getAge() < 0) {
                    return -1;
                } else {
                    if (p1.getId() - p2.getId() > 0) {
                        return 1;
                    } else if (p1.getId() - p2.getId() < 0) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });
        list.forEach(persion -> {
            System.out.println("ID= " + persion.getId() + " Name= " + persion.getName() + " Age= " + persion.getAge());
        });

        int[] arr = {-1, 5, 1, -5, 8};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
