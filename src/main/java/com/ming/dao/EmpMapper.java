package com.ming.dao;

import com.ming.model.Emp;
import com.ming.model.EmpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper {

    List<Emp> getEmpList();

    long countByExample(EmpExample example);

    int deleteByExample(EmpExample example);

    int deleteByPrimaryKey(Integer empId);

    int insert(Emp record);

    int insertSelective(Emp record);

    List<Emp> selectByExample(EmpExample example);

    Emp selectByPrimaryKey(Integer empId);

    int updateByExampleSelective(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByExample(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);

    void deleteEmpBatch(List<String> ids);
}