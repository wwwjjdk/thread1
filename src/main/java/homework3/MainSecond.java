package homework3;

import java.util.*;
public class MainSecond {
    public static void main(String[] args){

        List<Integer> list = createList();
        list.stream().reduce((value, combinedValue) -> combinedValue + value).ifPresent(System.out::println);
        long timeStart =System.currentTimeMillis();
        System.out.printf("%s ms\n",timeStart);

        int [] array = new int [list.size()];
        for(int i = 0; i< list.size(); i ++){
            array[i]= list.get(i);
        }

        MyCallableSecond myCallableSecond = new MyCallableSecond(array);
        myCallableSecond.fork();
        System.out.printf("%s\nразница в %s ms",myCallableSecond.join(),System.currentTimeMillis() - timeStart);

    }
    public static List<Integer> createList(){
        int size = customInt();
        List<Integer>  array= new ArrayList<>();
        for(int i =0;i<size;i++){
            array.add(customInt());
        }
        return  array;
    }

    public static int customInt(){
        return (int)Math.floor(Math.random()*100);
    }
}
