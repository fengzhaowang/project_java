package Base;

public class CustomException {
    public static void main(String[] args) {
        Persons persons = new Persons();
        persons.setAge(-10);
    }
}

class Persons{
    private int age;

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        if(age < 0){
            throw new IllegalAgeException("年龄不能为负数");
        }
        this.age = age;
    }
}

class IllegalAgeException extends RuntimeException{
    public IllegalAgeException(){

    }
    public IllegalAgeException(String msg){
        super(msg);
    }
}
