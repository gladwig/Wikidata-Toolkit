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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.wikidata.wdtk.datamodel.interfaces.EntityIdValue;
import org.wikidata.wdtk.datamodel.interfaces.PropertyIdValue;
import org.wikidata.wdtk.datamodel.interfaces.Statement;

/**
 * This class contains static methods and constants that define the various OWL
 * and RDF vocabularies that are used in the export.
 * 
 * @author Markus Kroetzsch
 * 
 */
public class Vocabulary {

	// Prefixes
	public static final String PREFIX_WIKIDATA = "http://www.wikidata.org/entity/";
	public static final String PREFIX_WBONTO = "http://www.wikidata.org/ontology#";
	public static final String PREFIX_RDF = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
	public static final String PREFIX_RDFS = "http://www.w3.org/2000/01/rdf-schema#";
	public static final String PREFIX_OWL = "http://www.w3.org/2002/07/owl#";
	public static final String PREFIX_XSD = "http://www.w3.org/2001/XMLSchema#";
	public static final String PREFIX_SCHEMA = "http://schema.org/";
	public static final String PREFIX_SKOS = "http://www.w3.org/2004/02/skos/core#";
	public static final String PREFIX_PROV = "http://www.w3.org/ns/prov#";

	// Vocabulary elements that are part of ontology language standards
	public static final String RDF_TYPE = PREFIX_RDF + "type";
	public static final String RDFS_LABEL = PREFIX_RDFS + "label";
	public static final String OWL_CLASS = PREFIX_OWL + "Class";
	public static final String OWL_OBJECT_PROPERTY = PREFIX_OWL
			+ "ObjectProperty";
	public static final String OWL_DATATYPE_PROPERTY = PREFIX_OWL
			+ "DatatypeProperty";

	/**
	 * Hash map defining the OWL declaration types of the standard vocabulary.
	 * Declaring this explicitly is useful to obtain a self-contained RDF file,
	 * even when importing ontologies that provide further details on some of
	 * the vocabulary.
	 */
	static final Map<String, String> VOCABULARY_TYPES = new HashMap<String, String>();

	// Vocabulary elements that are not declared by the ontology language

	/**
	 * Property "altLabel" of SKOS.
	 */
	public static final String SKOS_ALT_LABEL = PREFIX_SKOS + "altLabel";
	static {
		VOCABULARY_TYPES.put(SKOS_ALT_LABEL, OWL_DATATYPE_PROPERTY);
	}

	/**
	 * Property "about" of schema.org.
	 */
	public static final String SCHEMA_ABOUT = PREFIX_SCHEMA + "about";
	static {
		VOCABULARY_TYPES.put(SCHEMA_ABOUT, OWL_OBJECT_PROPERTY);
	}

	/**
	 * Property "description" of schema.org.
	 */
	public static final String SCHEMA_DESCRIPTION = PREFIX_SCHEMA
			+ "description";
	static {
		VOCABULARY_TYPES.put(SCHEMA_DESCRIPTION, OWL_DATATYPE_PROPERTY);
	}

	/**
	 * Property "inLanguage" of schema.org.
	 */
	public static final String SCHEMA_IN_LANGUAGE = PREFIX_SCHEMA
			+ "inLanguage";
	static {
		VOCABULARY_TYPES.put(SCHEMA_IN_LANGUAGE, OWL_DATATYPE_PROPERTY);
	}

	/**
	 * Property "wasDerivedFrom" of the provenance ontology.
	 */
	public static final String PROV_WAS_DERIVED_FROM = PREFIX_PROV
			+ "wasDerivedFrom";
	static {
		VOCABULARY_TYPES.put(PROV_WAS_DERIVED_FROM, OWL_OBJECT_PROPERTY);
	}

	// Wikibase ontology

	/**
	 * Class for Wikibase items.
	 */
	public static final String WB_ITEM = PREFIX_WBONTO + "Item";
	static {
		VOCABULARY_TYPES.put(WB_ITEM, OWL_CLASS);
	}

	/**
	 * Class for Wikibase properties.
	 */
	public static final String WB_PROPERTY = PREFIX_WBONTO + "Property";
	static {
		VOCABULARY_TYPES.put(WB_PROPERTY, OWL_CLASS);
	}

	/**
	 * Class for Wikibase statements.
	 */
	public static final String WB_STATEMENT = PREFIX_WBONTO + "Statement";
	static {
		VOCABULARY_TYPES.put(WB_STATEMENT, OWL_CLASS);
	}

	/**
	 * Property for defining the datatype of a Wikibase property.
	 */
	public static final String WB_PROPERTY_TYPE = PREFIX_WBONTO
			+ "propertyType";
	static {
		VOCABULARY_TYPES.put(WB_PROPERTY_TYPE, OWL_OBJECT_PROPERTY);
	}

	/**
	 * Property for defining the globe of a globe coordinates value.
	 */
	public static final String WB_GLOBE = PREFIX_WBONTO + "globe";
	static {
		VOCABULARY_TYPES.put(WB_GLOBE, OWL_OBJECT_PROPERTY);
	}

	/**
	 * Property for defining the latitude of a globe coordinates value.
	 */
	public static final String WB_LATITUDE = PREFIX_WBONTO + "latitude";
	static {
		VOCABULARY_TYPES.put(WB_LATITUDE, OWL_DATATYPE_PROPERTY);
	}

	/**
	 * Property for defining the longitude of a globe coordinates value.
	 */
	public static final String WB_LONGITUDE = PREFIX_WBONTO + "longitude";
	static {
		VOCABULARY_TYPES.put(WB_LONGITUDE, OWL_DATATYPE_PROPERTY);
	}

	/**
	 * Property for defining the precision of a globe coordinates value.
	 */
	public static final String WB_GC_PRECISION = PREFIX_WBONTO + "gcPrecision";
	static {
		VOCABULARY_TYPES.put(WB_GC_PRECISION, OWL_DATATYPE_PROPERTY);
	}

	/**
	 * Property for defining the time point of a time value.
	 */
	public static final String WB_TIME = PREFIX_WBONTO + "time";
	static {
		VOCABULARY_TYPES.put(WB_TIME, OWL_DATATYPE_PROPERTY);
	}

	/**
	 * Property for defining the precision of a time value.
	 */
	public static final String WB_TIME_PRECISION = PREFIX_WBONTO
			+ "timePrecision";
	static {
		VOCABULARY_TYPES.put(WB_TIME_PRECISION, OWL_DATATYPE_PROPERTY);
	}

	/**
	 * Property for defining the preferred calendar of a time value.
	 */
	public static final String WB_PREFERRED_CALENDAR = PREFIX_WBONTO
			+ "preferredCalendar";
	static {
		VOCABULARY_TYPES.put(WB_PREFERRED_CALENDAR, OWL_OBJECT_PROPERTY);
	}

	/**
	 * Returns a map that defines OWL types for all known vocabulary elements.
	 * 
	 * @return a map from vocabulary URIs to OWL type URIs
	 */
	public static Map<String, String> getKnownVocabularyTypes() {
		return Collections.unmodifiableMap(VOCABULARY_TYPES);
	}

	/**
	 * Get the URI for the given entity id.
	 * 
	 * @param entityIdValue
	 *            the entity id for which to create a URI
	 * @return the URI
	 */
	public static String getEntityUri(EntityIdValue entityIdValue) {
		return PREFIX_WIKIDATA + entityIdValue.getId();
	}

	/**
	 * Get the URI for the given statement.
	 * 
	 * @param statement
	 *            the statement for which to create a URI
	 * @return the URI
	 */
	public static String getStatementUri(Statement statement) {
		return PREFIX_WIKIDATA + statement.getStatementId();
	}

	/**
	 * Get the URI for the given property in the given context.
	 * 
	 * @param propertyIdValue
	 *            the property id for which to create a URI
	 * @param propertyContext
	 *            the context for which the URI will be needed
	 * @return the URI
	 */
	public static String getPropertyUri(PropertyIdValue propertyIdValue,
			PropertyContext propertyContext) {
		switch (propertyContext) {
		case STATEMENT:
			return PREFIX_WIKIDATA + propertyIdValue.getId() + "s";
		case VALUE:
			return PREFIX_WIKIDATA + propertyIdValue.getId() + "v";
		case QUALIFIER:
			return PREFIX_WIKIDATA + propertyIdValue.getId() + "q";
		case REFERENCE:
			return PREFIX_WIKIDATA + propertyIdValue.getId() + "r";
		default:
			return null;
		}
	}

}