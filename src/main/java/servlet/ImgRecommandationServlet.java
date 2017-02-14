package servlet;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import traitement.Traitement;

public class ImgRecommandationServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filename = "default.jpg";
		try{
			filename = URLDecoder.decode(request.getPathInfo().substring(1), "UTF-8");
        }
        catch(Exception e){
        	filename = "default.jpg";
        }
	    File file = new File(Traitement.getImgUrl()+"recommandation", filename);
        if (!file.exists()) file = new File(Traitement.getImgUrl(), "default.jpg");
        response.setHeader("Content-Type", getServletContext().getMimeType(filename));
        response.setHeader("Content-Length", String.valueOf(file.length()));
        response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
        Files.copy(file.toPath(), response.getOutputStream());
	}
	
	
}
