package org.wikidata.wdtk.rdf;

/*
 * #%L
 * Wikidata Toolkit RDF
 * %%
 * Copyright (C) 2014 Wikidata Toolkit Developers
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.wikidata.wdtk.datamodel.interfaces.PropertyIdValue;

/**
 * This class is in charge of mapping the values of some predefined string
 * properties to URIs of other RDF datasets that they refer to. This is useful
 * to convert string identifiers to proper RDF identifiers.
 * 
 * @author Markus Kroetzsch
 * 
 */
public class LinkedDataProperties {

	/**
	 * Returns the URI string that should be used to represent the given value
	 * of the given property, or null if it should just be used as it is.
	 * 
	 * @param property
	 *            the property that the value belongs to
	 * @param value
	 *            the string value
	 * @return
	 */
	public static String getUriForPropertyValue(PropertyIdValue property,
			String value) {
		switch (property.getId()) {
		case "P646":
			return getFreebaseUri(value);
		default:
			return null;
		}
	}

	/**
	 * Returns the Wikimedia Commons page URL for the given page name.
	 * 
	 * @param pageName
	 *            name of a page on Wikimedia Commons
	 * @return URL of the page
	 */
	public static String getCommonsUrl(String pageName) {
		return "http://commons.wikimedia.org/wiki/File:"
				+ pageName.replace(' ', '_');
	}

	/**
	 * Returns the Freebase URI for the given Freebase identifier.
	 * 
	 * @param value
	 *            Freebase identifier
	 * @return the Freebase URI
	 */
	static String getFreebaseUri(String value) {
		return "http://rdf.freebase.com/ns/"
				+ value.substring(1).replace('/', '.');
	}

}