package java_8.stream;

public class Person {
    private String name;
    private Integer age;
    private String sex;


    Person(String a, Integer b,String c){
        name = a;
        age = b;
        sex = c;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
