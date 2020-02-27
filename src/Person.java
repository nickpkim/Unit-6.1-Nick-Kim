public class Person{
    private int myAge;
    private String myName;
    public Person(int age, String name){
        myAge = age;
        myName = name;
    }
    public int getAge(){
        return myAge;
    }
    public String getName(){
        return myName;
    }
    public String toString(){
        return myName+", "+myAge;
    }
}
