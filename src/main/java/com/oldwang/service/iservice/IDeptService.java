package com.oldwang.service.iservice;

import com.oldwang.common.Res;
import com.oldwang.dao.entity.Dept;

import java.util.List;

public interface IDeptService {
    Res<List<Dept>> findAll();
}
