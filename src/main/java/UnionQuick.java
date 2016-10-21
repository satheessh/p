/**
 * Created by satheessh on 9/15/16.
 */
public class UnionQuick {


    private int a[];
    private int size[];


    public UnionQuick(int n) {

        a = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
            size[i] = 1;
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

        int l = root(i);
        int r = root(j);

        if (size[l] >= size[r]) {
            size[l] = size[l] + 1;
            a[j] = l;
        } else {

            size[j] = size[j] + 1;
            a[i] = r;
        }
    }


    public static void main(String[] args) {


    }

}
