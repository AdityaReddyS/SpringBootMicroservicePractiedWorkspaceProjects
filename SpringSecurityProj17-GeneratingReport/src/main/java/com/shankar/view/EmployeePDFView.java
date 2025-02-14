package com.shankar.view;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.shankar.model.Employee;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("pdfreport")
public class EmployeePDFView  extends AbstractPdfView{

	@Override
	public void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter writer,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("EmployeePDFView.buildPdfDocument()");
		//get model attribute data
		Iterable<Employee> empsList=(Iterable<Employee>)map.get("empsList");
		//add paragraph
		Paragraph para=new Paragraph("Employee Report",new Font(null, Font.BOLD,10,new Color(255, 0, 0)));
		//document.add(para.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, new Color(255, 0, 0))));
		para.setAlignment("center");
	
		//document.add(para);
		//add table content
		Table table=new Table(5,((ArrayList)empsList).size());
		for(Employee emp:empsList) {
			table.addCell(String.valueOf(emp.getEmpno()));
			table.addCell(emp.getEname());
			table.addCell(emp.getJob());
			table.addCell(String.valueOf(emp.getSal()));
			table.addCell(String.valueOf(emp.getDeptno()));
		}
		document.add(table);
	}
}
