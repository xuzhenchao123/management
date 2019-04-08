package com.people.management.controller;

import com.people.management.entity.Role;
import com.people.management.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = {"/role"})
public class RoleController {


    @Autowired
   public RoleService roleService;

    @ResponseBody
    @RequestMapping(value = {"/add"})
   public String add(){
       return "";
   }

   @RequestMapping(value = {"findAll"})
   public String selectAll(Model model){
       List<Role> roleList= roleService.selectAll();
       model.addAttribute("list",roleList);
      return "/role/roleList";
   }




}
