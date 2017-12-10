import apiDataSource.selectPublicAPI;

import java.util.Date;
//import org.json.*;
//import javax.print.Doc;

public class start {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Date DateNow = new Date();
        Long Date2= DateNow.getTime(); // UNIX time in millisec
        Long Date1=Date2-(1000L*60*60*24*30);	// - 30 day
        String currencyPair="USDT_BTC";
        String command="returnChartData";

        Date2=(Date2/1000);
        Date1=(Date1/1000);	// date in SECUND!
        selectPublicAPI MySelect = new selectPublicAPI();
        String MyJSONString = MySelect.SSLconnect(Date1, Date2, currencyPair, command);

        System.out.println(MyJSONString);	 // in MyJSONString = result string from Json from API !

        //JSONObject obj = new JSONObject();

        //ответ потом на АПИ  обработай: http://www.pyflux.com/	Time Series Made Easy

    }

}

