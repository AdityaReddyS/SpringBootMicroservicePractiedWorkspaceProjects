package com.shankar.controller;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shankar.model.Employee;
import com.shankar.service.MgmtService;

@Controller
public class WishMessageController {
	@Autowired
	private MgmtService service;
	@RequestMapping("/")
	public String welcomePage() {
		return "welcome";
	}
@RequestMapping("/wish")
	public String showResponse(Map<String,Object> map) {
		String msg=service.generateWishMessage();
		map.put("resultMsg", msg);
		return "wish_message";
	}
/*//@RequestMapping(value="/report",method=RequestMethod.POST)
@GetMapping("/report")
public String showReport() {
	System.out.println("WishMessageController.showReport()");
	return "show_report";
}
@PostMapping("/report")
public String showReport1() {
	System.out.println("WishMessageController.showReport1()");
	return "show_report";
}*/
/*@RequestMapping("/report")
public String process(Map<String,Object> map) {
	map.put("name","raja");
	map.put("age", 30);
	return "show_report";
}*/
/*@RequestMapping("/report")
public String process(Map<String,Object> map) {
	map.put("favcolors",new String[] {"red","blue","green","orange"});
	map.put("nickNames",List.of("raja","nani","chinni","bunny"));
	map.put("phoneNumbers",Set.of(9505821965L,9701315057L,9949537276L) );
	map.put("idDetails",Map.of("Adhar Card",465684858207L,"voterid",123154949L,"Pan Card",9876543210L));
	return "show_report";
}*/
/*@RequestMapping("/report")
public String process(Map<String,Object> map) {
	Employee emp=new Employee();
	emp.setEno(new Random().nextInt(10000));
	emp.setEname("Shankar Reddy");
	emp.setEddrs("Hyderabad");
	emp.setSalary(10000.0);
	emp.setDept("SALES");
	map.put("EmpInfo", emp);
	return "show_report";
}*/
@RequestMapping("/report")
public String process(Map<String,Object> map) {
	List<Employee> empList=List.of(new Employee(1001,"raja","hyd",10000.0,"SALES"),
			new Employee(1002,"rajesh","delhi",40000.0,"MARKETING"),
			new Employee(1003,"suresh","hyd",100000.0,"SALES"),
			new Employee(1004,"suresh","hyd",100000.0,"SALES"),
			new Employee(1005,"suresh","hyd",100000.0,"SALES"));
	
	map.put("empListInfo", empList);
	return "show_report";
}
}
