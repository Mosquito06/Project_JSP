function startLoading(parent, text){
	
	var $divContainer = $("<div id='loadingContainer'></div>");
	
	var $divLoader = $("<div id='loader'></div>");
	
	var $divTop = $("<div id='top'></div>");
	
	var $divBottom = $("<div id='bottom'></div>");

	var $divLine = $("<div id='line'></div>");
	
	var $divText = $("<div id='loadingTest'></div>");
	$divText.text(text);
	
	$divLoader.append($divTop).append($divBottom).append($divLine);
	
	$divContainer.append($divLoader).append($divText);
	
	parent.append($divContainer);
}

function stopLoading(parent){
	parent.find("#loadingContainer").remove();
}