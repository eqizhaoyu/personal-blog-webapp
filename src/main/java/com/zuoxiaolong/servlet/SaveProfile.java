package com.zuoxiaolong.servlet;

import com.zuoxiaolong.config.Configuration;
import com.zuoxiaolong.dao.UserDao;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/*
 * Copyright 2002-2015 the original author or authors.
 *
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
 */

/**
 * @author 左潇龙
 * @since 2015年6月16日 上午12:05:05
 */
public class SaveProfile extends AbstractServlet {

	@Override
	protected void service() throws ServletException, IOException {
		if (!isLogin()) {
			throw new RuntimeException();
		}
		HttpServletRequest request = getRequest();
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String languageIdString = request.getParameter("languageId");
		Integer languageId = StringUtils.isBlank(languageIdString) ? null : Integer.valueOf(languageIdString);
		UserDao.updateProfile(getUsername(), province, city, languageId);
		getResponse().sendRedirect(Configuration.getSiteUrl("/common/user_center.ftl"));
	}

}
