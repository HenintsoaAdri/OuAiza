package traitement;

import javax.servlet.http.HttpServletRequest;

public class Traitement {
//	static String URL = "https://ou-aiza.herokuapp.com/";
	static String URL = "http://localhost:8085/OuAiza/";
	static String internUrl = "/OuAiza/";
	static String signature = "OuAizaAntsaAdri";
	static String imgUrl = "/IMG-OuAiza/";
        static String mailUrl = "localhost";
        static String smtpUrl = "mail.smtp.host";
	public static String getURL() {
		return URL;
	}
	public static String getSignature() {
		return signature;
	}
	public static String getInternUrl() {
		return internUrl;
	}
	public static String getImgUrl() {
		return imgUrl;
	}
        public static String getMailUrl() {
            return mailUrl;
        }
        public static String getSmtpUrl() {
            return smtpUrl;
        }
	public static String extractToken(HttpServletRequest request)throws Exception{
		String header = request.getHeader("Authorization");
		if(header.startsWith("Bearer")){
			return header.split(" ")[1];
		}
		throw new Exception("Cet header ne contient aucun token");
	}
	
}
