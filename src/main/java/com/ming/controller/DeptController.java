package com.ming.controller;

import com.ming.model.Dept;
import com.ming.model.Message;
import com.ming.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/dept")
@Controller
public class DeptController {

    @Autowired
    private IDeptService iDeptService;


    @RequestMapping("/getDeptList")
    @ResponseBody
    public Message getDeptList(){
        List<Dept> deptList = iDeptService.getDeptList();
        Map<String,Object> deptMap = new HashMap<String, Object>();
        deptMap.put("deptList",deptList);
        Message message = new Message(100,"部门信息查询成功",deptMap);
        return message;
    }
}
