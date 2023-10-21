$(document).ready(function(){
	// Activate tooltip
	$('[data-toggle="tooltip"]').tooltip();
	
	// Select/Deselect checkboxes
	var checkbox = $('table tbody input[type="checkbox"]');
	$("#selectAll").click(function(){
		if(this.checked){
			checkbox.each(function(){
				this.checked = true;                        
			});
		} else{
			checkbox.each(function(){
				this.checked = false;                        
			});
		} 
	});
	checkbox.click(function(){
		if(!this.checked){
			$("#selectAll").prop("checked", false);
		}
	});
});
document.addEventListener("DOMContentLoaded", function () {
	var listItems = document.querySelectorAll(".navbar-nav li");
  
	listItems.forEach(function (item) {
	  item.addEventListener("click", function () {
		// Loại bỏ bôi đậm từ tất cả các thẻ <li>
		listItems.forEach(function (li) {
		  li.classList.remove("active");
		});
  
		// Bôi đậm thẻ <li> được click
		item.classList.add("active");
	  });
	});
  });
