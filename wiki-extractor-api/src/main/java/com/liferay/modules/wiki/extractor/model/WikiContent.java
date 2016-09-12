/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.modules.wiki.extractor.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the WikiContent service. Represents a row in the &quot;WikiExtractor_WikiContent&quot; database table, with each column mapped to a property of this class.
 *
 * @author Vilmos Papp
 * @see WikiContentModel
 * @see com.liferay.modules.wiki.extractor.model.impl.WikiContentImpl
 * @see com.liferay.modules.wiki.extractor.model.impl.WikiContentModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.modules.wiki.extractor.model.impl.WikiContentImpl")
@ProviderType
public interface WikiContent extends WikiContentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.modules.wiki.extractor.model.impl.WikiContentImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<WikiContent, Long> WIKI_ID_ACCESSOR = new Accessor<WikiContent, Long>() {
			@Override
			public Long get(WikiContent wikiContent) {
				return wikiContent.getWikiId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<WikiContent> getTypeClass() {
				return WikiContent.class;
			}
		};
}