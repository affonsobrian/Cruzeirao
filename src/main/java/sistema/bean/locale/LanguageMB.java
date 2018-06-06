package sistema.bean.locale;

import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class LanguageMB {
	
	private Locale locale = Locale.ENGLISH;
	
	public void changeLang()
	{
		System.out.println("Changing...");
		if(locale == Locale.ENGLISH)
			FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("pt"));
		else
			FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.ENGLISH);
	}
}
