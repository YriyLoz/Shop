<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" href="webjars/bootstrap/4.4.1-1/css/bootstrap.min.css">
    <link href="css/shop-homepage.css" rel="stylesheet">
</head>
<body>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">Start Bootstrap</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/shop">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/cart">Cart</a>
                </li>
                <%--                if Login show logout--%>
                <li class="nav-item">
                    <a class="nav-link" href="/logout">logout</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/login">login</a>
                    <%--                if Logout show login--%>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Page Content -->
<div class="container">

    <div class="row">
        <div class="col-lg-3">
            <h2 class="my-4">Colors</h2>
            <div class="list-group">
                <c:forEach var="color" items="${colorFilter}">
                    <a href="./shop?color=<c:out value="${color}"/>" class="list-group-item"><c:out
                            value="${color}"/></a>
                </c:forEach>
<%--                <a href="./shop?reset=filter" class="btn btn-primary list-group-item text-secondary" role="button"--%>
<%--                   aria-pressed="true">Reset</a>--%>
            </div>
            <h2 class="my-4">Producer</h2>
            <div class="list-group">
                <c:forEach var="producer" items="${producerFilter}">
                    <a href="./shop?producer=<c:out value="${producer}"/>" class="list-group-item"><c:out value="${producer}"/></a>
                </c:forEach>
                <a href="./shop?reset=filter" class="btn btn-primary list-group-item text-secondary" role="button"
                   aria-pressed="true">Reset</a>
            </div>
        </div>
        <div class="col-lg-9">
            <img src="img/main_img.jpg" class="img-fluid" alt="Responsive image"/>
            <div class="row">
                <c:forEach var="product" items="${productList}">
                    <div class="col-lg-4 col-md-6 mb-4">
                        <div class="card h-100">
                            <a href="./product?product_id=${product.id}"><img class="card-img-top" src="img/product.jpg"
                                                                             alt=""/></a>
                            <div class="card-body">
                                <h4 class="card-title">
                                    <a href="./product?product_id=${product.id}"><c:out value="${product.name}"/></a>
                                </h4>
                                <h5>$<c:out value="${product.price}"/></h5>
                                <p class="card-text"><c:out value="${product.type}"/></p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<script src="webjars/jquery-3.4.1.slim.min.js"></script>
<script src="webjars/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="webjars/bootstrap/4.4.1-1/js/bootstrap.min.js"></script>
</body>
</html>
