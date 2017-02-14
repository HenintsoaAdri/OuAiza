package traitement;

import javax.servlet.http.HttpServletRequest;

public class Traitement {
	static String URL = "https://ou-aiza.herokuapp.com/";
//	static String URL = "http://localhost:8085/OuAiza/";
        static String internUrl = "/";
//	static String internUrl = "/OuAiza/";
	static String signature = "OuAizaAntsaAdri";
	static String imgUrl = "http://img-ouaiza.comli.com/IMG-OuAiza/";
        static String mailUrl = "smtp.gmail.com";
        static String mailUser = "ouaiza.no.reply@gmail.com";
        static String mailPass = "Antsalol1";
        static String mailPort = "587";
        
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
        public static String getMailPort() {
            return mailPort;
        }
        
        public static String getMailUser() {
            return mailUser;
        }
        public static String getMailPass() {
            return mailPass;
        }
        
	public static String extractToken(HttpServletRequest request)throws Exception{
		String header = request.getHeader("Authorization");
		if(header.startsWith("Bearer")){
			return header.split(" ")[1];
		}
		throw new Exception("Cet header ne contient aucun token");
	}
	
}
