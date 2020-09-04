package Stack.CatDogQueue;

import static Stack.CatDogQueue.DogCatQueue.DOG;
import static Stack.CatDogQueue.DogCatQueue.CAT;


public class CatDogQueueTest {
    

    //    private static Queue<PetEnterQueue> catQ;
//
    public static void main(String args[]){
        DogCatQueue Que = new DogCatQueue();

        Pet cat1 = new Pet("Cat");
        Pet cat2 = new Pet("Cat");
        Pet dog1 = new Pet("Dog");
        Pet dog2 = new Pet("Dog");
        Pet dog3 = new Pet("Dog");
        Pet cat3 = new Pet("Cat");

//        for (int i=0;i<10;i++){
//
//            if(i%3==0){
//                Que.add(new Pet(DOG), Que.count);
////                    System.out.println("==0"+" "+Que.showCount(Que.dogQ) );
//            }else {
//                Que.add(new Pet(CAT), Que.count);
////                System.out.println("not0"+" "+Que.showCount(Que.catQ) );
//            }
//        }

        System.out.println("count:"+Que.count);
        Que.add(cat1,Que.count);
        System.out.println("cat1 count:"+Que.count);
        Que.add(dog1,Que.count);
        System.out.println("dog1 count:"+Que.count);
        Que.add(cat2,Que.count);
        System.out.println("cat2 count:"+Que.count);
        Que.add(cat3,Que.count);
        System.out.println("cat3 count:"+Que.count);
        Que.add(dog2,Que.count);
        System.out.println("dog2 count:"+Que.count);
        Que.add(dog3,Que.count);
        System.out.println("dog3 count:"+Que.count);

        while(!Que.isEmpty()){
            PetEnterQueue j = Que.pollAll();
//            System.out.println(j.getPet() +" "+ Que.showCount(Que.catQ));          //其实也不用重写toString方法，＋“ ” 就行了
            System.out.println(j.getPet() +" "+j.getCount());
        }
//        Pet b = Que.pollCat();
//        System.out.println(b);
//        String a = Que.pollCat().toString();
//        System.out.println(a);
//        System.out.println(Que.isCatEmpty());


    }
}
