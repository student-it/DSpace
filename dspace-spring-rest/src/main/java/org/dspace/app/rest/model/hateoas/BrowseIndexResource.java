/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.rest.model.hateoas;

import org.dspace.app.rest.model.BrowseIndexRest;
import org.dspace.app.rest.utils.Utils;

/**
 * Browse Index Rest HAL Resource. The HAL Resource wraps the REST Resource
 * adding support for the links and embedded resources
 * 
 * @author Andrea Bollini (andrea.bollini at 4science.it)
 *
 */
@RelNameDSpaceResource(BrowseIndexRest.NAME)
public class BrowseIndexResource extends DSpaceResource<BrowseIndexRest> {
	public BrowseIndexResource(BrowseIndexRest bix, Utils utils, String... rels) {
		super(bix, utils, rels);
		if (bix.isMetadataBrowse()) {
			add(utils.linkToSubResource(bix, BrowseIndexRest.ENTRIES));
		}
		add(utils.linkToSubResource(bix, BrowseIndexRest.ITEMS));
	}
}
