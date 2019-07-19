<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <!-- Sidebar -->
      <ul class="sidebar navbar-nav">
        <li class="nav-item active">
          <a class="nav-link" href="index.html">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>后台首页</span>
          </a>
        </li>
<!--         <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-folder"></i>
            <span>文章管理</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <h6 class="dropdown-header">Login Screens:</h6>
            <a class="dropdown-item" href="login.html">Login</a>
            <a class="dropdown-item" href="register.html">Register</a>
            <a class="dropdown-item" href="forgot-password.html">Forgot Password</a>
            <div class="dropdown-divider"></div>
            <h6 class="dropdown-header">Other Pages:</h6>
            <a class="dropdown-item" href="404.html">404 Page</a>
            <a class="dropdown-item" href="blank.html">Blank Page</a>
          </div>
        </li> -->
        <li class="nav-item">
          <a class="nav-link" href="/admin/categories">
            <i class="fas fa-fw fa-folder"></i>
            <span>文章管理</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/admin/categories">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>用户管理</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/admin/categories">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>分类管理</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/admin/settings">
            <i class="fas fa-fw fa-table"></i>
            <span>系统设置</span></a>
        </li>
      </ul>