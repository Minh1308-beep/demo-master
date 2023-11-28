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
<script src="js/admin.js"></script>

  <body>
    <div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="admin">Admin Dashboard</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
			  <span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
			  <ul class="navbar-nav">
				<li class="nav-item">
				  	<a class="nav-link" href="admin">Products</a>
				</li>
				<li class="nav-item">
				 	<a class="nav-link" href="category">Categories</a>
				</li>
				<li class="nav-item">
				  	<a class="nav-link" href="#">Accounts</a>
				</li>
			  </ul>
			</div>
			<ul class="nav navbar-nav navbar-right"> 
				<li class="nav-item">
					<a class="nav-link" href="home">
						<span class="return-icon">Back &rarr;</span>
					</a>
				</li>
			</ul>
		  </nav>
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
						<h2>Manage <b>Products</b></h2>
					</div>
					<div class="col-sm-6">
						<a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Product</span></a>
						<a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>						
					</div>
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
						<th>
							<span class="custom-checkbox">
								<input type="checkbox" id="selectAll">
								<label for="selectAll"></label>
							</span>
						</th>
                        <th>ID</th>
                        <th>Name</th>
						<th>Price</th>
                        <th>Quantity</th>
						<th>Description</th>
						<th>Image</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listPP}" var="o">
					<tr>
						<td>
							<span class="custom-checkbox">
								<input type="checkbox" id="checkbox1" name="options[]" value="1">
								<label for="checkbox1"></label>
							</span>
						</td>
						<td>${o.id}</td>
						<td>${o.name}</td>
						<td>${o.price}.000đ</td>
						<td>${o.quantity}sl</td>
						<td>${o.description}</td>
						<td>
							<img src= ${o.image} style="width: 100px; height: 100px">
						</td>
						<td>
							<a href="#">
								<img src="" alt="" />
							</a>
							<a href="editProduct?pid=${o.id}">
								<img src="image/edit.svg" alt="Update" width="20" height="20"/>
							</a>							
							<a href="#">
								<img src="" alt="" />
							</a>
							<a href="deleteProduct?pid=${o.id}">
								<img src="image/delete.svg" alt="Remove" width="20" height="20"/>
							</a>
						</td>
					</tr>
					</c:forEach>
                </tbody>
            </table>
			<div class="clearfix">
                <div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>
                <ul class="pagination">
                    <li class="page-item disabled"><a href="#">Previous</a></li>
                    <li class="page-item active"><a href="#" class="page-link">1</a></li>
                    <li class="page-item"><a href="#" class="page-link">2</a></li>
                    <li class="page-item"><a href="#" class="page-link">3</a></li>
                    <li class="page-item"><a href="#" class="page-link">4</a></li>
                    <li class="page-item"><a href="#" class="page-link">5</a></li>
                    <li class="page-item"><a href="#" class="page-link">Next</a></li>
                </ul>
            </div>
        </div>
    </div>
	<!-- Edit Modal HTML -->
	<div id="addEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form method="post" action="addProduct">
					<div class="modal-header">						
						<h4 class="modal-title">Add Products</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						<div class="form-group">
							<label>Name</label>
							<input name="name" type="text" class="form-control" style="font-size: 16px;" required>
						</div>
						<div class="form-group">
							<label>Price</label>
							<input name="price" class="form-control" style="font-size: 16px;" required>
						</div>
						<div class="form-group">
							<label>Image</label>
							<input name="image" type="text" class="form-control" style="font-size: 16px;" required>
						</div>
						<div class="form-group">
							<label>Category</label>
							<select name="category" aria-label="Default select example" class="form-select">
								<c:forEach items="${listCC}" var="c">
									<option value="${c.cid}">${c.cname}</option>
								</c:forEach>
							</select>
						</div>	
						<div class="form-group">
							<label>Quantity</label>
							<input name="quantity" type="text" class="form-control" style="font-size: 16px;" required>
						</div>
						<div class="form-group">
							<label>Description</label>
							<input name="description" type="text" class="form-control" style="font-size: 16px;" required>
						</div>					
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
						<input type="submit" class="btn btn-success" value="Add">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Delete Modal HTML -->
	<div id="deleteEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Delete Employee</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						<p>Are you sure you want to delete these Records?</p>
						<p class="text-warning"><small>This action cannot be undone.</small></p>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
						<input type="submit" class="btn btn-danger" value="Delete">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>