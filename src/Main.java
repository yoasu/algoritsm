

import java.util.Stack;
class Program{
    public static int removeElementInplace(int[] arr, int val){
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != val){
                arr[index] = arr[i];
                index++;
                System.out.printf("%d\t", arr[i]);

            }
        }
        return index;
    }




    public static void main(String[] args){
        System.out.println(removeElementInplace(new int[]{3, 4, 5, 6 ,2 ,2, 2, 2, 6 }, 2));


    }
}
