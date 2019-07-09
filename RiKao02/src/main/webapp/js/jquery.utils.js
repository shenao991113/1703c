
function serializeForm(fromid){
	var param = {};
	var result = $("#"+fromid).serializeArray();
	for ( var i in result) {
		if(param[result[i].name]){
			param[result[i].name] += ","+result[i].value;
		}else {
			param[result[i].name] = result[i].value;
		}
	}
	return param;
}


//--------------格式化日期
Number.prototype.app0 = function(){
	return this>9?this:"0"+this;
}

//prototype 使你有能力给一个对象添加方法和属性
//yyyy-mm-dd
Date.prototype.format=function(formatter){
	var y=this.getFullYear(),m=this.getMonth()+1,d=this.getDate();
	var n={
		"yyyy":y,
		"MM":m.app0(),
		"dd":d.app0()
	}
	return formatter.replace(/[a-zA-Z]+/g,function(a){
		return n[a];
	});
}
	

