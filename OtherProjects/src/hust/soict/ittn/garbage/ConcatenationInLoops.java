package hust.soict.ittn.garbage;

import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        Random r = new Random(123);
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2);
        }
        long timePlus = System.currentTimeMillis() - start;
        System.out.println("Using '+' operator: " + timePlus + " ms");

        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sb.append(r.nextInt(2));
        }
        s = sb.toString();
        long timeStringBuilder = System.currentTimeMillis() - start;
        System.out.println("Using StringBuilder: " + timeStringBuilder + " ms");

        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < 65536; i++) {
            sbf.append(r.nextInt(2));
        }
        s = sbf.toString();
        long timeStringBuffer = System.currentTimeMillis() - start;
        System.out.println("Using StringBuffer: " + timeStringBuffer + " ms");
    }
}

