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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link WikiContent}.
 * </p>
 *
 * @author Vilmos Papp
 * @see WikiContent
 * @generated
 */
@ProviderType
public class WikiContentWrapper implements WikiContent,
	ModelWrapper<WikiContent> {
	public WikiContentWrapper(WikiContent wikiContent) {
		_wikiContent = wikiContent;
	}

	@Override
	public Class<?> getModelClass() {
		return WikiContent.class;
	}

	@Override
	public String getModelClassName() {
		return WikiContent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("wikiId", getWikiId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long wikiId = (Long)attributes.get("wikiId");

		if (wikiId != null) {
			setWikiId(wikiId);
		}
	}

	@Override
	public WikiContent toEscapedModel() {
		return new WikiContentWrapper(_wikiContent.toEscapedModel());
	}

	@Override
	public WikiContent toUnescapedModel() {
		return new WikiContentWrapper(_wikiContent.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _wikiContent.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _wikiContent.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _wikiContent.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _wikiContent.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<WikiContent> toCacheModel() {
		return _wikiContent.toCacheModel();
	}

	@Override
	public int compareTo(WikiContent wikiContent) {
		return _wikiContent.compareTo(wikiContent);
	}

	@Override
	public int hashCode() {
		return _wikiContent.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _wikiContent.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new WikiContentWrapper((WikiContent)_wikiContent.clone());
	}

	@Override
	public java.lang.String toString() {
		return _wikiContent.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _wikiContent.toXmlString();
	}

	/**
	* Returns the primary key of this wiki content.
	*
	* @return the primary key of this wiki content
	*/
	@Override
	public long getPrimaryKey() {
		return _wikiContent.getPrimaryKey();
	}

	/**
	* Returns the wiki ID of this wiki content.
	*
	* @return the wiki ID of this wiki content
	*/
	@Override
	public long getWikiId() {
		return _wikiContent.getWikiId();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_wikiContent.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_wikiContent.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_wikiContent.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_wikiContent.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_wikiContent.setNew(n);
	}

	/**
	* Sets the primary key of this wiki content.
	*
	* @param primaryKey the primary key of this wiki content
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_wikiContent.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_wikiContent.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the wiki ID of this wiki content.
	*
	* @param wikiId the wiki ID of this wiki content
	*/
	@Override
	public void setWikiId(long wikiId) {
		_wikiContent.setWikiId(wikiId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WikiContentWrapper)) {
			return false;
		}

		WikiContentWrapper wikiContentWrapper = (WikiContentWrapper)obj;

		if (Objects.equals(_wikiContent, wikiContentWrapper._wikiContent)) {
			return true;
		}

		return false;
	}

	@Override
	public WikiContent getWrappedModel() {
		return _wikiContent;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _wikiContent.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _wikiContent.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_wikiContent.resetOriginalValues();
	}

	private final WikiContent _wikiContent;
}