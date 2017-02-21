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
    static String defaut = "/IMG-OuAiza/default.jpg";
    static String globalPath = "/IMG-OuAiza/";
    public static FTPClient connexionFtp() throws Exception{
        FTPClient ftp = new FTPClient();
        try {
            ftp.connect(server, 21);
            ftp.login(user, pass);
            ftp.enterLocalPassiveMode();
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            return ftp;
        }catch(IOException e){
            e.printStackTrace();
            throw e;
        }finally{
            if (ftp.isConnected()) {
                ftp.logout();
                ftp.disconnect();
            }
        }
    }
    public static void showFile(OutputStream output, String dossier, String nomFichier) throws Exception{
        String file = globalPath + dossier + File.separator + nomFichier;
        FTPClient ftp = connexionFtp();
        if(!ftp.retrieveFile(file, output)){
            ftp.retrieveFile(defaut, output);
        }
    }
    public static void uploadFile(InputStream input, String dossier, String nomFichier ) throws Exception{
        try{
            String file = globalPath + dossier + File.separator + nomFichier;
            FTPClient ftp = connexionFtp();
            ftp.storeUniqueFile(file, input);
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            input.close();
        }
    }
}
