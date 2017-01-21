import java.util.*;

class Catalan {
    // A recursive function to find nth catalan number

    double catalan(int n) {
        double res = 0;

        // Base case
        if (n <= 1) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            res += catalan(i) * catalan(n - i - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Catalan cn = new Catalan();
        Scanner reader = new Scanner(System.in);
        int tries = reader.nextInt();

        for (int i = 0; i < tries; i++) {
          int num = reader.nextInt();
          System.out.println(cn.catalan(num));
        }
    }
}
