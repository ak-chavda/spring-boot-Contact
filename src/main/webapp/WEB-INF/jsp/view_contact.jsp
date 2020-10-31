<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>View Contacts</title>
	<script>
		function selectRow(x) {
			// alert("Row index is: " + x.rowIndex);
			var con = x.getElementsByTagName('input')[0];
			console.log("Value of hidden :" + con.getAttribute('value'));

			var con_id = document.getElementById('contactId');
			con_id.setAttribute('value', con.getAttribute('value'));
			console.log(con_id.getAttribute('value'));
			//  document.getElementById("edit_contact").submit();
		}

		function submitAction(button) {
			var txt = button.innerHTML;
			var form = document.getElementById("multiform");
			if (txt.indexOf("Update") > -1) {
				form.setAttribute('action', 'show_contact');
				form.submit();
			}
			else if (txt.indexOf("Delete") > -1) {
				form.setAttribute('action', 'delete_contact');
				form.submit();
			}
			else {
				console.log("Not Valid input");
			}
			console.log(txt);

		}

	</script>
	<style>
		.error {
			color: red;
		}

		table {
			font-family: arial, sans-serif;
			border-collapse: collapse;
			width: 50%;

		}

		td,
		th {
			border: 1px solid #dddddd;
			text-align: left;
			padding: 8px;
		}


		#contents {
			text-align: center;
		}

		.centered {
			margin: 100px auto;
		}

		a:hover {
			text-decoration: underline;
			color: blue;
		}
	</style>
</head>

<body>
	<a href="/logout">Logout</a>
	<br />
	<a href="/show_addcontact">Add Contact</a>

	<div id="contents">
		<p class="error">${error}</p>
		<div id="content">
			<table class="centered">
				<tr>
					<th>contact name</th>
					<th>Email Id</th>
					<th>Phone Number</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>

				<c:forEach items="${contacts}" var="contact">
					<tr>
						<input type="hidden" name="id" value=${contact.key} />
						<td>
							<input type="hidden" name="contact_id" value=${contact.key} />
							${contact.value.name}
						</td>

						<td>
							${contact.value.emailId}
						</td>

						<td>
							<c:forEach items="${contact.value.phList}" var="phone">
								<div>${phone}</div>
							</c:forEach>
						</td>

						<td>
							<a href="/edit_contact?id=${contact.key}">edit</a>
						</td>

						<td>
							<a href="/delete_contact?id=${contact.key}">delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>

</html>