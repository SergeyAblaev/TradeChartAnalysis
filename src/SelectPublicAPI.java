import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class SelectPublicAPI {

    //запрос вернет ответ в Json
    // date1,2 - время UNIX в секундах!
    public String SSLconnect(Long date1, Long date2, String currencyPair, String command) throws Exception {
//		String answer="";
        String period="86400";
        String URLselect;
//		String URLselect1="poloniex.com";
        if (command.equals("returnTicker")) {
            URLselect="";
        } else {
            URLselect="https://poloniex.com/public?command="+command+"&currencyPair="+currencyPair+"&start="+date1+"&end="+date2+"&period="+period;  // =86400
        }

        URLConnection connection = new URL(URLselect).openConnection();
//		URLConnection connection = new URL("https://poloniex.com/public?command=returnChartData&currencyPair=USDT_BTC&start=1509709213&end=1511006245&period=86400").openConnection();

// +example!!
        InputStream is = connection.getInputStream();
        InputStreamReader reader = new InputStreamReader(is);
        char[] buffer = new char[256];
        int rc;

        StringBuilder sb = new StringBuilder();

        while ((rc = reader.read(buffer)) != -1)
            sb.append(buffer, 0, rc);

        reader.close();

//	    System.out.println(sb);	 // in strinbuilder = result Json from API !
// -example!!
        String JString = sb.toString();

        return JString;  //JSON answer
    }
	/*   !!!разберись куда перехват ошибки ставить!!!!
	catch (Exception e) {
		// TODO: handle exception
	}
	*/

}
