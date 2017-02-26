package servlet;

import java.io.IOException;
import java.net.URLDecoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import traitement.TraitementFile;

public class ImgMenuServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
                    String filename = "default.jpg";
                    try{
                        filename = URLDecoder.decode(request.getPathInfo().substring(1), "UTF-8");
                    }
                    catch(Exception e){}
                    TraitementFile.showFile(response.getOutputStream(), "imgMenu/", filename);
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }finally{
                    response.getOutputStream().close();
                }
        }
}
