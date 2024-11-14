public class ReverseMethod {
    public static void main(String[] args) {

        int[] orderedArray = {1,2,3,4,5,6,7,8,9};
        int[] reversedArray = new int[orderedArray.length];
        reversedArray = flipArray(orderedArray,orderedArray.length);
        for(int n:reversedArray){
            System.out.print(n+" ");
        }

    }
    public static int[] flipArray(int[] x, int length) {
        int[] holder = new int[length];
        for(int i=0;i<x.length;i++){
            holder[i]=x[x.length - i -1];
        }
        return holder;
    }
}

