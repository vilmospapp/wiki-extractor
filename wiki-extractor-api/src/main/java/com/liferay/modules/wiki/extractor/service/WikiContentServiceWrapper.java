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

package com.liferay.modules.wiki.extractor.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link WikiContentService}.
 *
 * @author Vilmos Papp
 * @see WikiContentService
 * @generated
 */
@ProviderType
public class WikiContentServiceWrapper implements WikiContentService,
	ServiceWrapper<WikiContentService> {
	public WikiContentServiceWrapper(WikiContentService wikiContentService) {
		_wikiContentService = wikiContentService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _wikiContentService.getOSGiServiceIdentifier();
	}

	@Override
	public java.lang.String getRenderedWikiPage(java.lang.String siteUrl,
		long plid, long groupId, long nodeId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wikiContentService.getRenderedWikiPage(siteUrl, plid, groupId,
			nodeId, name);
	}

	@Override
	public WikiContentService getWrappedService() {
		return _wikiContentService;
	}

	@Override
	public void setWrappedService(WikiContentService wikiContentService) {
		_wikiContentService = wikiContentService;
	}

	private WikiContentService _wikiContentService;
}