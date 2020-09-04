package Stack.CatDogQueue;

public class Pet {

    private String type;

    public Pet(String type){
        this.type = type;
    }

    public String getPetType(){
        return this.type;
    }

    public String toString(){
        if (this.type == null)
            throw new RuntimeException("name is empty!");
        else
            return type.toString();

    }

}

class Cat extends Pet{
    public Cat(){
        super("Cat");
    }
}

class Dog extends Pet{
    public Dog(){
        super("Dog");
    }
}







