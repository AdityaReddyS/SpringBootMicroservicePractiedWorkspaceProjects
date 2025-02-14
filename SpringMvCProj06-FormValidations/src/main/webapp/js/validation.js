function doValidation(frm){
	alert(1);
	
	//empty and old form validation logics
	document.getElementbyId("enameErr").innerHTML="";
	document.getElementbyId("jobErr").innerHTML="";
	document.getElementbyId("salErr").innerHTML="";
	document.getElementbyId("deptnoErr").innerHTML="";
	
	//read the form comp values
	alert(2);
	let name=frm.ename.value;
	let desg=frm.job.value;
	let salary=frm.sal.value;
	let deptno=frm.deptno.value;
	frm.vflag1.value="yes";
	
	let vflag=true;
	//write the clent side form validations
	if(name==""){
		document.getElementById("enameErr").innerHTML="Employee Name is Mandatory(cs)";
	vflag=false;
	}
	else if(name.length>5 || name.length<15){
		document.getElementById("enameErr").innerHTML="Employee Name Must be >=5 Chars to <=15 Chars (cs)";
		vflag=false;
	}
	if(desg==""){
		document.getElementById("jobErr").innerHTML="Employee Job is Mandatory (cs)";
	vflag=false;
	}
	else if(desg.length>5 || desg.length<20){
		document.getElementById("jobErr").innerHTML="Employee Job Must be >=5 Chars to <=20 Chars(cs)";
		vflag=false;
	}
	if(sal==""){
		document.getElementById("salErr").innerHTML="Employee Salary is Mandatory (cs)";
	vflag=false;
	}
	else if(isNaN(salary)){
			document.getElementById("salErr").innerHTML="Employee Salary Must be Numeric Value (cs)";
	vflag=false;
	}
	else if(salary<5000 || salary>1005000){
		document.getElementById("salErr").innerHTML="Employee Salary Must be <=5000 to salary>1005000 (cs)";
		vflag=false;
	}if(deptno==""){
		document.getElementById("deptnoErr").innerHTML="Employee Deptno is Mandatory (cs)";
	vflag=false;
	}
	return vflag;
}