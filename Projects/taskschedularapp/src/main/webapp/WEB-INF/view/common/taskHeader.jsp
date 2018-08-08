<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<header>
      <!-- Fixed navbar -->
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <h4 class="navbar-brand">Task Schedular App</h4>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse" >
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <a class="nav-link" href="./profile.ds">Profile</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="./addTask.ds">Add Task</a>
            </li>
            <li class="nav-item">
              <a class="nav-link " href="./updateTask.ds">Update Task</a>
            </li>
            
            <li class="nav-item">
              <a class="nav-link " href="./listTask.ds">List of Task</a>
            </li>
            <li class="nav-item">
              <a class="nav-link " href="./imports.ds">Import</a>
            </li>
             <li class="nav-item">
              <a class="nav-link " href="./showListByTitle.ds">List by Title</a>
            </li>
            <li class="nav-item">
              <a class="nav-link " href="./login.ds">Logout</a>
            </li>
          </ul>
          
          <form class="form-inline my-2 my-lg-0">
						<input class="form-control mr-sm-2" type="search"
							placeholder="Search your task.." aria-label="Search">
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
					</form>
          
        </div>
      </nav>
    </header>

</body>
</html>