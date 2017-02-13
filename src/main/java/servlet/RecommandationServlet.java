package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.MimeType;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.*;

import model.Profil;
import model.Recommandation;
import traitement.*;

@MultipartConfig(maxFileSize = 5000 * 1024)

public class RecommandationServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setHeader("Access-Control-Allow-Origin", "*");
		res.setContentType("text/plain");
		PrintWriter out = res.getWriter();
		if(req.getParameter("offset")!=null){
				try {
					Vector<Recommandation> vect = TraitementRecommandation.getRecommandation(Integer.parseInt(req.getParameter("offset")));
						JSONArray liste = new JSONArray();
						for(int i=0; i<vect.size();i++){
							liste.put(new JSONObject(vect.get(i)));
						}
						out.println(liste);
				} catch (Exception e) {
					e.printStackTrace();
					out.print(e.getMessage());
				}
		}else if(req.getParameter("get")!=null){
			try{
				Recommandation recommandation = TraitementRecommandation.getRecommandation(req.getParameter("get"));
				out.println(new JSONObject(recommandation));
			} catch(Exception e){
				e.printStackTrace();
				out.println(e.getMessage());
			}
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		Profil p = (Profil)req.getSession().getAttribute("Profil");
                try {
                        p = TraitementProfil.checkToken(Traitement.extractToken(req));
                } catch (Exception e) {e.printStackTrace();}
		PrintWriter out = resp.getWriter();
                String name = "default.jpg";
		if(p != null){
                    try{
                        try{
                            FileOutputStream output = null;
                            InputStream upload = null;
                            String path = "recommandation";
                            name = LocalDate.now() + req.getParameter("nomFichier") + p.getIdentifiant() + LocalTime.now().getNano();
                            if(ServletFileUpload.isMultipartContent(req)){
                                try{
                                    Part fichier = req.getPart("imageRecommandation");
                                    
                                    String type = fichier.getContentType();
                                    String extension = new MimeType(type).getSubType();
                                    name+="."+extension;
                                    String fullName = Traitement.getImgUrl() + path + File.separator + name;
                                    File file = new File(fullName);
                                    file.createNewFile();
                                    output = new FileOutputStream(file, false);
                                    upload = fichier.getInputStream();
                                    int read = 0;
                                    byte[] bytes = new byte[1024];
                                    while ((read = upload.read(bytes)) != -1) {
                                        output.write(bytes, 0, read);
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
                        }catch(Exception e){
                            
                        }
                        String idLieu = req.getParameter("id");
                        String description = req.getParameter("description");
                        TraitementRecommandation.insert(idLieu, p, description, name);
                        resp.sendRedirect(Traitement.getInternUrl()+"Lieu/");
                    }catch(Exception e){
                        
                    }
		}
	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Headers", "Authorization");
	}
}
