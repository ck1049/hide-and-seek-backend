package com.loafer.service.impl;

import com.loafer.model.Role;
import com.loafer.mapper.RoleMapper;
import com.loafer.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author loafer
 * @since 2023-07-29
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
