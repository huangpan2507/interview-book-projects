package Stack.CatDogQueue;


/*  PetEnterQueue函数：增加count属性，用于定制化Queue
*   提供获取pet，pet类型，以及count数据
* */
public class PetEnterQueue {

    private Pet pet;
    private long count;

    public  PetEnterQueue(Pet pet, long count){
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet(){
        return this.pet;
    }

    public String getEnterPetType(){
        return this.pet.getPetType();
    }

    public long getCount(){
        return this.count;
    }

}
