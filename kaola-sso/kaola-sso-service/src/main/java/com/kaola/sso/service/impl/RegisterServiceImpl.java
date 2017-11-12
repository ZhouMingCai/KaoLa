package com.kaola.sso.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.kaola.common.utils.KLResult;
import com.kaola.dao.TbUserDao;
import com.kaola.pojo.TbUser;
import com.kaola.sso.service.RegisterService;


/**
 * 用户注册处理Service
 * <p>Title: RegisterServiceImpl</p>
 * <p>Description: </p>
 * @version 1.0
 */

@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	private TbUserDao userDao;

	@Override
	public KLResult checkData(String param, int type) {
		////1：用户名 2：手机号 3：邮箱
		List<TbUser> list = null;
		if (type == 1){
			 list = userDao.queryByUser(param,null,null);
		}else if (type == 2){
			list = userDao.queryByUser(null,param,null);
		}else if (type == 3){
			list = userDao.queryByUser(null,null,param);
		}else {
			return KLResult.build(400,"数据类型错误");
		}
		//判断结果中是否包含数据
		if (list != null && list.size()>0) {
			//如果有数据返回false
			return KLResult.ok(false);
		}
		//如果没有数据返回true
		return KLResult.ok(true);
	}

	@Override
	public KLResult register(TbUser user) {
		//数据有效性校验
		if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword()) 
				|| StringUtils.isBlank(user.getPhone())) {
			return KLResult.build(400, "用户数据不完整，注册失败");
		}
		//1：用户名 2：手机号 3：邮箱
		KLResult result = checkData(user.getUsername(), 1);
		if (!(boolean) result.getData()) {
			return KLResult.build(400, "此用户名已经被占用");
		}
		result = checkData(user.getPhone(), 2);
		if (!(boolean)result.getData()) {
			return KLResult.build(400, "手机号已经被占用");
		}
		//补全pojo的属性
		user.setCreated(new Date());
		user.setUpdated(new Date());
		//对密码进行md5加密
		String md5Pass = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		user.setPassword(md5Pass);
		//把用户数据插入到数据库中
		userDao.insert(user);
		//返回添加成功
		return KLResult.ok();
	}

	

}
