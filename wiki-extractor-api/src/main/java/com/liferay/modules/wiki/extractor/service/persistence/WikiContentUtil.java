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

import com.liferay.modules.wiki.extractor.model.WikiContent;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the wiki content service. This utility wraps {@link com.liferay.modules.wiki.extractor.service.persistence.impl.WikiContentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Vilmos Papp
 * @see WikiContentPersistence
 * @see com.liferay.modules.wiki.extractor.service.persistence.impl.WikiContentPersistenceImpl
 * @generated
 */
@ProviderType
public class WikiContentUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(WikiContent wikiContent) {
		getPersistence().clearCache(wikiContent);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<WikiContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WikiContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WikiContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WikiContent> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WikiContent update(WikiContent wikiContent) {
		return getPersistence().update(wikiContent);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WikiContent update(WikiContent wikiContent,
		ServiceContext serviceContext) {
		return getPersistence().update(wikiContent, serviceContext);
	}

	/**
	* Caches the wiki content in the entity cache if it is enabled.
	*
	* @param wikiContent the wiki content
	*/
	public static void cacheResult(WikiContent wikiContent) {
		getPersistence().cacheResult(wikiContent);
	}

	/**
	* Caches the wiki contents in the entity cache if it is enabled.
	*
	* @param wikiContents the wiki contents
	*/
	public static void cacheResult(List<WikiContent> wikiContents) {
		getPersistence().cacheResult(wikiContents);
	}

	/**
	* Creates a new wiki content with the primary key. Does not add the wiki content to the database.
	*
	* @param wikiId the primary key for the new wiki content
	* @return the new wiki content
	*/
	public static WikiContent create(long wikiId) {
		return getPersistence().create(wikiId);
	}

	/**
	* Removes the wiki content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wikiId the primary key of the wiki content
	* @return the wiki content that was removed
	* @throws NoSuchWikiContentException if a wiki content with the primary key could not be found
	*/
	public static WikiContent remove(long wikiId)
		throws com.liferay.modules.wiki.extractor.exception.NoSuchWikiContentException {
		return getPersistence().remove(wikiId);
	}

	public static WikiContent updateImpl(WikiContent wikiContent) {
		return getPersistence().updateImpl(wikiContent);
	}

	/**
	* Returns the wiki content with the primary key or throws a {@link NoSuchWikiContentException} if it could not be found.
	*
	* @param wikiId the primary key of the wiki content
	* @return the wiki content
	* @throws NoSuchWikiContentException if a wiki content with the primary key could not be found
	*/
	public static WikiContent findByPrimaryKey(long wikiId)
		throws com.liferay.modules.wiki.extractor.exception.NoSuchWikiContentException {
		return getPersistence().findByPrimaryKey(wikiId);
	}

	/**
	* Returns the wiki content with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param wikiId the primary key of the wiki content
	* @return the wiki content, or <code>null</code> if a wiki content with the primary key could not be found
	*/
	public static WikiContent fetchByPrimaryKey(long wikiId) {
		return getPersistence().fetchByPrimaryKey(wikiId);
	}

	public static java.util.Map<java.io.Serializable, WikiContent> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the wiki contents.
	*
	* @return the wiki contents
	*/
	public static List<WikiContent> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<WikiContent> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<WikiContent> findAll(int start, int end,
		OrderByComparator<WikiContent> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<WikiContent> findAll(int start, int end,
		OrderByComparator<WikiContent> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the wiki contents from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of wiki contents.
	*
	* @return the number of wiki contents
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static WikiContentPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WikiContentPersistence, WikiContentPersistence> _serviceTracker =
		ServiceTrackerFactory.open(WikiContentPersistence.class);
}