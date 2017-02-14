package servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import traitement.Traitement;

public class ImgMenuServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filename = "default.jpg";
		try{
			filename = "imgMenu/"+URLDecoder.decode(request.getPathInfo().substring(1), "UTF-8");
        }
        catch(Exception e){
        	filename = "default.jpg";
        }   
//            InputStream input = new URL(Traitement.getImgUrl()+"imgMenu/"+filename).openStream();
//	    File file = new File(Traitement.getImgUrl()+"imgMenu", filename);
//        if (!file.exists()) file = new File(Traitement.getImgUrl(), "default.jpg");
//        response.setHeader("Content-Type", getServletContext().getMimeType(filename));
//        response.setHeader("Content-Length", String.valueOf(file.length()));
//        response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
//        Files.copy(file.toPath(), response.getOutputStream());
        InputStream input = new URL(Traitement.getImgUrl()+filename).openStream();
                            int read = 0;
                         byte[] bytes = new byte[1024];
                        while ((read = input.read(bytes)) != -1) {
		            response.getOutputStream().write(bytes, 0, read);
		        } 
	}
	
	
}
