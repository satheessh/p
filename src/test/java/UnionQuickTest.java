import org.junit.Assert;
import org.junit.Test;

/**
 * Created by satheessh on 9/28/16.
 */
public class UnionQuickTest {
    @Test
    public void find() throws Exception {

        UnionQuick u = new UnionQuick(10);
        u.union(0, 1);
        u.union(8, 9);
        Assert.assertTrue(u.find(1, 0));
        Assert.assertTrue(u.find(8, 9));
        Assert.assertFalse(u.find(7, 9));
        u.union(1, 9);
        Assert.assertTrue(u.find(0, 9));

    }

    //@Test
    public void root() throws Exception {

        Union u = new Union(10);
        u.union(0, 1);
        u.union(8, 9);
        u.union(2, 3);
        u.union(1, 2);
        u.union(2, 9);

        Assert.assertEquals(0, u.root(9));
        Assert.assertEquals(0, u.root(3));
        Assert.assertEquals(0, u.root(1));


    }

}