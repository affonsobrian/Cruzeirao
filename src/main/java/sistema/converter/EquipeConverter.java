package sistema.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sistema.models.Equipe;
import sistema.bean.EquipeMB;

@FacesConverter("equipeConverter")
public class EquipeConverter implements Converter {
	EquipeMB equipeMB = new EquipeMB();

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			for (Equipe equipe : equipeMB.getEquipes()) {
				if (equipe.getNome().equals(value)) {
					return equipe;
				}
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null && object instanceof Equipe) {
			return String.valueOf(((Equipe) object).getNome());
		}
		return null;
	}
}
