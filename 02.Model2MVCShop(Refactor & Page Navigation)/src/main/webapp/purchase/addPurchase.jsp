<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ page import="com.model2.mvc.service.domain.Purchase" %>    
<%@ page import="com.model2.mvc.service.domain.User" %>  

<%
  Purchase purchase = (Purchase)request.getAttribute("purchase");
  User user = (User)request.getAttribute("user");
  %>	    
<html>
<head>
<title>Insert title here</title>
</head>

<body>

<form name="updatePurchase" action="/updatePurchaseView.do?tranNo=0" method="post">

������ ���� ���Ű� �Ǿ����ϴ�.

<table border=1>
	<tr>
		<td>��ǰ��ȣ</td>
		<td><%=purchase.getProdNo() %></td>
		<td></td>
	</tr>
	<tr>
		<td>�����ھ��̵�</td>
		<td><%=user.getUserId() %></td>
		<td></td>
	</tr>
	<tr>
		<td>���Ź��</td>
		<td>
			<%if (purchase.getPaymentOption().equals("1"))  {%>
				���ݱ���
			<%}else{ %>
				�ſ뱸��
			<%} %>		
		</td>
		<td></td>
	</tr>
	<tr>
		<td>�������̸�</td>
		<td><%=purchase.getReceiverName() %></td>
		<td></td>
	</tr>
	<tr>
		<td>�����ڿ���ó</td>
		<td><%=purchase.getReceiverPhone() %></td>
		<td></td>
	</tr>
	<tr>
		<td>�������ּ�</td>
		<td><%=purchase.getDivyAddr() %></td>
		<td></td>
	</tr>
		<tr>
		<td>���ſ�û����</td>
		<td><%=purchase.getDivyRequest() %></td>
		<td></td>
	</tr>
	<tr>
		<td>����������</td>
		<td><%=purchase.getDivyDate() %></td>
		<td></td>
	</tr>
</table>
</form>

</body>
</html>