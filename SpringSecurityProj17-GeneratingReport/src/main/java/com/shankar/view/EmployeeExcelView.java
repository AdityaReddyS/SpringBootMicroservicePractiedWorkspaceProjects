package com.shankar.view;

import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;import org.springframework.boot.autoconfigure.condition.ConditionMessage.Style;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.shankar.model.Employee;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component("excelreport")
public class EmployeeExcelView  extends AbstractXlsView{
int i=0;
	@Override
	public void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
	System.out.println("EmployeeExcelView.buildExcelDocument()");
	//get model attribute data
			Iterable<Employee> empsList=(Iterable<Employee>)map.get("empsList");
			//create sheet
			Sheet sheet1=workbook.createSheet("Sheet1");
			//add rows to the sheet
			empsList.forEach(emp->{
				//add row sheet represnting employee record
				Row row=sheet1.createRow(i);
				
				row.createCell(0).setCellValue(emp.getEmpno());
				row.createCell(1).setCellValue(emp.getEname());
				row.createCell(2).setCellValue(emp.getJob());
				row.createCell(3).setCellValue(emp.getSal());
				if(emp.getDeptno()!=null) {
				row.createCell(4).setCellValue(emp.getDeptno());
				}
				i++;
			});
	
	}
}
