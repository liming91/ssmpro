package com.ming.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ming.dao.EmpMapper;
import com.ming.model.Emp;
import com.ming.model.Message;
import com.ming.service.IEepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private IEepService iEepService;

    @Autowired
    private EmpMapper empMapper;

    /**
     * 列表
     *
     * @param pageNum
     * @return 返回json格式数据
     */
    @RequestMapping(value = "/getEmpListPage", method = {RequestMethod.GET})
    @ResponseBody
    public Message getEmpPage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<Emp> li = iEepService.getEmpList();
        PageInfo pageInfo = new PageInfo(li, 10);
        Map<String, Object> pageInfoMap = new HashMap<String, Object>();
        pageInfoMap.put("pageInfo", pageInfo);
        Message message = new Message(100, "成功", pageInfoMap);
        return message;
    }

    /**
     * @param request
     * @param pageNum
     * @param model
     * @return 返回到页面
     */
    @RequestMapping(value = "/getEmpList", method = {RequestMethod.GET})
    public String getEmpList(HttpServletRequest request, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, Model model) {
        PageHelper.startPage(pageNum, 5);
        List<Emp> empList = iEepService.getEmpList();
        PageInfo pageInfo = new PageInfo(empList, 5);
        model.addAttribute("pageInfo", pageInfo);
        return "empList";
    }

    /**
     * 添加员工
     *
     * @param emp
     * @return
     */
    @RequestMapping(value = "/addEmp", method = {RequestMethod.POST})
    @ResponseBody
    public Message addEmp(@Valid Emp emp, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
            Map<String, Object> validMap = new HashMap<String, Object>();
            for (FieldError error : fieldErrorList) {
                System.out.println("JSR303==Valid==错误的字段:" + error.getField());
                System.out.println("JSR303==Valid==错误的信息:" + error.getDefaultMessage());
                validMap.put(error.getField(), error.getDefaultMessage());
            }
            Message message = new Message(200, "失败", validMap);
            return message;
        } else {
            int count = empMapper.insertSelective(emp);
            Message message = new Message(100, "成功", null);
            return message;
        }

    }

    /**
     * 根据id查询员工
     *
     * @param empId
     * @return
     */
    @RequestMapping(value = "/getEmpById/{empId}", method = {RequestMethod.GET})
    @ResponseBody
    public Message getEmpById(@PathVariable("empId") Integer empId) {
        Emp emp = empMapper.selectByPrimaryKey(empId);
        Map<String, Object> map = new HashMap<>();
        map.put("emp", emp);
        Message message = new Message(100, "员工查询成功", map);
        return message;
    }

    /**
     * 修改员工
     *
     * @param empID
     * @param emp
     * @return
     */
    @RequestMapping(value = "/updateEmp/{empId}", method = {RequestMethod.PUT})
    @ResponseBody
    public Message updateEmp(@PathVariable("empId") Integer empID, Emp emp) {
        empMapper.updateByPrimaryKeySelective(emp);
        Map<String, Object> map = new HashMap<>();
        map.put("emp", emp);
        Message message = new Message(100, "员工修改成功", map);
        return message;
    }

    /**
     * 批量删除
     *
     * @param empIDs
     * @return
     */
    @RequestMapping(value = "/deleteBatchEmp/{empIds}", method = {RequestMethod.DELETE})
    @ResponseBody
    public Message deleteBatchEmp(@PathVariable("empIds") String empIDs) {
        if (empIDs.contains("-")) {
            List<String> list = new ArrayList<>();
            String[] ids = empIDs.split("-");
            for (int i = 0; i < ids.length; i++) {
                list.add(ids[i]);
            }
            String idStr = toListStr(list);
            Map<String, Object> map = new HashMap<>();
            iEepService.deleteEmpBatch(list);
            Message message = new Message(100, "员工批量删除成功", map);
            return message;
        } else {
            int id = Integer.parseInt(empIDs);
            empMapper.deleteByPrimaryKey(id);
            Map<String, Object> map = new HashMap<>();
            Message message = new Message(100, "员工删除成功", map);
            return message;
        }
    }


    public String toListStr(List<String> ids) {
        String re = null;
        if (ids.size() > 0) {
            String str = ids.toString();
            if (str.contains(",")) {
                re = str.replace("[", "'").replace("]", "'").replaceAll(",","','");
                re = re.replaceAll(" ", "");

            } else {
                re = str;
            }
        }
        return re;
    }
}
