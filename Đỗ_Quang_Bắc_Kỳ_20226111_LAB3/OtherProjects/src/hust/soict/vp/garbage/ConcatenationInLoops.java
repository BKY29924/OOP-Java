
package hust.soict.vp.garbage;
import java.util.Random;
import static java.lang.System.currentTimeMillis;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        Random r = new Random(123);
        long start = currentTimeMillis();
        String s = "";
        for (int i = 0; i < 65536; i++) s += r.nextInt(2);
        System.out.println(currentTimeMillis() - start);

        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++)
            sb.append(r.nextInt(2));
        s += sb.toString();
        System.out.println(System.currentTimeMillis() - start);
    }
}
