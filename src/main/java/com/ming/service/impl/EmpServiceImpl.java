package com.ming.service.impl;

import com.ming.dao.EmpMapper;
import com.ming.model.Emp;
import com.ming.service.IEepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpServiceImpl implements IEepService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Emp> getEmpList() {
        return empMapper.getEmpList();
    }

    @Override
    public void deleteEmpBatch(List<String> ids) {
        empMapper.deleteEmpBatch(ids);
    }
}
