let sidebar = document.querySelector(".sidebar");
let btn = document.querySelector("#btn");
// let searchBtn = document.querySelector(".bx-search");
let logout = document.querySelector("#logout");

btn.onclick = function () {
  sidebar.classList.toggle("active");
};
// searchBtn.onclick = function () {
//   sidebar.classList.toggle("active");
// };
logout.onclick = function () {
  sidebar.classList.toggle("active");
};
