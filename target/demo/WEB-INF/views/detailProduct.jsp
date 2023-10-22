<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!-- using JSTL -->
<%@ taglib uri="jakarta.tags.core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang chủ</title>

    <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />

    <!-- font awesome cdn link  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />

    <!-- custom css file link  -->
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/detail.css">

    

</head>
<body>
    
<!-- header section starts  -->

<header class="header">

    <section class="flex">
    
<a href="#" class="logo"> <i class="fas fa-shopping-basket"></i> group 6 </a>

    <nav class="navbar">
        <a href="#home">Trang chủ</a>
        <a href="#features">Tính Năng</a>
        <a href="#products">Sản Phẩm</a>
        <a href="#categories">Danh Mục</a>
        <a href="#review">Đánh Giá</a>
        <a href="#blogs">Bài Viết</a>
        <c:if test="${sessionScope.acc.isAdmin == 1}">
            <a href="admin">Admin</a>
        </c:if>
    </nav>

    <div class="icons">
        <div class="fas fa-bars" id="menu-btn"></div>
        <div class="fas fa-search" id="search-btn"></div>
        <div class="fas fa-shopping-cart" id="cart-btn"></div>
        <div class="fas fa-user" id="login-btn"></div>
    </div>

    <form action="" class="search-form">
        <input type="search" id="search-box" placeholder="search here...">
        <label for="search-box" class="fas fa-search"></label>
    </form>

    <div class="shopping-cart">
        <div class="box">
            <i class="fas fa-trash"></i>
            <img src="image/cart-img-1.png" alt="">
            <div class="content">
                <h3>Dưa hấu 2kg </h3>
                <span class="price">21.900₫</span>
                <span class="quantity">qty : 1</span>
            </div>
        </div>
        <div class="box">
            <i class="fas fa-trash"></i>
            <img src="image/cart-img-2.png" alt="">
            <div class="content">
                <h3>Hành Tím  </h3>
                <span class="price">15.000₫</span>
                <span class="quantity">qty : 1</span>
            </div>
        </div>
        <div class="box">
            <i class="fas fa-trash"></i>
            <img src="image/cart-img-3.png" alt="">
            <div class="content">
                <h3>Gà Công Nghiệp nguyên con 1kg-1.3kg</h3>
                <span class="price">69.000₫</span>
                <span class="quantity">qty : 1</span>
            </div>
        </div>
        <div class="total"> tổng :105.900 </div>
        <a href="#" class="btn">checkout</a>
    </div>

    <form action="login" method="post" class="login-form">
        <c:if test="${sessionScope.acc != null}">
            <div class="greetings">
                <p>
                  <i class="fa fa-user"></i>
                  Xin chào, ${sessionScope.acc.user}
                </p>
                <a href="logout" class="btn btn-logout">
                  <i class="fa fa-sign-out"></i>
                  Logout
                </a>
            </div>
        </c:if>
        <c:if test="${sessionScope.acc == null}">
            <h3>login now</h3>
            <input name = "user" type="text" placeholder="your email" class="box">
            <input name = "pass" type="password" placeholder="your password" class="box">
            <p>forget your password <a href="#">click here</a></p>
            <p>don't have an account <a href="signup">create now</a></p>
            <input type="submit" value="login now" class="btn">
        </c:if>
    </form>

    </section>

</header>

<!-- header section ends -->

<!-- body section starts  -->
<div class = "card-wrapper">
    <div class = "card">
      <!-- card left -->
      <div class = "product-imgs">
        <div class = "img-display">
          <div class = "img-showcase">
            <img src = "image/shoe_1.jpg" alt = "shoe image">
            <img src = "image/shoe_2.jpg" alt = "shoe image">
            <img src = "image/shoe_3.jpg" alt = "shoe image">
            <img src = "image/shoe_4.jpg" alt = "shoe image">
          </div>
        </div>
        <div class = "img-select">
          <div class = "img-item">
            <a href = "#" data-id = "1">
              <img src = "image/shoe_1.jpg" alt = "shoe image">
            </a>
          </div>
          <div class = "img-item">
            <a href = "#" data-id = "2">
              <img src = "image/shoe_2.jpg" alt = "shoe image">
            </a>
          </div>
          <div class = "img-item">
            <a href = "#" data-id = "3">
              <img src = "image/shoe_3.jpg" alt = "shoe image">
            </a>
          </div>
          <div class = "img-item">
            <a href = "#" data-id = "4">
              <img src = "image/shoe_4.jpg" alt = "shoe image">
            </a>
          </div>
        </div>
      </div>
      <!-- card right -->
      <div class = "product-content">
        <h2 class = "product-title">nike shoes</h2>
        <a href = "#" class = "product-link">visit nike store</a>
        <div class = "product-rating">
          <i class = "fas fa-star"></i>
          <i class = "fas fa-star"></i>
          <i class = "fas fa-star"></i>
          <i class = "fas fa-star"></i>
          <i class = "fas fa-star-half-alt"></i>
          <span>4.7(21)</span>
        </div>

        <div class = "product-price">
          <p class = "last-price">Old Price: <span>$257.00</span></p>
          <p class = "new-price">New Price: <span>$249.00 (5%)</span></p>
        </div>

        <div class = "product-detail">
          <h2>about this item: </h2>
          <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Illo eveniet veniam tempora fuga tenetur placeat sapiente architecto illum soluta consequuntur, aspernatur quidem at sequi ipsa!</p>
          <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Consequatur, perferendis eius. Dignissimos, labore suscipit. Unde.</p>
          <ul>
            <li>Color: <span>Black</span></li>
            <li>Available: <span>in stock</span></li>
            <li>Category: <span>Shoes</span></li>
            <li>Shipping Area: <span>All over the world</span></li>
            <li>Shipping Fee: <span>Free</span></li>
          </ul>
        </div>

        <div class = "purchase-info">
          <input type = "number" min = "0" value = "1">
          <button type = "button" class = "btn">
            Add to Cart <i class = "fas fa-shopping-cart"></i>
          </button>
          <button type = "button" class = "btn">Compare</button>
        </div>

        <div class = "social-links">
          <p>Share At: </p>
          <a href = "#">
            <i class = "fab fa-facebook-f"></i>
          </a>
          <a href = "#">
            <i class = "fab fa-twitter"></i>
          </a>
          <a href = "#">
            <i class = "fab fa-instagram"></i>
          </a>
          <a href = "#">
            <i class = "fab fa-whatsapp"></i>
          </a>
          <a href = "#">
            <i class = "fab fa-pinterest"></i>
          </a>
        </div>
      </div>
    </div>
  </div>
<!-- body section ends  -->

<!-- footer section starts  -->

<section class="footer">

    <div class="box-container">

        <div class="box">
            <h3> groco <i class="fas fa-shopping-basket"></i> </h3>
            <p>Thực Phẩm Sạch Cho Gia Đình Việt. Nơi lựa chọn thực phẩm sạch </p>
            <div class="share">
                <a href="#" class="fab fa-facebook-f"></a>
                <a href="#" class="fab fa-twitter"></a>
                <a href="#" class="fab fa-instagram"></a>
                <a href="#" class="fab fa-linkedin"></a>
            </div>
        </div>

        <div class="box">
            <h3>contact info</h3>
            <a href="#" class="links"> <i class="fas fa-phone"></i> +123-456-7890 </a>
            <a href="#" class="links"> <i class="fas fa-phone"></i> +111-222-3333 </a>
            <a href="#" class="links"> <i class="fas fa-envelope"></i> PM06@gmail.com </a>
            <a href="#" class="links"> <i class="fas fa-map-marker-alt"></i> TPHCM GIA DINH</a>
        </div>

        <div class="box">
            <h3>quick links</h3>
            <a href="#" class="links"> <i class="fas fa-arrow-right"></i> home </a>
            <a href="#" class="links"> <i class="fas fa-arrow-right"></i> features </a>
            <a href="#" class="links"> <i class="fas fa-arrow-right"></i> products </a>
            <a href="#" class="links"> <i class="fas fa-arrow-right"></i> categories </a>
            <a href="#" class="links"> <i class="fas fa-arrow-right"></i> review </a>
            <a href="#" class="links"> <i class="fas fa-arrow-right"></i> blogs </a>
        </div>

        <div class="box">
            <h3>newsletter</h3>
            <p>subscribe for latest updates</p>
            <input type="email" placeholder="your email" class="email">
            <input type="submit" value="subscribe" class="btn">
            <img src="image/payment.png" class="payment-img" alt="">
        </div>

    </div>

</section>

<!-- footer section ends  -->

<script src="https://unpkg.com/swiper@7/swiper-bundle.min.js"></script>

<!-- custom js file link  -->
<script src="js/script.js"></script>
<script src="js/detail.js"></script>

</body>
</html>