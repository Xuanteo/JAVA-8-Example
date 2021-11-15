package com.ptx.ForEachAndComparator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Java8ForEach {
    public static void main(String[] args) {
        // Khai báo 1 list:
        List<String> persions = new ArrayList<String>();
        persions.add("Hoc Java8 1");
        persions.add("Hoc Java8 2");
        persions.add("Hoc Java8 3");
        persions.add("Hoc Java8 4");
        persions.add("Hoc Java8 5");
        // in ra các phần tử:
        System.out.println("Sử dụng Java < 8 để thực hiện: ");
        for (String persion : persions) {
            System.out.println(persion);
        }
        System.out.println("Sử dụng Java = 8 để thực hiện: ");
        // java8 +lamda java8
        // Sử dụng lamda tạo 1 biến để gán giá trị p
        persions.forEach((p) -> {
            System.out.println(p);
        });
        // Tạo 1 danh sách persion.
        // Sử dụng với List
        System.out.println("Sử dụng List: ");
        List<Persion> list = new ArrayList<Persion>();
        list.add(new Persion(1, "fullname1"));
        list.add(new Persion(2, "fullname2"));
        list.add(new Persion(3, "fullname3"));
        list.add(new Persion(4, "fullname4"));
        list.add(new Persion(5, "fullname5"));
        // In ra danh sách persion:
        list.forEach((persion) -> {
            System.out.println("ID= " + persion.getId() + " Name= " + persion.getName());
        });
        // Sử dụng với map:
        System.out.println("Sử dụng Map: ");
        Map<Integer, String> map = new HashMap<Integer, String>();
        // add dữ liệu vào map.
        map.put(1, "fullname1");
        map.put(2, "fullname2");
        map.put(3, "fullname3");
        map.put(4, "fullname4");
        map.put(5, "fullname5");
        // Sử dụng Java < 8:
        System.out.println("Sử dụng Map với Java <8");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        // Sử dụng với Java = 8:
        System.out.println("Sử dụng Map với Java 8: ");
        map.forEach((k, v) -> {
            System.out.println(k + " : " + v);
        });
    }
}
