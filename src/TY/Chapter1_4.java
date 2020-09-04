package TY;
import java.util.LinkedList;
import java.util.Queue;

public class Chapter1_4 {
    private static final String DOG ="dog";
    private static final String CAT ="cat";

    private Queue<PetQueue> dogQueue ; //存放狗的队列
    private Queue<PetQueue> catQueue; //存放猫的队列
    private long count;//标记存放先后顺序的
    public Chapter1_4(){
        this.dogQueue = new LinkedList<PetQueue>();//初始化
        this.catQueue = new LinkedList<PetQueue>();//初始化
        this.count = 0;//初始化
    }
    public void add(Pet pet){
        if(DOG.equalsIgnoreCase(pet.getType())){
            dogQueue.offer(new PetQueue(pet,this.count++));
        }else{
            catQueue.offer(new PetQueue(pet,this.count++));
        }
    }

    //取出队列中最早进入队列的宠物
    public Pet pollAll(){
        //如果 两个队列中都有值
        if(!dogQueue.isEmpty() && !catQueue.isEmpty()){
            //如果dog的存放的编号小于cat的编号，则 说明dog比cat存放的早
            if(dogQueue.peek().getNumber()<catQueue.peek().getNumber()){
                return dogQueue.poll().getPet();
            }else{
                return catQueue.poll().getPet();
            }
        }else if(!dogQueue.isEmpty()) {
            //如果dog队列中有值而 cat队列已为空
            return dogQueue.poll().getPet();
        }else if(!catQueue.isEmpty()){
            //如果cat队列中有值而 dog队列已为空
            return catQueue.poll().getPet();
        }else{
            //都为空
            return null;
        }
    }
    //判断对列中是否都为空
    public boolean isEmpty(){
        return dogQueue.isEmpty() && catQueue.isEmpty();
    }
    //判断dog队列中是否都为空
    public boolean dogIsEmpty(){
        return dogQueue.isEmpty();
    }
    //判断cat队列中是否都为空
    public boolean catIsEmpty(){
        return catQueue.isEmpty();
    }

    //测试
    public static  void  main(String[] args){
        Chapter1_4 chapter = new Chapter1_4();
        for(int i=0;i<10;i++) {
            if((i&1)!=0){
                chapter.add(new Pet(DOG));
            }else{
                chapter.add(new Pet(CAT));
            }
        }
        System.out.println(chapter.isEmpty());
        System.out.println(chapter.dogIsEmpty());
        System.out.println(chapter.catIsEmpty());
        while(!chapter.isEmpty()){
            System.out.print(chapter.pollAll().getType() +" ");
        }
    }
}


