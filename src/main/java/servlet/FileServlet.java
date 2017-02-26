package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.activation.MimeType;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Profil;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import traitement.Traitement;
import traitement.TraitementFile;
import traitement.TraitementProfil;

@MultipartConfig(maxFileSize = 5000 * 1024)

public class FileServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
            resp.setHeader("Access-Control-Allow-Origin", "*");
            PrintWriter out = resp.getWriter();
		if(ServletFileUpload.isMultipartContent(request)){
			try{
                            Part fichier = request.getPart("photo");

                            String type = fichier.getContentType();
                            String extension = new MimeType(type).getSubType();
                            String name = request.getParameter("nomFichier") + "." + extension;
                            
                            String path = request.getParameter("path");
                            InputStream input = fichier.getInputStream();
                            TraitementFile.uploadFile(input, path, name);
                            switch(path){
                                    case "imgProfil": 
                                            Profil p = (Profil)request.getSession().getAttribute("Profil");
                                            TraitementProfil.modifierPhoto(p, name);
                                            resp.sendRedirect(Traitement.getInternUrl()+"Profil/");
                                            break;
                                    
                            }
			}catch(Exception e){
					out.print("Fichier non t\u00e9l\u00e9charg\u00e9 !");
					e.printStackTrace();
			}finally{
                            out.close();
			}
		}
		else{
			try {
				throw new Exception("Aucun fichier \u00e0 t\u00e9l\u00e9charger !");
			} catch (Exception e) {
				e.printStackTrace();
				out.println(e);
			} finally{
                            out.close();
			}
		}
	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Headers", "Authorization");
	}

}
