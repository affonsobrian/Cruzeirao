package sistema.bean.locale;

import java.awt.event.ActionEvent;
import java.util.Locale;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LocaleBean {

    private Locale locale = Locale.ENGLISH;
    private boolean renderPt = false;
    private boolean renderEn = true;
  
    public Locale getLocale() {
        return locale;
    }

    public String getLanguage() {
    	System.out.println("Language: " + locale.getLanguage());
        return locale.getLanguage();
    }

    public void setLanguage(String language) {
        locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }
    
    public void SetPortuguese(ActionEvent event) {
    	locale = new Locale("pt");
    	System.out.println("Setting Pt");
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }
    
    public void SetEnglish(ActionEvent event) {
    	locale = Locale.ENGLISH;
    	System.out.println("Setting En");
    	FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }
    
    public boolean getrenderPt() {
    	System.out.println("Render Pt:");
    	System.out.println(FacesContext.getCurrentInstance().getViewRoot().getLocale() != Locale.ENGLISH);
    	if(FacesContext.getCurrentInstance().getViewRoot().getLocale() == Locale.ENGLISH)
    		return false;
    	else
    		return true;
    }
    
    public boolean getrenderEn() {
    	System.out.println("Render En:");
    	System.out.println(FacesContext.getCurrentInstance().getViewRoot().getLocale() == Locale.ENGLISH);
    	if(FacesContext.getCurrentInstance().getViewRoot().getLocale() == Locale.ENGLISH)
    		return true;
    	else
    		return false;
    }

}