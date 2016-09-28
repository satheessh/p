/**
 * Created by satheessh on 9/15/16.
 */
public class Union {


    private int a[];


    public Union(int n) {

        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
    }


    public boolean find(int a, int b) {
        return root(a) == root(b);

    }

    public int root(int i) {

        while (a[i] != i) {
            i = a[i];
        }
        return i;
    }

    public void union(int i, int j) {

        int l = a[i];
        int r = a[j];

        a[j] = root(i);

    }


    public static void main(String[] args) {


    }

}
