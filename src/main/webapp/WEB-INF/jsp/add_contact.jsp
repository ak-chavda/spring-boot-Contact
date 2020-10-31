<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
   <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <title>Add Contact</title>
   <style>
      .error {
         color: red;
      }

      body {
         width: 100%;
      }

      fieldset {
         position: block;
         height: 50%;
         width: 50%;
         background: #ffffff;

         margin-left: 300px;
         margin-top: 100px;
         text-align: center;
      }

      fieldset input {
         text-align: center;
         margin: 10px 10px 10px 10px;
      }

      table {
         margin: 0 auto 0 auto;
      }

      #content {
         text-align: center;
         margin-top: 10px;
      }

      #btn-grp {
         text-align: center;
         margin: 10px 10px 10px 50px;
      }
   </style>
   <script>

      function addRow() {
         var phTable = document.getElementById('phonebook');

         // deep clone the targeted row
         var new_row = phTable.rows[1].cloneNode(true);
         new_row.cells[0].getElementsByTagName('input')[0].value = "";

         // append the new row to the table
         phTable.appendChild(new_row);
      }

      function deleteRow(row) {
         // get row index for delete row
         var i = row.parentNode.parentNode.rowIndex;
         document.getElementById('phonebook').deleteRow(i);
      }

      function submitform() {
         var contactform = document.getElementById('contactform');
         var table = document.getElementById('phonebook');

         for (var i = 1; i < table.rows.length; i++) {
            var row = table.rows[i];
            var phInput = row.cells[0].getElementsByTagName('input')[0];

            phInput.name = "phonenumber[" + (i - 1) + "]";
            phInput.id = "phonenumber[" + (i - 1) + "]";
         }

         // submit form
         contactform.submit();
      }
   </script>
</head>

<body>
   <a href="/logout">Logout</a>
   <br />
   <a href="/all_contacts">View Contacts</a>

   <form action="process_addcontact" name="contactform" id="contactform" method="post">
      <fieldset>
         <legend>Add Contact</legend>
         <p class="error">${error}</p>

         <div id="content">
            Contact Name: <input type="text" name="name" id="name" /><br>
            Email id: <input type="text" name="emailid" id="emailid" /><br>

            <br />
            Phone No:
            <table id="phonebook">
               <tr>
                  <th>Phone NUmber</th>
                  <th>option</th>
               </tr>
               <tr>
                  <td><input type="text" name="phonenumber[0]" id="phonenumber" /></td>
                  <td><button type="button" onclick="addRow()"> +1</button></td>
                  <td><button type="button" onclick="deleteRow(this)">-1</button></td>
               </tr>
            </table>

            <div id="btn-grp">
               <button type="button" onclick="submitform()" value="Add Contact">Add Contact</button>
            </div>
         </div>
      </fieldset>
   </form>
</body>

</html>