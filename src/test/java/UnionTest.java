import org.junit.Assert;
import org.junit.Test;

/**
 * Created by satheessh on 9/27/16.
 */
public class UnionTest {
    @Test
    public void find() throws Exception {

      Union u = new Union(10);
        u.union(0,1);
        u.union(8,9);
        Assert.assertTrue(u.find(1,0));
        Assert.assertTrue(u.find(8,9));
        Assert.assertFalse(u.find(7,9));
        u.union(1,9);
        Assert.assertTrue(u.find(3,9));

    }

    @Test
    public void root() throws Exception {

    }

    @Test
    public void union() throws Exception {

    }

}