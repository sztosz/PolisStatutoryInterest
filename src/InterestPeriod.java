import org.joda.time.DateTime;
import org.joda.time.Period;

/**
 * Created by Bartosz Nowak on 2014-10-29.
 */
public class InterestPeriod implements IntrestPeriodInterface {

    private Integer seq;
    private Double interestRate;
    private Period period;

    public InterestPeriod(Integer seq, DateTime start, DateTime end, Double interestRate) {
        this.seq = seq;
        this.interestRate = interestRate;
        this.period = new Period(start, end);
    }

    public Integer getDays() {
        return period.getDays();
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public Integer getSequenceNr() {
        return seq;
    }
}
