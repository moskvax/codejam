import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.moskvax.playground.Main;

public class MaxDifferenceTest {

  @Test
  public void findsMaxDifference1() {

    final List<Double> input = Arrays.asList(3d, 6d, 2d, 3d);
    Main.Result r = Main.findMaxDifference(input);
    Assert.assertEquals(Double.valueOf(3d), r.maxDifference);
    Assert.assertEquals(0, r.maxDifferenceIndex);
  }


}
