package org.wikidata.wdtk.dumpfiles;

/*
 * #%L
 * Wikidata Toolkit Dump File Handling
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

import org.json.JSONException;
import org.wikidata.wdtk.datamodel.interfaces.ItemDocument;

class ItemTestCase extends TestCase {

	ItemTestCase(String filePath, JsonConverter converter) {
		super(filePath, converter);
	}

	private ItemDocument result;

	@Override
	void convert() throws JSONException {
		this.result = this.converter.convertToItemDocument(this.json, "Q1");
	}

	ItemDocument getResult() {
		return this.result;
	}
}
