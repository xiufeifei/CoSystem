package com.kmxy.utils;

public enum BeanStateEnum {
    //User
    User_Normal(1, "在校"),
    User_shen_he(2, "休学"),
    User_DELETE(3, "毕业"),
    User_KAICHU(4, "开除学籍"),


    //Course
    Course_Normal(1, "正常状态"),
    Course_shen_he(2, "审核"),
    Course_DELETE(3, "删除"),

    //Chapter
    Chapter_Normal(1, "正常状态"),
    Chapter_shen_he(2, "审核"),
    Chapter_DELETE(3, "删除"),

    //Knowledge
    Knowledge_Normal(1, "正常状态"),
    Knowledge_shen_he(2, "审核"),
    Knowledge_DELETE(3, "删除");




    private final int type;
    private final String name;

    BeanStateEnum(int type, String name) {    //带参数的构造器
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public static String getNameByType(int type) {//此方法为static的，非static没有意义
        for (BeanStateEnum userType : BeanStateEnum.values()) {
            if (userType.getType() == type) {
                return userType.getName();
            }
        }
        throw new IllegalArgumentException("在UserTypeEnum里面没有类型：" + type);
    }

    public static int getTypeByName(String name) {
        for (BeanStateEnum userType : BeanStateEnum.values()) {
            if (userType.name == name) {
                return userType.getType();
            }
        }
        throw new IllegalArgumentException("在UserTypeEnum里面没有类型：" + name);
    }

    public static void main(String[] args) {    //测试方法
        System.out.println(BeanStateEnum.getNameByType(3));
        System.out.println(BeanStateEnum.getTypeByName("销售管理员"));
    }
}
