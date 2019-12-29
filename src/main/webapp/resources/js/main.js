/*function multiply(num1, num2) {
	var total = num1 * num2;
	alert(total);	
}

//multiply(10,2);

function convertToCelsius(temp) {
		var result = temp - 32;
		result = result / 1.8;
		return result; b n	
}
*/
function showPic(whichpic) {
	var source = whichpic.getAttribute("href");
	
	var placeholder = document.getElementById("placeholder");
	
	placeholder.setAttribute("src",source);
	
	var titletext = whichpic.getAttribute("title");
	return false;
};

window.onload = function() {
	if(!document.getElementsByTagName) return false;
	if(!document.getElementById) return false;
	if(!document.getElementById("imagegallery")) return false;
	
	var imagegallery = document.getElementById("imagegallery");
	var aList = imagegallery.getElementsByTagName("a");
	for(var i = 0; i < aList.length; i++) {
		aList[i].onclick = function() {
			showPic(this);
		}
	}	
}