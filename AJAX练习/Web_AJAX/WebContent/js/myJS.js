//创建XMLHttpRequest对象
function getXMLHttpRequest() {
	var XHRObject;
	if(window.XMLHttpRequest) {
		XHRObject = new XMLHttpRequest();
	} else {
		XHRObject = new ActiveXObject("Microsoft.XMLHTTP");
	}
	return XHRObject;
}