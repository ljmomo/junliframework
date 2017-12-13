package com.junli.system.service.impl;

import com.junli.system.entity.File;
import com.junli.system.dao.FileMapper;
import com.junli.system.service.FileService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文件上传 服务实现类
 * </p>
 *
 * @author lijun
 * @since 2017-11-30
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {

}
