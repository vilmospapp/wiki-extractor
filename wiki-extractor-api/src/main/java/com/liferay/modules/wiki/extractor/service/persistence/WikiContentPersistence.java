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

package com.liferay.modules.wiki.extractor.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.modules.wiki.extractor.exception.NoSuchWikiContentException;
import com.liferay.modules.wiki.extractor.model.WikiContent;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the wiki content service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Vilmos Papp
 * @see com.liferay.modules.wiki.extractor.service.persistence.impl.WikiContentPersistenceImpl
 * @see WikiContentUtil
 * @generated
 */
@ProviderType
public interface WikiContentPersistence extends BasePersistence<WikiContent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WikiContentUtil} to access the wiki content persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the wiki content in the entity cache if it is enabled.
	*
	* @param wikiContent the wiki content
	*/
	public void cacheResult(WikiContent wikiContent);

	/**
	* Caches the wiki contents in the entity cache if it is enabled.
	*
	* @param wikiContents the wiki contents
	*/
	public void cacheResult(java.util.List<WikiContent> wikiContents);

	/**
	* Creates a new wiki content with the primary key. Does not add the wiki content to the database.
	*
	* @param wikiId the primary key for the new wiki content
	* @return the new wiki content
	*/
	public WikiContent create(long wikiId);

	/**
	* Removes the wiki content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wikiId the primary key of the wiki content
	* @return the wiki content that was removed
	* @throws NoSuchWikiContentException if a wiki content with the primary key could not be found
	*/
	public WikiContent remove(long wikiId) throws NoSuchWikiContentException;

	public WikiContent updateImpl(WikiContent wikiContent);

	/**
	* Returns the wiki content with the primary key or throws a {@link NoSuchWikiContentException} if it could not be found.
	*
	* @param wikiId the primary key of the wiki content
	* @return the wiki content
	* @throws NoSuchWikiContentException if a wiki content with the primary key could not be found
	*/
	public WikiContent findByPrimaryKey(long wikiId)
		throws NoSuchWikiContentException;

	/**
	* Returns the wiki content with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param wikiId the primary key of the wiki content
	* @return the wiki content, or <code>null</code> if a wiki content with the primary key could not be found
	*/
	public WikiContent fetchByPrimaryKey(long wikiId);

	@Override
	public java.util.Map<java.io.Serializable, WikiContent> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the wiki contents.
	*
	* @return the wiki contents
	*/
	public java.util.List<WikiContent> findAll();

	/**
	* Returns a range of all the wiki contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WikiContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of wiki contents
	* @param end the upper bound of the range of wiki contents (not inclusive)
	* @return the range of wiki contents
	*/
	public java.util.List<WikiContent> findAll(int start, int end);

	/**
	* Returns an ordered range of all the wiki contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WikiContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of wiki contents
	* @param end the upper bound of the range of wiki contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of wiki contents
	*/
	public java.util.List<WikiContent> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WikiContent> orderByComparator);

	/**
	* Returns an ordered range of all the wiki contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WikiContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of wiki contents
	* @param end the upper bound of the range of wiki contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of wiki contents
	*/
	public java.util.List<WikiContent> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WikiContent> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the wiki contents from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of wiki contents.
	*
	* @return the number of wiki contents
	*/
	public int countAll();
}