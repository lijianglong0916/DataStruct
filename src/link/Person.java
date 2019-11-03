package link;/*
 *@author:
 *@time
 */

public class Person {
    private int age;
    private int id;
    private String name;
    private Long date;

    public Person(int age,int id,String name,Long date){
        this.age=age;
        this.id=id;
        this.name=name;
        this.date=date;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
