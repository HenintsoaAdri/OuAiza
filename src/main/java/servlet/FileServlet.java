package servlet;

import java.io.File;
import java.io.FileOutputStream;
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
import traitement.TraitementProfil;

@MultipartConfig(maxFileSize = 5000 * 1024)

public class FileServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter out = resp.getWriter();
	    FileOutputStream output = null;
	    InputStream upload = null;
		if(ServletFileUpload.isMultipartContent(request)){
			try{
                            String path = request.getParameter("path");
                            String name = request.getParameter("nomFichier");
                            Part fichier = request.getPart("photo");

                            String type = fichier.getContentType();
                            String extension = new MimeType(type).getSubType();
                            name+="."+extension;
                            File file = new File(Traitement.getImgUrl() + path + File.separator + name);
                            out.print(file.getAbsolutePath());
                            file.createNewFile();
                            output = new FileOutputStream(file, false);
                            upload = fichier.getInputStream();
                            int read = 0;
                            byte[] bytes = new byte[1024];
                            while ((read = upload.read(bytes)) != -1) {
		            output.write(bytes, 0, read);
		        }
				switch(path){
					case "imgProfil": 
						Profil p = (Profil)request.getSession().getAttribute("Profil");
						TraitementProfil.modifierPhoto(p, name);
						resp.sendRedirect(Traitement.getInternUrl()+"Profil/");
				}
			}catch(Exception e){
					out.print("Fichier non t\u00e9l\u00e9charg\u00e9 !");
					e.printStackTrace();
			}finally{
				out.close();
				if(output != null){
					output.close();
				}
				if(upload != null){
					upload.close();
				}
			}
		}
		else{
			try {
				throw new Exception("Aucun fichier \u00e0 t\u00e9l\u00e9charger !");
			} catch (Exception e) {
				e.printStackTrace();
				out.println(e);
			}
		}
	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Headers", "Authorization");
	}

}
