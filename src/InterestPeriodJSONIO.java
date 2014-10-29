import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

/**
 * Created by Bartosz Nowak on 2014-10-29.
 */
public class InterestPeriodJSONIO {

    public Hashtable getPeriods() {
        Hashtable<Integer, InterestPeriod> periods = new Hashtable<Integer, InterestPeriod>();
        JSONParser parser = new JSONParser();

        try {
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("periods.json"));

            JSONArray arr = (JSONArray) jsonObject.get("periods");
            for (JSONObject period : (Iterable<JSONObject>) arr) {
                String start = period.get("start").toString();
                DateTime startDate = DateTime.parse(start, DateTimeFormat.forPattern("yyyy-MM-dd"));

                String end = period.get("start").toString();
                DateTime endDate = DateTime.now();
                if (!end.equals("NOW")) {
                    endDate = DateTime.parse(end, DateTimeFormat.forPattern("yyyy-MM-dd"));
                }

                Double interestRate = Double.parseDouble((String)period.get("interestRate"));

                Integer seq = Integer.parseInt((String)period.get("seq"));

                InterestPeriod interestPeriod = new InterestPeriod(seq, startDate, endDate, interestRate);
                periods.put(seq, interestPeriod);
            }

        } catch (FileNotFoundException e) {
            System.out.println("No file found");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return periods;
    }

}
