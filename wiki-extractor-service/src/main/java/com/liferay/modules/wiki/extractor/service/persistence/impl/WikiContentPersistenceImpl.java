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

package com.liferay.modules.wiki.extractor.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.modules.wiki.extractor.exception.NoSuchWikiContentException;
import com.liferay.modules.wiki.extractor.model.WikiContent;
import com.liferay.modules.wiki.extractor.model.impl.WikiContentImpl;
import com.liferay.modules.wiki.extractor.model.impl.WikiContentModelImpl;
import com.liferay.modules.wiki.extractor.service.persistence.WikiContentPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the wiki content service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Vilmos Papp
 * @see WikiContentPersistence
 * @see com.liferay.modules.wiki.extractor.service.persistence.WikiContentUtil
 * @generated
 */
@ProviderType
public class WikiContentPersistenceImpl extends BasePersistenceImpl<WikiContent>
	implements WikiContentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WikiContentUtil} to access the wiki content persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WikiContentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WikiContentModelImpl.ENTITY_CACHE_ENABLED,
			WikiContentModelImpl.FINDER_CACHE_ENABLED, WikiContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WikiContentModelImpl.ENTITY_CACHE_ENABLED,
			WikiContentModelImpl.FINDER_CACHE_ENABLED, WikiContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WikiContentModelImpl.ENTITY_CACHE_ENABLED,
			WikiContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public WikiContentPersistenceImpl() {
		setModelClass(WikiContent.class);
	}

	/**
	 * Caches the wiki content in the entity cache if it is enabled.
	 *
	 * @param wikiContent the wiki content
	 */
	@Override
	public void cacheResult(WikiContent wikiContent) {
		entityCache.putResult(WikiContentModelImpl.ENTITY_CACHE_ENABLED,
			WikiContentImpl.class, wikiContent.getPrimaryKey(), wikiContent);

		wikiContent.resetOriginalValues();
	}

	/**
	 * Caches the wiki contents in the entity cache if it is enabled.
	 *
	 * @param wikiContents the wiki contents
	 */
	@Override
	public void cacheResult(List<WikiContent> wikiContents) {
		for (WikiContent wikiContent : wikiContents) {
			if (entityCache.getResult(
						WikiContentModelImpl.ENTITY_CACHE_ENABLED,
						WikiContentImpl.class, wikiContent.getPrimaryKey()) == null) {
				cacheResult(wikiContent);
			}
			else {
				wikiContent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all wiki contents.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WikiContentImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the wiki content.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WikiContent wikiContent) {
		entityCache.removeResult(WikiContentModelImpl.ENTITY_CACHE_ENABLED,
			WikiContentImpl.class, wikiContent.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<WikiContent> wikiContents) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WikiContent wikiContent : wikiContents) {
			entityCache.removeResult(WikiContentModelImpl.ENTITY_CACHE_ENABLED,
				WikiContentImpl.class, wikiContent.getPrimaryKey());
		}
	}

	/**
	 * Creates a new wiki content with the primary key. Does not add the wiki content to the database.
	 *
	 * @param wikiId the primary key for the new wiki content
	 * @return the new wiki content
	 */
	@Override
	public WikiContent create(long wikiId) {
		WikiContent wikiContent = new WikiContentImpl();

		wikiContent.setNew(true);
		wikiContent.setPrimaryKey(wikiId);

		return wikiContent;
	}

	/**
	 * Removes the wiki content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param wikiId the primary key of the wiki content
	 * @return the wiki content that was removed
	 * @throws NoSuchWikiContentException if a wiki content with the primary key could not be found
	 */
	@Override
	public WikiContent remove(long wikiId) throws NoSuchWikiContentException {
		return remove((Serializable)wikiId);
	}

	/**
	 * Removes the wiki content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the wiki content
	 * @return the wiki content that was removed
	 * @throws NoSuchWikiContentException if a wiki content with the primary key could not be found
	 */
	@Override
	public WikiContent remove(Serializable primaryKey)
		throws NoSuchWikiContentException {
		Session session = null;

		try {
			session = openSession();

			WikiContent wikiContent = (WikiContent)session.get(WikiContentImpl.class,
					primaryKey);

			if (wikiContent == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWikiContentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(wikiContent);
		}
		catch (NoSuchWikiContentException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected WikiContent removeImpl(WikiContent wikiContent) {
		wikiContent = toUnwrappedModel(wikiContent);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(wikiContent)) {
				wikiContent = (WikiContent)session.get(WikiContentImpl.class,
						wikiContent.getPrimaryKeyObj());
			}

			if (wikiContent != null) {
				session.delete(wikiContent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (wikiContent != null) {
			clearCache(wikiContent);
		}

		return wikiContent;
	}

	@Override
	public WikiContent updateImpl(WikiContent wikiContent) {
		wikiContent = toUnwrappedModel(wikiContent);

		boolean isNew = wikiContent.isNew();

		Session session = null;

		try {
			session = openSession();

			if (wikiContent.isNew()) {
				session.save(wikiContent);

				wikiContent.setNew(false);
			}
			else {
				wikiContent = (WikiContent)session.merge(wikiContent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(WikiContentModelImpl.ENTITY_CACHE_ENABLED,
			WikiContentImpl.class, wikiContent.getPrimaryKey(), wikiContent,
			false);

		wikiContent.resetOriginalValues();

		return wikiContent;
	}

	protected WikiContent toUnwrappedModel(WikiContent wikiContent) {
		if (wikiContent instanceof WikiContentImpl) {
			return wikiContent;
		}

		WikiContentImpl wikiContentImpl = new WikiContentImpl();

		wikiContentImpl.setNew(wikiContent.isNew());
		wikiContentImpl.setPrimaryKey(wikiContent.getPrimaryKey());

		wikiContentImpl.setWikiId(wikiContent.getWikiId());

		return wikiContentImpl;
	}

	/**
	 * Returns the wiki content with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the wiki content
	 * @return the wiki content
	 * @throws NoSuchWikiContentException if a wiki content with the primary key could not be found
	 */
	@Override
	public WikiContent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWikiContentException {
		WikiContent wikiContent = fetchByPrimaryKey(primaryKey);

		if (wikiContent == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWikiContentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return wikiContent;
	}

	/**
	 * Returns the wiki content with the primary key or throws a {@link NoSuchWikiContentException} if it could not be found.
	 *
	 * @param wikiId the primary key of the wiki content
	 * @return the wiki content
	 * @throws NoSuchWikiContentException if a wiki content with the primary key could not be found
	 */
	@Override
	public WikiContent findByPrimaryKey(long wikiId)
		throws NoSuchWikiContentException {
		return findByPrimaryKey((Serializable)wikiId);
	}

	/**
	 * Returns the wiki content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the wiki content
	 * @return the wiki content, or <code>null</code> if a wiki content with the primary key could not be found
	 */
	@Override
	public WikiContent fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(WikiContentModelImpl.ENTITY_CACHE_ENABLED,
				WikiContentImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		WikiContent wikiContent = (WikiContent)serializable;

		if (wikiContent == null) {
			Session session = null;

			try {
				session = openSession();

				wikiContent = (WikiContent)session.get(WikiContentImpl.class,
						primaryKey);

				if (wikiContent != null) {
					cacheResult(wikiContent);
				}
				else {
					entityCache.putResult(WikiContentModelImpl.ENTITY_CACHE_ENABLED,
						WikiContentImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(WikiContentModelImpl.ENTITY_CACHE_ENABLED,
					WikiContentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return wikiContent;
	}

	/**
	 * Returns the wiki content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param wikiId the primary key of the wiki content
	 * @return the wiki content, or <code>null</code> if a wiki content with the primary key could not be found
	 */
	@Override
	public WikiContent fetchByPrimaryKey(long wikiId) {
		return fetchByPrimaryKey((Serializable)wikiId);
	}

	@Override
	public Map<Serializable, WikiContent> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, WikiContent> map = new HashMap<Serializable, WikiContent>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			WikiContent wikiContent = fetchByPrimaryKey(primaryKey);

			if (wikiContent != null) {
				map.put(primaryKey, wikiContent);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(WikiContentModelImpl.ENTITY_CACHE_ENABLED,
					WikiContentImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (WikiContent)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_WIKICONTENT_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (WikiContent wikiContent : (List<WikiContent>)q.list()) {
				map.put(wikiContent.getPrimaryKeyObj(), wikiContent);

				cacheResult(wikiContent);

				uncachedPrimaryKeys.remove(wikiContent.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(WikiContentModelImpl.ENTITY_CACHE_ENABLED,
					WikiContentImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the wiki contents.
	 *
	 * @return the wiki contents
	 */
	@Override
	public List<WikiContent> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<WikiContent> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<WikiContent> findAll(int start, int end,
		OrderByComparator<WikiContent> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<WikiContent> findAll(int start, int end,
		OrderByComparator<WikiContent> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<WikiContent> list = null;

		if (retrieveFromCache) {
			list = (List<WikiContent>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_WIKICONTENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WIKICONTENT;

				if (pagination) {
					sql = sql.concat(WikiContentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WikiContent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WikiContent>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the wiki contents from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WikiContent wikiContent : findAll()) {
			remove(wikiContent);
		}
	}

	/**
	 * Returns the number of wiki contents.
	 *
	 * @return the number of wiki contents
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WIKICONTENT);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return WikiContentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the wiki content persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(WikiContentImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_WIKICONTENT = "SELECT wikiContent FROM WikiContent wikiContent";
	private static final String _SQL_SELECT_WIKICONTENT_WHERE_PKS_IN = "SELECT wikiContent FROM WikiContent wikiContent WHERE wikiId IN (";
	private static final String _SQL_COUNT_WIKICONTENT = "SELECT COUNT(wikiContent) FROM WikiContent wikiContent";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wikiContent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WikiContent exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(WikiContentPersistenceImpl.class);
}