package traitement;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.net.ftp.*;

public class TraitementFile {
    static String server = "files.000webhost.com";
    static String user = "img-ouaiza";
    static String pass = "Antsalol1!";
    static String defaut = "/public_html/IMG-OuAiza/default.jpg";
    static String globalPath = "/public_html/IMG-OuAiza/";
    static FTPClient ftp = null;
    public static void connexionFtp() throws Exception{
        try {
            if(ftp == null){
                ftp = new FTPClient();
                ftp.connect(server, 21);
                if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
                    ftp.disconnect();
                    throw new Exception("Exception in connecting to FTP Server");
                }
                ftp.login(user, pass);
                ftp.enterLocalPassiveMode();
                ftp.setFileType(FTP.BINARY_FILE_TYPE);
            }
        }catch(IOException e){
            e.printStackTrace();
            throw e;
        }
    }
    public static void showFile(OutputStream output, String dossier, String nomFichier) throws Exception{
        String file = globalPath + dossier + nomFichier;
        connexionFtp();
        if(!ftp.retrieveFile(file, output)){
            ftp.retrieveFile(defaut, output);
        }
    }
    public static void uploadFile(InputStream input, String dossier, String nomFichier ) throws Exception{
        try{
            String file = globalPath + dossier + nomFichier;
            connexionFtp();
            ftp.storeUniqueFile(file, input);
        } catch(Exception e){
            e.printStackTrace();
        }finally{
            input.close();
        	if (ftp.isConnected()) {
                ftp.logout();
                ftp.disconnect();
            }
        }
    }
}
