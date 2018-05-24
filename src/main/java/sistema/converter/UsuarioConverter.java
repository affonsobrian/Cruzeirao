package sistema.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sistema.bean.UsuarioMB;
import sistema.models.Usuario;

@FacesConverter("usuarioConverter")
public class UsuarioConverter implements Converter {
	UsuarioMB usuarioMB = new UsuarioMB();

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			for (Usuario usuario : usuarioMB.getUsuarios()) {
				if (usuario.getNome().equals(value)) {
					return usuario;
				}
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null && object instanceof Usuario) {
			return String.valueOf(((Usuario) object).getNome());
		}
		return null;
	}
}
