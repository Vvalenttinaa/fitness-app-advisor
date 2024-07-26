<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="beans.MessageBean"%>
<%@ page errorPage="error.jsp" %>

<jsp:useBean id="userBean" class="beans.UserBean" scope="session"/>
<jsp:useBean id="messageService" class="services.MessageService" scope="application"/>

<%! MessageBean messageBean = new MessageBean(); %>
<!DOCTYPE html>
<%

    if (userBean.isLoggedIn()) {
        if (request.getParameter("id") != null) {
            try {
                Integer id = Integer.parseInt(request.getParameter("id"));
                messageBean = messageService.getById(id);
                messageService.changeStatus(id);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (request.getParameter("submit") != null) {
            System.out.println("Usao u submit");
            messageService.anwserQuestion(messageBean.getRecipientMail(), request.getParameter("answer"), messageBean.getContent());
            response.sendRedirect("home.jsp");
        } else if (request.getParameter("cancel") != null) {
            response.sendRedirect("home.jsp");
        }
    } else {
        response.sendRedirect("login.jsp");
    }
%>
<html>
<head>
    <title>Message</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    
    <script>
    function setRequired() {
        var content = document.getElementById("form4Example4").value;
        if (content.trim() === "") {
            alert("Answer field cannot be empty.");
            return false;
        }
        return true;
    }
    
        function sendEmail(event) {
            event.preventDefault();
       //     alert('Skripta');
            if(!setRequired()){
            	return;
            }
            var content = document.getElementById("form4Example4").value;
            alert("Content: " + content);
            var receiver = '<%= messageBean.getRecipientMail() %>';
           // alert(receiver);

            var formData = new FormData();
            formData.append("content", content);
            formData.append("receiver", receiver);

            var xhr = new XMLHttpRequest();
            xhr.open("POST", "http://localhost:8080/api/email", true);
     //       alert("Salje se mejl");

            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    alert("Email successfully sent!");
                    window.location.href = "home.jsp";
                } else if (xhr.readyState === 4) {
                    alert("Error sending email.");
                }
            };
            xhr.send(formData);
        }
    </script>
</head>
<body style="justify-content: center;align-items: center">
<%@include file="WEB-INF/header.jsp"%>
<div class="card-body">
    <div class="card-body">
        <form>
            <div class="form-outline mb-4">
                <label class="form-label" for="form4Example1">From</label>
                <input style="width: 250px" disabled type="text" id="form4Example1" value="<%= messageBean.getRecipientMail() %>" class="form-control"/>
            </div>
            <div class="form-outline mb-4">
                <label class="form-label" for="form4Example3">Received message</label>
                <textarea disabled class="form-control" id="form4Example3" rows="4"><%= messageBean.getContent() %></textarea>
            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="form4Example4">Answer</label>
                <textarea placeholder="Answer..." class="form-control" id="form4Example4" name="answer" rows="4"></textarea>
            </div>

            <div>
                <button type="submit" id="sendButton" name="submit" style="width: 80px" onclick="sendEmail(event)" class="btn btn-primary mb-4 d-inline-block">
                    Send
                </button>
                <button type="submit" name="cancel" id="cancelButton" style="width: 80px" class="btn btn-danger mb-4 d-inline-block">
                    Cancel
                </button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
