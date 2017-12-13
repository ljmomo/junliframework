package com.junli.system.service.impl;

import com.junli.system.entity.Task;
import com.junli.system.dao.TaskMapper;
import com.junli.system.service.TaskService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lijun
 * @since 2017-11-30
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {

}
