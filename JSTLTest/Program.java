

class Program{
public static void main(String[] args){
 var A = new com.cdac.met.EmployeeBean();
 A.setId("1001");
 A.setPassword("PWD1001");
 try{
 System.out.println(A.authenticate());
}catch (Exception e){}
}
}

