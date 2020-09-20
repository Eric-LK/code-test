package enums;


public enum EnumTest implements Show{
    // 枚举的实例
    ONE("张新玲",18),
    TWO("eric",123),
    THREE("赫于富",45,"man"),
    sdf;

    private String name;
    private Integer age;
    private String sex;

    EnumTest(){}
    EnumTest(String name, int age) {
        this.name  = name;
        this.age = age;
    }

    EnumTest(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String show() {
        return name;
    }
}
