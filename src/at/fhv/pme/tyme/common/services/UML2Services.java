package at.fhv.pme.tyme.common.services;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
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
	

	/**
	 * Get the package name as file path
	 * @param pakkage The package to convert
	 * @return The package name as file path
	 */
	public String toPath(Namespace pakkage) {
		return pakkage.getName().replace(".", File.separator) + File.separator;
	}

	/**
	 * Convert a multine string correctly to a java multine line string
	 * @param multiline The multiline string
	 * @return The converted string
	 */
	public String convertToMultiLineString(String multiline) {
		StringBuilder builder = new StringBuilder();
		try (Scanner scanner = new Scanner(multiline)) {
			while(scanner.hasNextLine()){
				builder.append("\"").append(scanner.nextLine()).append("\"+\n");
			}
		}
		
		// remove last line break
		builder.setLength(builder.length() - "\"+\n".length());
		
		// remove first "
		String substring =  builder.substring(1);
		
		// escape \
		String escaped = substring.replace("\\", "\\\\");
		
		return escaped;
	}
	
	/**
	 * Return a list of parameters of an operation without the return type
	 * @param node
	 * @return
	 * @throws FactoryException
	 */
	public List<Parameter> getRealParameters(Operation operator) {
		List<Parameter> parListFiltered = new ArrayList<Parameter>();
		List<Parameter> parList = operator.getOwnedParameters();
		for (Iterator<Parameter> iterPar = parList.iterator(); iterPar.hasNext();) {
			Parameter par = (Parameter) iterPar.next();
			if (!par.getDirection().equals(ParameterDirectionKind.RETURN_LITERAL))
				parListFiltered.add(par);
		}
		return parListFiltered;		
	}
}
