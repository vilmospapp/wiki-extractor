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

package com.liferay.modules.wiki.extractor.service.impl;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.liferay.document.library.kernel.service.DLFolderLocalService;
import com.liferay.modules.wiki.extractor.service.base.WikiContentServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;
import com.liferay.wiki.engine.impl.WikiEngineRenderer;
import com.liferay.wiki.model.WikiPage;
import com.liferay.wiki.service.WikiPageLocalService;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the wiki content remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.modules.wiki.extractor.service.WikiContentService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Vilmos Papp
 * @see WikiContentServiceBaseImpl
 * @see com.liferay.modules.wiki.extractor.service.WikiContentServiceUtil
 */
@ProviderType
public class WikiContentServiceImpl extends WikiContentServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.modules.wiki.extractor.service.WikiContentServiceUtil} to access the wiki content remote service.
	 */
	public String getRenderedWikiPage(
			String siteUrl, long plid, long groupId, long nodeId, String name)
		throws PortalException {

		WikiPage page = _wikiPageLocalService.getPage(nodeId, name, true);

		StringBundler sb = new StringBundler(8);

		sb.append(siteUrl);
		sb.append("/documents/portlet_file_entry/");
		sb.append(groupId);
		sb.append("/");

		String attachmentURLPrefix = sb.toString();

		long folderId = 0;
		DLFolder folder = _dlFolderLocalService.fetchFolder(
			groupId, page.getNodeAttachmentsFolderId(),
			String.valueOf(page.getResourcePrimKey()));

		if (folder != null) {
			folderId = folder.getFolderId();
		}

		try {
			String content =  _wikiEngineRenderer.convert(
				page, null, null, attachmentURLPrefix);

			return _postProcessHTMLContent(
				content, groupId, folderId, attachmentURLPrefix, plid);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	private String _postProcessHTMLContent(
		String content, long groupId, long folderId,
		String attachmentURLPrefix, long width) {

		if (folderId == 0) {
			return content;
		}

		StringBundler sb = new StringBundler();

		int idx = 0;
		int endIdx = 0;
		boolean start = true;

		while ((idx = content.indexOf(attachmentURLPrefix, idx)) > -1) {
			if (start) {
				sb.append(content.substring(0, idx));
				start = false;
			}

			if (endIdx > 0) {
				sb.append(content.substring(endIdx+1, idx));
			}

			endIdx = content.indexOf(CharPool.GREATER_THAN, idx);
			sb.append(content.substring(idx, endIdx-3));

			System.out.println("idx: " + idx + ", endidx: " + endIdx );

			String title = content.substring(idx+attachmentURLPrefix.length(), endIdx-3);

			System.out.println("Title: " + title);

			idx = endIdx;

			try {
				DLFileEntry entry = _dlFileEntryLocalService.getFileEntry(
					groupId, folderId, title);
				sb.append(StringPool.SLASH);
				sb.append(entry.getUuid());
				sb.append("\" width=\"");
				sb.append(width);
				sb.append("px\"/>");
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (endIdx < content.length()) {
			sb.append(content.substring(endIdx+1));
		}

		return sb.toString();
	}
	@ServiceReference(type = DLFolderLocalService.class)
	private DLFolderLocalService _dlFolderLocalService;

	@ServiceReference(type = DLFileEntryLocalService.class)
	private DLFileEntryLocalService _dlFileEntryLocalService;
	@ServiceReference(type = WikiEngineRenderer.class)
	private WikiEngineRenderer _wikiEngineRenderer;
	@ServiceReference(type = WikiPageLocalService.class)
	private WikiPageLocalService _wikiPageLocalService;

}