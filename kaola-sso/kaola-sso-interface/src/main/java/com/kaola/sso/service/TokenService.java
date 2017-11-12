package com.kaola.sso.service;

import com.kaola.common.utils.KLResult;


/**
 * 根据token查询用户信息
 */
public interface TokenService {
	KLResult getUserByToken(String token);
}
