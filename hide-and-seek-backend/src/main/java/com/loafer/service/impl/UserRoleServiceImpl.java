package com.loafer.service.impl;

import com.loafer.model.UserRole;
import com.loafer.mapper.UserRoleMapper;
import com.loafer.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author loafer
 * @since 2023-07-29
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
