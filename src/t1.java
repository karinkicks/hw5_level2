public class t1  implements Runnable{

    private float[] arr;

    public t1(float[] arr){
        this.arr = arr;
    }
    @Override
    public void run() {
        for (int i=0; i<arr.length;i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(  "последний элемент"+arr[arr.length-1]);
    }
}
