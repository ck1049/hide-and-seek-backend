package com.loafer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.loafer.mapper.UsersTokenMapper;
import com.loafer.model.UsersToken;
import com.loafer.service.ITokenService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author loafer
 * @since 2023-07-16
 */
@Service
public class TokenServiceImpl extends ServiceImpl<UsersTokenMapper, UsersToken> implements ITokenService {

}
