package at.fhv.pme.tyme.common.services;

import java.util.List;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

public class UML2Services {

	/**
	 * Check if an element has the passed stereotype
	 * @param element
	 * @param stereotypeName
	 * @return
	 */
	public boolean hasStereotype(Element element, String stereotypeName) {
		List<Stereotype> stereotypes = element.getAppliedStereotypes();
		for(Stereotype stereotype : stereotypes) {
			if(stereotype.getName().equals(stereotypeName)) {
				return true;
			}
		}
		return false;
	}
}
