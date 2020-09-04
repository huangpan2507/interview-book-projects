package TY;

// 创建一个pet的队列类
class PetQueue{
    private Pet pet;//存放的宠物
    private long number; //存放的编号
    public PetQueue(Pet pet, long number) {
        this.pet = pet;
        this.number = number;
    }
    //获取编号
    public long getNumber(){
        return this.number;
    }
    //获取宠物
    public Pet getPet(){
        return this.pet;
    }
}
//题目给的，不能随意修改的
