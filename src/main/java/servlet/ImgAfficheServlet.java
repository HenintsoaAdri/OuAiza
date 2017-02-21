package servlet;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import traitement.Traitement;
import traitement.TraitementFile;

public class ImgAfficheServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String filename = "default.jpg";
            try {
                try{
                    filename = URLDecoder.decode(request.getPathInfo().substring(1), "UTF-8");
                }
                catch(Exception e){}
                TraitementFile.showFile(response.getOutputStream(), "imgAffiche", filename);
            } catch (Exception ex) {
              ex.printStackTrace();
            } finally{
                response.getOutputStream().close();
            }
	}
	
	
}
