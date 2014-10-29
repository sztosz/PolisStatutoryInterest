import java.io.File;
import java.util.Hashtable;

/**
 * Created by Bartosz Nowak on 2014-10-29.
 */
public class PolishStatutoryInterest {
    public static void main(String args[]) {
        Hashtable periods = new InterestPeriodJSONIO().getPeriods();
    }
}
