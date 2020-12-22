package com.ming.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ming.model.Emp;
import com.ming.service.IEepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpContoller {

    @Autowired
    private IEepService iEepService;

    @RequestMapping("/getEmpList")
    public String getEmpList(HttpServletRequest request, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum, Model model) {
        PageHelper.startPage(pageNum,5);
        List<Emp> empList = iEepService.getEmpList();
        PageInfo pageInfo = new PageInfo(empList,5);
        model.addAttribute("pageInfo",pageInfo);
        return "empList";
    }
}
