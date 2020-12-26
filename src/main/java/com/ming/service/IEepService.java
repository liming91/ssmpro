package com.ming.service;

import com.ming.model.Emp;

import java.util.List;

public interface IEepService {

    List<Emp> getEmpList();

    void deleteEmpBatch(List<String> ids);
}
