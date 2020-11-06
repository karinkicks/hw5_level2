
public class Main {


    public static void main(String[] args) {
        metod1();
        metod2();
    }

    static final int size = 10000000;
    static final int h = size / 2;

    static void metod1(){
        float[] arr = new float[size];
        for (int i=0; i<arr.length;i++){
            arr[i]=1;
        }
        long a = System.currentTimeMillis();
        for (int i=0; i<arr.length;i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long b =System.currentTimeMillis();
        System.out.println("Завершили первый метод за"+(b - a));
    }

    static void metod2(){
        float[] arr = new float[size];
        for (int i=0; i<arr.length;i++){
            arr[i]=1;
        }
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread t1 = new Thread(() -> {
                    metod3(a2);
        });

        Thread t2 = new Thread(() -> {
                    metod3(a2);
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        long b =System.currentTimeMillis();
        System.out.println("Завершили второй метод за"+(b - a));

    }
    synchronized static float[] metod3(float[] arr){
        for (int i=0; i<arr.length;i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("последний элемент" + arr[arr.length-1]);
        return arr;
    }
}
