package studentSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    public static void startStudetnSystem() {
        ArrayList<Student> list = new ArrayList<>();
        while (true) {
            System.out.println("-----------------欢迎来到学生管理系统----------------");
            System.out.println("1:添加学生");
            System.out.println("2:删除学生");
            System.out.println("3:修改学生");
            System.out.println("4:查询学生");
            System.out.println("5:退出系统");
            System.out.println("请输入您的选择");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch (choose) {
                case "1" -> addStudent(list);
                case "2" -> deleteStudent(list);
                case "3" -> updateStudent(list);
                case "4" -> queryStudent(list);
                case "5" -> {
                    System.out.println("退出");
                    System.exit(0);//停止虚拟机运行
                }
                default -> System.out.println("没有这个选项");
            }
        }
    }

    //添加学生
    public static void addStudent(ArrayList<Student> list) {
        Student s = new Student();
        Scanner sc = new Scanner(System.in);
        String id = null;
        while (true) {
            System.out.println("请输入学生id");
            id = sc.next();
            boolean flag = contains(list, id);
            if (flag) {
                //表示id已经存在，需要重新录入
                System.out.println("id已经存在，请重新录入");
            } else {
                //表示id不存在，表示可以使用
                s.setId(id);
                break;
            }
        }
        System.out.println("请输入学生姓名");
        String name = sc.next();
        s.setName(name);
        System.out.println("请输入学生年龄");
        int age = sc.nextInt();
        s.setAge(age);
        System.out.println("请输入学生家庭住址");
        String address = sc.next();
        s.setAdress(address);
        list.add(s);
        System.out.println("学生信息添加成功");
    }


    public static void deleteStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的id");
        String id = sc.next();
        int index = getIndex(list, id);
        //对索引判断
        if (index >= 0) {
            list.remove(index);
            System.out.println("id为" + id + "的学生删除成功");
        } else {
            System.out.println("id不存在，删除失败");
        }
    }


    public static void updateStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改的学生的id");
        String id = sc.next();
        int index = getIndex(list, id);
        if (index == -1) {
            System.out.println("id不存在，请重新输入");
            return;
        }
        Student stu = list.get(index);
        System.out.println("请输入要修改的学生姓名");
        String newName = sc.next();
        stu.setName(newName);
        System.out.println("请输入要修改的学生年龄");
        int newAge = sc.nextInt();
        stu.setAge(newAge);
        System.out.println("请输入要修改的学生家庭住址");
        String newAddress = sc.next();
        stu.setAdress(newAddress);
        System.out.println("学生信息修改成功");
    }

    public static void queryStudent(ArrayList<Student> list) {
        if (list.size() == 0) {
            System.out.println("当前无学生信息");
            return;
        }
        System.out.println("id\t\t姓名\t年龄\t家庭住址");
        for (Student stu : list) {
            System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t" + stu.getAdress());
        }
    }

    //判断id在集合中是否存在
    public static boolean contains(ArrayList<Student> list, String id) {
        //循环遍历集合得到里面的每一个对象
        //拿到学生对象之后 获取id进行判断
        //存在 true 不存在 false
        return getIndex(list, id) >= 0;
    }

    //通过id获取索引的方法
    public static int getIndex(ArrayList<Student> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            //得到每一个学生的id
            String sid = stu.getId();
            //拿集合中的id与要查询的id比较
            if (sid.equals(id)) {
                //如果存在 返回索引
                return i;
            }
        }
        return -1;
    }
}

