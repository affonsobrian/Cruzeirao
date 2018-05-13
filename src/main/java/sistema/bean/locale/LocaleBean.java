package sistema.bean.locale;

import java.util.Locale;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LocaleBean {

    private Locale locale = Locale.ENGLISH;
  
    public Locale getLocale() {
        return locale;
    }

    public String getLanguage() {
        return locale.getLanguage();
    }

    public void setLanguage(String language) {
        locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }
    
    public String setPortuguese() {
    	locale = new Locale("pt");
    	System.out.println("Setting Pt");
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
        return "./index.xhtml";
    }
    
    public String setEnglish() {
    	locale = Locale.ENGLISH;
    	System.out.println("Setting En");
    	FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    	return "./index.xhtml";
    }
    
    public boolean renderPt() {
    	System.out.println("Render Pt:");
    	System.out.println(FacesContext.getCurrentInstance().getViewRoot().getLocale() != Locale.ENGLISH);
    	if(FacesContext.getCurrentInstance().getViewRoot().getLocale() == Locale.ENGLISH)
    		return false;
    	else
    		return true;
    }
    
    public boolean renderEn() {
    	System.out.println("Render En:");
    	System.out.println(FacesContext.getCurrentInstance().getViewRoot().getLocale() == Locale.ENGLISH);
    	if(FacesContext.getCurrentInstance().getViewRoot().getLocale() == Locale.ENGLISH)
    		return true;
    	else
    		return false;
    }

}