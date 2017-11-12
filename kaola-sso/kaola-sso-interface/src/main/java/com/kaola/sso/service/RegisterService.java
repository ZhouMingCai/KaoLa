package com.kaola.sso.service;

import com.kaola.common.utils.KLResult;
import com.kaola.pojo.TbUser;


public interface RegisterService {

	KLResult checkData(String param, int type);
	KLResult register(TbUser user);
}
