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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.modules.wiki.extractor.service.http.WikiContentServiceSoap}.
 *
 * @author Vilmos Papp
 * @see com.liferay.modules.wiki.extractor.service.http.WikiContentServiceSoap
 * @generated
 */
@ProviderType
public class WikiContentSoap implements Serializable {
	public static WikiContentSoap toSoapModel(WikiContent model) {
		WikiContentSoap soapModel = new WikiContentSoap();

		soapModel.setWikiId(model.getWikiId());

		return soapModel;
	}

	public static WikiContentSoap[] toSoapModels(WikiContent[] models) {
		WikiContentSoap[] soapModels = new WikiContentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WikiContentSoap[][] toSoapModels(WikiContent[][] models) {
		WikiContentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WikiContentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WikiContentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WikiContentSoap[] toSoapModels(List<WikiContent> models) {
		List<WikiContentSoap> soapModels = new ArrayList<WikiContentSoap>(models.size());

		for (WikiContent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WikiContentSoap[soapModels.size()]);
	}

	public WikiContentSoap() {
	}

	public long getPrimaryKey() {
		return _wikiId;
	}

	public void setPrimaryKey(long pk) {
		setWikiId(pk);
	}

	public long getWikiId() {
		return _wikiId;
	}

	public void setWikiId(long wikiId) {
		_wikiId = wikiId;
	}

	private long _wikiId;
}