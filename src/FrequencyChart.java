import java.util.*;
public class FrequencyChart {
    private int[] list;
    private String s0 = "";
    private String s1 = "";
    private String s2 = "";
    private String s3 = "";
    private String s4 = "";
    private String s5 = "";
    private String s6 = "";
    private String s7 = "";
    private String s8 = "";
    private String s9 = "";

    public FrequencyChart(int[] arr){
        list = arr;
    }
    public String makeChart(){
        String print = "";
        for (int n : list){
            if (0 < n && n <= 10){
                s0 += "*";
            }
            if (10 < n && n <= 20){
                s1 += "*";
            }
            if (20 < n && n <= 30){
                s2 += "*";
            }
            if (30 < n && n <= 40){
                s3 += "*";
            }
            if (40 < n && n <= 50){
                s4 += "*";
            }
            if (50 < n && n <= 60){
                s5 += "*";
            }
            if (60 < n && n <= 70){
                s6 += "*";
            }
            if (70 < n && n <= 80){
                s7 += "*";
            }
            if (80 < n && n <= 90){
                s8 += "*";
            }
            if (90 < n && n <= 100){
                s9 += "*";
            }
        }
        print += "1 - 10   | "+s0;
        print += "\n11 - 20  | "+s1;
        print += "\n21 - 30  | "+s2;
        print += "\n31 - 40  | "+s3;
        print += "\n41 - 50  | "+s4;
        print += "\n51 - 60  | "+s5;
        print += "\n61 - 70  | "+s6;
        print += "\n71 - 80  | "+s7;
        print += "\n81 - 90  | "+s8;
        print += "\n91 - 100 | "+s9;
        return print;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input;
        System.out.println("How many data values will you input?");
        input = scan.nextInt();
        int[] nums = new int[input];
        System.out.println();
        System.out.println("Enter data values one at a time (1-100)");
        int val;
        for (int i=0; i<input; i++){
            val = scan.nextInt();
            nums[i] = val;
        }
        System.out.println();
        System.out.println("Printing...");
        FrequencyChart chart = new FrequencyChart(nums);
        System.out.println();
        System.out.println(chart.makeChart());
    }
}
