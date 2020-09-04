package Stack.CatDogQueue;

import java.util.LinkedList;
import java.util.Queue;

public class DogCatQueue {
    public static final  String DOG = "Dog";
    public static final  String CAT = "Cat";


    public Queue<PetEnterQueue> dogQ;
    public Queue<PetEnterQueue> catQ;
    public long count;


    public DogCatQueue(){
        this.catQ = new LinkedList<>();
        this.dogQ = new LinkedList<>();
        this.count = 0;
    }

    public void add(Pet pet, long count){
        if(pet.getPetType().equalsIgnoreCase(CAT))
            this.catQ.add(new PetEnterQueue(pet, this.count++));
        else if(pet.getPetType().equalsIgnoreCase(DOG))
            this.dogQ.add(new PetEnterQueue(pet, this.count++));
        else{
            throw new RuntimeException("erro, neither dog or cat! Please enter again");
        }
    }

    public PetEnterQueue pollAll(){
        if(!this.dogQ.isEmpty() && ! this.catQ.isEmpty()){
            if(this.dogQ.peek().getCount() > this.catQ.peek().getCount())
                return this.dogQ.poll();
            else
                return this.catQ.poll();

        }else if(!this.dogQ.isEmpty()){
            return this.dogQ.poll();

        }else if(!this.catQ.isEmpty()){
            return this.catQ.poll();
        }
        else
            throw new RuntimeException("erro, your queue is empty!");


    }

    public PetEnterQueue pollDog(){
        if (!this.isDogEmpty())
            return this.dogQ.poll();
        else
            throw new RuntimeException("erro, dogQueue is empty!");
    }

    public PetEnterQueue pollCat(){
        if (!this.isCatEmpty())
            return this.catQ.poll();
        else
            throw new RuntimeException("erro, catQueue is empty!");
    }


    public boolean isEmpty(){
        return this.dogQ.isEmpty() && this.catQ.isEmpty();

    }


    public boolean isDogEmpty(){
        return this.dogQ.isEmpty();
    }

    public boolean isCatEmpty(){
        return this.catQ.isEmpty();
    }

    public long showCount(Queue<PetEnterQueue> que){
        if(que.isEmpty())
            throw new RuntimeException("dogQ and catQ are both empty!");
        else
            return que.peek().getCount();

        }



}


