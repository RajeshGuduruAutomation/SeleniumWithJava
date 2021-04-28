import java.util.*;

public class ArrayAndList {
    public static void main(String[] args) {
        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;

        List<Integer> arrL = new ArrayList<>(3);
        arrL.add(1);
        arrL.add(2);
        arrL.add(3);
        System.out.println(arr.length );
        List arrC = new ArrayList<>();
        Collections.addAll(arrC,arr);
        arrC.add(4);
        System.out.println("arC"+arrC);
        List<int[]> arrs = Collections.singletonList(arr);
        //List<int[]> arrs = new ArrayList<int[]>(Arrays.asList(arr)) ;
        for (int[] i : arrs) {
            System.out.println(i[0]);
        }
        System.out.println(arrs);
        arrL.add(4);
        System.out.println(arrL);

        String[] arrays = {"Rajesh", "guduru"};
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(arrays));
        System.out.println(arrayList.add("MCA"));
        Iterator ite = arrayList.iterator();
        while(ite.hasNext()){
            System.out.println(ite.next());
        }
        List<String> arrayList1 = new ArrayList<>();
        arrayList1.addAll(arrayList);
        System.out.println(arrayList);
        System.out.println(arrayList1);
        for(String s: arrayList1) {
            System.out.println("s :"+s);
        }
    }
}
