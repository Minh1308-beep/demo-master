<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!-- using JSTL -->
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap CRUD Data Table for Database with Modal Form</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="css/admin.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>  
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script src="js/script.js"></script>

  <body>
    <!-- Header HTML -->
    <div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="#">Admin Dashboard</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
			  <span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
			  <ul class="navbar-nav">
				<li class="nav-item">
				  <a class="nav-link" href="#">Products</a>
				</li>
				<li class="nav-item">
				  <a class="nav-link" href="#">Categories</a>
				</li>
				<li class="nav-item">
				  <a class="nav-link" href="#">Another Page</a>
				</li>
			  </ul>
			</div>
		  </nav>
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
						<h2>Manage <b>Products</b></h2>
					</div>
                </div>
            </div>
        </div>
        <div id="editEmployeeForm" class="employee-form">
            <form action="editProduct" method="post">
                <h2>Edit Employee</h2>
                <div class="form-group">
                    <label>ID</label>
                    <input value="${detail.id}" type="text" name="id" class="form-control" style="font-size: 16px;" readonly>
                </div>
                <div class="form-group">
                    <label>Name</label>
                    <input value="${detail.name}" type="text" name="name" class="form-control" style="font-size: 16px;" required>
                </div>
                <div class="form-group">
                    <label>Price</label>
                    <input value="${detail.price}" type="text" name="price" class="form-control" style="font-size: 16px;" required>
                </div>
                <div class="form-group">
                    <label>Image</label>
                    <textarea name="image" class="form-control" style="font-size: 16px;" required>${detail.image}</textarea>
                </div>
                <div class="form-group">
                    <label>Category</label>
                    <select name="category" aria-label="Default select example" class="form-select">
                        <c:forEach items="${listCC}" var="c">
                            <option value="${c.cid}">${c.cname}</option>
                        </c:forEach>
                    </select>
                </div>	
                <div class="form-actions">
                    <input type="submit" class="btn-save" value="Edit">
                </div>
            </form>
        </div>
        
    </div>

	<!-- Edit HTML -->
	
</body>
</html>