package TY;

class Pet{
    private String type;
    public Pet(){
    }
    public Pet(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
}
//题目给的，不能随意修改的
class Dog extends  Pet{
    public Dog(){
        super("dog");
    }
}
//题目给的，不能随意修改的
class Cat extends  Pet{
    public Cat(){
        super("cat");
    }
}
