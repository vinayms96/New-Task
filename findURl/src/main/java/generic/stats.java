package generic;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class stats {

	public static List<String> statCode(List<String> url) {
		URL links;
		String stMsg;
		int stCode;
		List<String> status = new ArrayList<>();
		HttpURLConnection httpConnect;
		for (int i = 0; i < url.size(); i++) {
			try {
				links = new URL(url.get(i));
				httpConnect = (HttpURLConnection) links.openConnection();
				stCode = httpConnect.getResponseCode();
				stMsg = httpConnect.getResponseMessage();
				String total = stCode+" : "+stMsg;
				status.add(total);
				httpConnect.disconnect();
				System.out.println("Stat: "+url.get(i)+" : "+stCode+"("+stMsg+")");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return status;
	}

	public static List<String> statMsg(List<String> url) {
		URL links;
		List<String> stMsg = new ArrayList<>();
		HttpURLConnection httpConnect;
		for (int i = 0; i < url.size(); i++) {
			try {
				links = new URL(url.get(i));
				httpConnect = (HttpURLConnection) links.openConnection();
				stMsg.add(httpConnect.getResponseMessage());
				httpConnect.disconnect();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return stMsg;
	}
}
