package com.ming.service.impl;

import com.ming.dao.DeptMapper;
import com.ming.model.Dept;
import com.ming.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements IDeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> getDeptList() {
        return deptMapper.selectByExample(null);
    }
}
