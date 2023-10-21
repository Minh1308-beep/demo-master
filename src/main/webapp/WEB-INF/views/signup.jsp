<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!-- using JSTL -->
<%@ taglib uri="jakarta.tags.core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Sign in & Sign up Form</title>
    <link rel="stylesheet" href="css/app.css" />
  </head>
  <body>
    <main>
      <div class="box">
        <div class="inner-box">
          <div class="forms-wrap">
            
            <form action="signup" method = "post" class="sign-up-form">
              <div class="logo">
                <a href="home">
                  <img src="image/pp.png" alt="" />
                </a>
                <h4>Group 6</h4>
              </div>

              <div class="heading">
                <h2>Đăng Ký</h2>
                <h6>Bạn đã có tài khoản?</h6>
                <a href="#" class="toggle">Sign in</a>
              </div>

              <div class="actual-form">
                <div class="input-wrap">
                  <input
                    name="user"
                    type="text"
                    id="user-name"
                    minlength="4"
                    class="input-field"
                    autocomplete="off"
                    required
                  />
                  <label>Name</label>
                </div>

                <div class="input-wrap">
                  <input
                    name="pass"
                    id="user-pass"
                    type="password"
                    class="input-field"
                    autocomplete="off"
                    required
                  />
                  <label>Password</label>
                </div>

                <div class="input-wrap">
                  <input
                    name="repass"
                    type="password"
                    id="user-repeatpass"
                    minlength="4"
                    class="input-field"
                    autocomplete="off"
                    required
                  />
                  <label>Re-Password</label>
                </div>

                <input type="submit" value="Sign Up" class="sign-btn" />

                <p class="text">
                  By signing up, I agree to the
                  <a href="#">Terms of Services</a> and
                  <a href="#">Privacy Policy</a>
                </p>
              </div>
            </form>

            <form action="login" method="post" class="sign-in-form">
              <div class="logo">
                <a href="home">
                  <img src="image/pp.png" alt="" />
                </a>
                <h4>Group 6</h4>
              </div>

              <div class="heading">
                <h2>Đăng Nhập</h2>
                <h6>Bạn không có tài khoản?</h6>
                <a href="#" class="toggle">Sign up</a>
              </div>

              <p style="color: red" >${mess}</p>
              <div class="actual-form">
                <div class="input-wrap">
                  <input
                    name="user"
                    type="text"
                    minlength="4"
                    id="inputEmail"
                    class="input-field"
                    autocomplete="off"
                    required
                  />
                  <label>Name</label>
                </div>

                <div class="input-wrap">
                  <input
                    name="pass"
                    type="password"
                    minlength="4"
                    id="inputPassword"
                    class="input-field"
                    autocomplete="off"
                    required
                  />
                  <label>Password</label>
                </div>

                <input type="submit" value="Sign In" class="sign-btn" />

                <p class="text">
                  Forgotten your password or you login details?
                  <a href="#">Get help</a> signing in
                </p>
              </div>
            </form>
          </div>

          <div class="carousel">
            <div class="images-wrapper">
              <img src="image/image1.png" class="image img-1 show" alt="" />
              <img src="image/image2.png" class="image img-2" alt="" />
              <img src="image/image3.png" class="image img-3" alt="" />
            </div>

            <div class="text-slider">
              <div class="text-wrap">
                <div class="text-group">
                  <h2>Mua sắm trực tuyến</h2>
                  <h2>Nhanh chóng và tiện lợi</h2>
                  <h2>Hãy mua theo cách của bạn</h2>
                </div>
              </div>

              <div class="bullets">
                <span class="active" data-value="1"></span>
                <span data-value="2"></span>
                <span data-value="3"></span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>

    <!-- Javascript file -->

    <script src="js/app.js"></script>
  </body>
</html>

